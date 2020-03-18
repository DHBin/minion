package cn.dhbin.minion.core.mybatis.config;

import cn.dhbin.minion.core.common.IUserInfoProvider;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

import static cn.dhbin.minion.core.mybatis.constant.EntityConstant.*;

/**
 * 表基础信息填充
 *
 * @author donghaibin
 * @date 2019-08-12
 */
@RequiredArgsConstructor
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    private final IUserInfoProvider userInfo;

    @Override
    public void insertFill(MetaObject metaObject) {
        final Long uid = userInfo.getUid();
        strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, CREATE_UID, Long.class, uid);
        strictInsertFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, UPDATE_UID, Long.class, uid);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        final Long uid = userInfo.getUid();
        strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        strictUpdateFill(metaObject, UPDATE_UID, Long.class, uid);
    }

}
