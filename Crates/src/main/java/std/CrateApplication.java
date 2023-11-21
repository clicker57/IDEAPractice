package std;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Philip
 */
@SpringBootApplication
@ComponentScan("std.service")
@MapperScan("std.dao")
public class CrateApplication {
}
