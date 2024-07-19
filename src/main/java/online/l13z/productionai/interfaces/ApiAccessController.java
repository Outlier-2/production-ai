package online.l13z.productionai.interfaces;

import online.l13z.productionai.domain.security.service.JwtUtil;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.HashMap;
    import java.util.Map;
    /**
     * ClassName: ApiAccessController.java <br>
     *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-07-19 07:28 <br> Description: 认证控制器 <br>
 * <p>
 * Modification History: <br> - 2024/7/19 AlfredOrlando 认证控制器 <br>
 */
@RestController
public class ApiAccessController {

    private final Logger logger = LoggerFactory.getLogger(ApiAccessController.class);

    /**
     * <a href="http://localhost:8080/authorize?username=AlfredOrlando&password=123">...</a>
     */
    @RequestMapping("/authorize")
    public ResponseEntity<Map<String, String>> authorize(String username, String password) {
        Map<String, String> map = new HashMap<>();
        // 模拟账号和密码校验
        if (!"AlfredOrlando".equals(username) || !"123".equals(password)) {
            map.put("msg", "用户名密码错误");
            return ResponseEntity.ok(map);
        }
        // 校验通过生成token
        JwtUtil jwtUtil = new JwtUtil();
        Map<String, Object> chaim = new HashMap<>();
        chaim.put("username", username);
        String jwtToken = jwtUtil.encode(username, 5 * 60 * 1000, chaim);
        map.put("msg", "授权成功");
        map.put("token", jwtToken);
        // 返回token码
        return ResponseEntity.ok(map);
    }

    /**
     * <a href="http://localhost:8080/verify?token=">...</a>
     */
    @RequestMapping("/verify")
    public ResponseEntity<String> verify(String token) {
        logger.info("验证 token：{}", token);
        return ResponseEntity.status(HttpStatus.OK).body("verify success!");
    }

    @RequestMapping("/success")
    public String success(){
        return "test success by production-ai";
    }

}
