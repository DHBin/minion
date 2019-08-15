package cn.dhbin.minion.core.mybatis.config;

import cn.dhbin.minion.core.mybatis.methods.UpdateStatus;
import cn.dhbin.minion.core.mybatis.methods.UpdateStatusById;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
 * @author donghaibin
 * @date 2019-08-14
 */
public class MinionSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new UpdateStatusById());
        methodList.add(new UpdateStatus());
        return methodList;
    }
}
