package cn.dhbin.minion.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author donghaibin
 * @date 2019/9/1
 */
@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
public class MinionUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinionUpmsApplication.class, args);
    }

}
