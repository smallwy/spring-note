package stone.spring.Aop;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"stone.spring.Aop"})
@EnableAspectJAutoProxy(proxyTargetClass = false) //false为jdk动态代理  true时候用cglib代理
public class AppConfig {
}