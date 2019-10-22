package stone.spring.SourceCode1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		UserDao userDao= (UserDao) applicationContext.getBean("userDao");
		userDao.print();
	}
}