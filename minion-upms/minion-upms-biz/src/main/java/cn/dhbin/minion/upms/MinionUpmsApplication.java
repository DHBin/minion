package cn.dhbin.minion.upms;

import cn.dhbin.core.security.annotation.EnableMinionResourceServer;
import cn.dhbin.minion.core.dubbo.annotation.EnableExposeWeb;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author donghaibin
 * @date 2019/9/1
 */
@SpringBootApplication
@EnableMinionResourceServer
@EnableDubbo
@EnableExposeWeb
@EnableCaching
@MapperScan("cn.dhbin.minion.upms.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class MinionUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinionUpmsApplication.class, args);
    }

}
