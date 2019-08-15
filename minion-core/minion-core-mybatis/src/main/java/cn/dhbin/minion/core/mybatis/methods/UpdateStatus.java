package cn.dhbin.minion.core.mybatis.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @author donghaibin
 * @date 2019/8/15
 */
public class UpdateStatus extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql = "<script>\nUPDATE %s set status = #{%s.status} WHERE %s=#{%s}\n</script>";
        sql = String.format(sql, tableInfo.getTableName(), ENTITY, tableInfo.getKeyColumn(), ENTITY_DOT + tableInfo.getKeyProperty());
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, Object.class);
        return this.addUpdateMappedStatement(mapperClass, modelClass, "updateStatus", sqlSource);
    }

}
