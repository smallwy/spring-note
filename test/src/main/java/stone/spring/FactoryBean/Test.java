package stone.spring.FactoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
		//自己手动注册
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();


		DaoFactoryBean daoFactoryBean= (DaoFactoryBean) applicationContext.getBean("&daoFactoryBean");
		TestFactoryBean testFactoryBean= (TestFactoryBean) applicationContext.getBean("daoFactoryBean");
		testFactoryBean.print();
		daoFactoryBean.testBean();
		TestFactoryBean object= (TestFactoryBean) daoFactoryBean.getObject();
		object.print();
	}
}