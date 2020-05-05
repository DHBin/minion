package cn.dhbin.core.security.server;

import cn.dhbin.minion.core.common.model.Page;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.oauth2.common.util.DefaultJdbcListFactory;
import org.springframework.security.oauth2.common.util.JdbcListFactory;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 扩展{@link org.springframework.security.oauth2.provider.client.JdbcClientDetailsService}
 * 提供分页查询
 *
 * @author donghaibin
 * @date 2020/5/1
 */
@Slf4j
@Component
public class PaginationJdbcClientDetailsServiceImpl extends JdbcClientDetailsService implements MinionClientRegistrationService {


    private static final String CLIENT_FIELDS_FOR_UPDATE = "resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    private static final String CLIENT_FIELDS = "client_secret, " + CLIENT_FIELDS_FOR_UPDATE;

    private static final String BASE_FIND_STATEMENT = "select client_id, " + CLIENT_FIELDS
            + " from oauth_client_details";
    /**
     * 默认 token 过期时间 12小时
     */
    private static final Integer DEFAULT_ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60 * 12;
    /**
     * 默认 30 天
     */
    private static final Integer DEFAULT_REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30;
    /**
     * client_secret 加密算法标识
     */
    private static final String CLIENT_SECRET_ENCRYPT_TYPE_FLAG = "{noop}";
    private final JdbcTemplate jdbcTemplate;
    private final JdbcListFactory listFactory;
    private final RowMapper<ClientDetails> rowMapper = new ClientDetailsRowMapper();
    /**
     * 分页sql模板
     */
    @Setter
    private String pageClientDetailSql = BASE_FIND_STATEMENT + " limit :offset, :size";
    @Setter
    private String querySizeSql = "select count(1) from oauth_client_details";


    public PaginationJdbcClientDetailsServiceImpl(DataSource dataSource) {
        super(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.listFactory = new DefaultJdbcListFactory(new NamedParameterJdbcTemplate(jdbcTemplate));
    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        preCheck(clientDetails);
        super.updateClientDetails(clientDetails);
    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        secret = StrUtil.concat(true, CLIENT_SECRET_ENCRYPT_TYPE_FLAG, secret);
        super.updateClientSecret(clientId, secret);
    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        preCheck(clientDetails);
        super.addClientDetails(clientDetails);
    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return super.listClientDetails().stream().peek(this::removeClientSecretEncryptFlag).collect(Collectors.toList());
    }

    @Override
    public Page<ClientDetails> pageClientDetails(Integer current, Integer size) {
        HashMap<String, Object> parameter = CollUtil.newHashMap(2);
        parameter.put("offset", current * size);
        parameter.put("size", size);
        List<ClientDetails> list = listFactory.getList(pageClientDetailSql, parameter, rowMapper)
                .stream().peek(this::removeClientSecretEncryptFlag)
                .collect(Collectors.toList());
        Integer total = jdbcTemplate.queryForObject(querySizeSql, Integer.class);
        Page<ClientDetails> page = new Page<>();
        page.setCurrent(current)
                .setSize(size)
                .setTotal(total)
                .setRecords(list);
        return page;
    }

    private void removeClientSecretEncryptFlag(ClientDetails clientDetails) {
        if (clientDetails instanceof BaseClientDetails) {
            ((BaseClientDetails) clientDetails).setClientSecret(StrUtil.subSuf(clientDetails.getClientSecret(), CLIENT_SECRET_ENCRYPT_TYPE_FLAG.length()));
        }
    }

    private void preCheck(ClientDetails clientDetails) {
        if (clientDetails instanceof BaseClientDetails) {
            if (clientDetails.getAccessTokenValiditySeconds() == null) {
                ((BaseClientDetails) clientDetails).setAccessTokenValiditySeconds(DEFAULT_ACCESS_TOKEN_VALIDITY_SECONDS);
            }
            if (clientDetails.getRefreshTokenValiditySeconds() == null) {
                ((BaseClientDetails) clientDetails).setRefreshTokenValiditySeconds(DEFAULT_REFRESH_TOKEN_VALIDITY_SECONDS);
            }
            ((BaseClientDetails) clientDetails).setClientSecret(StrUtil.concat(true, CLIENT_SECRET_ENCRYPT_TYPE_FLAG, clientDetails.getClientSecret()));
        }
    }

    /**
     * Row mapper for ClientDetails.
     *
     * @author Dave Syer
     */
    private static class ClientDetailsRowMapper implements RowMapper<ClientDetails> {

        @Override
        public ClientDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
            BaseClientDetails details = new BaseClientDetails(rs.getString(1), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(7), rs.getString(6));
            details.setClientSecret(rs.getString(2));
            if (rs.getObject(8) != null) {
                details.setAccessTokenValiditySeconds(rs.getInt(8));
            }
            if (rs.getObject(9) != null) {
                details.setRefreshTokenValiditySeconds(rs.getInt(9));
            }
            String json = rs.getString(10);
            if (json != null) {
                try {
                    Map<String, Object> additionalInformation = JSONUtil.parseObj(json);
                    details.setAdditionalInformation(additionalInformation);
                } catch (Exception e) {
                    log.warn("Could not decode JSON for additional information: " + details, e);
                }
            }
            String scopes = rs.getString(11);
            if (scopes != null) {
                details.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(scopes));
            }
            return details;
        }
    }

}
