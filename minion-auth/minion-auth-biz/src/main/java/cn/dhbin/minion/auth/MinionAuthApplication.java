package cn.dhbin.minion.auth;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author donghaibin
 * @date 2019/9/3
 */
@SpringBootApplication
@EnableDubbo
public class MinionAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinionAuthApplication.class, args);
    }
}
