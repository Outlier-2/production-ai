package online.l13z.productionai.domain.security.model.vo;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * ClassName: JwtToken.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-07-19 07:21 <br> Description:  <br>
 * <p>
 * Modification History: <br> - 2024/7/19 AlfredOrlando  <br>
 */
public class JwtToken implements AuthenticationToken {

    private String jwt;

    public JwtToken(String jwt) {
        this.jwt = jwt;
    }

    /**
     * 等同于账户
     */
    @Override
    public Object getPrincipal() {
        return jwt;
    }

    /**
     * 等同于密码
     */
    @Override
    public Object getCredentials() {
        return jwt;
    }

}

