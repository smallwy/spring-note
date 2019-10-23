package stone.spring.SourceCode1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.addBeanFactoryPostProcessor(new MyBeanPostProcesser());
		applicationContext.refresh();
		UserDao userDao= (UserDao) applicationContext.getBean("userDao");
		userDao.print();
	}
}