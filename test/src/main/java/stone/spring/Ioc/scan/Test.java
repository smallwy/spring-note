package stone.spring.Ioc.scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stone.spring.Ioc.scan.include.MyAnnotionBean;

public class Test {
	public static void main(String[] args) {
		//自定义注解将对象纳入到容器中
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		MyAnnotionBean indexDaoImp=  applicationContext.getBean(MyAnnotionBean.class);
		System.out.println(indexDaoImp);
	}
}