package cn.dhbin.minion.core.generate;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Map;

/**
 * @author donghaibin
 * @date 2020/3/28
 */
public class MinionVelocityTemplateEngine extends VelocityTemplateEngine {


    @Override
    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        Map<String, Object> objectMap = super.getObjectMap(tableInfo);
        // 首字母小写的Entity名称
        objectMap.put("firstLowerEntityName", StrUtil.lowerFirst(tableInfo.getEntityName()));
        // 首字母小写的服务名
        objectMap.put("firstLowerServiceName", StrUtil.lowerFirst(tableInfo.getServiceName()));
        return objectMap;
    }

}
