package online.l13z.productionai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: Application.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-07-19 05:59 <br> Description: 启动类 <br>
 * <p>
 * Modification History: <br> - 2024/7/19 AlfredOrlando 启动类 <br>
 */
@SpringBootApplication
@RestController
public class Application {

    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(String token) {
        logger.info("验证 token：{}", token);
        if ("success".equals(token)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/success")
    public String success() {
        return "success, welcome to production-ai!!!!!";
    }
}
