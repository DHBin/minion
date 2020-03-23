package cn.dhbin.core.security.server;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

/**
 * @author donghaibin
 * @date 2019/9/3
 */
@Configuration
@EnableAuthorizationServer
@ComponentScan("cn.dhbin.core.security.server")
public class AuthorizationServerConfiguration extends OAuth2AuthorizationServerConfiguration {

    private final UserDetailsService userDetailsService;

    private final DataSource dataSource;

    private final TokenEnhancer tokenEnhancer;

    public AuthorizationServerConfiguration(BaseClientDetails details, AuthenticationConfiguration authenticationConfiguration,
                                            ObjectProvider<TokenStore> tokenStore, ObjectProvider<AccessTokenConverter> tokenConverter,
                                            AuthorizationServerProperties properties,
                                            DataSource dataSource,
                                            UserDetailsService userDetailsService,
                                            TokenEnhancer tokenEnhancer) throws Exception {
        super(details, authenticationConfiguration, tokenStore, tokenConverter, properties);
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
        this.tokenEnhancer = tokenEnhancer;
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        endpoints
                .reuseRefreshTokens(true)
                .tokenEnhancer(tokenEnhancer)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()");
    }
}
