package cn.dhbin.minion.core.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static cn.dhbin.minion.core.mybatis.config.EntityConstant.*;

/**
 * 表基础信息填充
 *
 * @author donghaibin
 * @date 2019-08-12
 */
@Component
@ConditionalOnBean(IUserInfoProvider.class)
@Configuration
@RequiredArgsConstructor
@Slf4j
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    private final IUserInfoProvider userInfo;

    @Override
    public void insertFill(MetaObject metaObject) {
        final Long uid = userInfo.getUid();
        setInsertFieldValByName(CREATE_TIME, LocalDateTime.now(), metaObject);
        setInsertFieldValByName(CREATE_UID, uid, metaObject);
        setInsertFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
        setInsertFieldValByName(UPDATE_UID, uid, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        final Long uid = userInfo.getUid();
        setUpdateFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
        setUpdateFieldValByName(UPDATE_UID, uid, metaObject);
    }

}
