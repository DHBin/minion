package cn.dhbin.minion.auth;

import cn.dhbin.core.security.annotation.EnableMinionAuthorizationServer;
import cn.dhbin.minion.core.dubbo.annotation.EnableExposeWeb;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author donghaibin
 * @date 2019/9/3
 */
@SpringBootApplication
@EnableDubbo
@EnableExposeWeb
@EnableMinionAuthorizationServer
public class MinionAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinionAuthApplication.class, args);
    }
}
