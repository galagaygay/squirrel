package in.hocg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@SpringBootApplication
@MapperScan("in.hocg.squirrel.sample.module.mapper")
public class SquirrelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SquirrelApplication.class, args);
    }
}
