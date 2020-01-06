package cn.dhbin.minion.upms;

import cn.dhbin.core.security.annotation.EnableMinionResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author donghaibin
 * @date 2019/9/1
 */
@SpringBootApplication
@EnableMinionResourceServer
public class MinionUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinionUpmsApplication.class, args);
    }

}
