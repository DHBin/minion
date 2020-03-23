package cn.dhbin.core.security.component;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author donghaibin
 * @date 2020/3/23
 */
public class MinionUser extends User {

    private static final long serialVersionUID = -2602439602167120235L;

    /**
     * 用户id
     *
     * @see cn.dhbin.core.security.Constant#USER_ID_KEY
     */
    @Getter
    private Object id;

    public MinionUser(Object id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

}
