package cn.dhbin.minion.upms.service.impl.password;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Slf4j
public class PasswordGen {

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Test
    public void create() {
        String encode = passwordEncoder.encode("password");
        log.info(encode);
    }
}
