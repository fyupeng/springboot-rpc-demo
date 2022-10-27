package cn.fyupeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import lombok.extern.slf4j.Slf4j;


/**
 * @Auther: fyp
 * @Date: 2022/8/13
 * @Description:
 * @Package: cn.fyupeng
 * @Version: 1.0
 */

@SpringBootApplication
@ComponentScan(basePackages = {"cn.fyupeng","org.utils"})
public class SpringBootClientStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootClientStarter.class, args);
    }
}
