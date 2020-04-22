package cn.dhbin.minion.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 监控服务端
 *
 * @author donghaibin
 * @date 2019/12/30
 */
@SpringBootApplication
@EnableAdminServer
public class MinionMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinionMonitorApplication.class, args);
    }

}
