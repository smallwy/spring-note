package stone.spring.SourceCode3;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
/*如果加上@Configuration 则会将该类cglib增强*/
@ComponentScan("stone.spring.SourceCode2")
public class AppConfig {

}