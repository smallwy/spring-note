package stone.spring.FactoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


@Component
public class DaoFactoryBean implements FactoryBean<Object> {

	public void testBean(){
		System.out.println("我是DaoFactoryBean");
	}


	@Override
	public Object getObject() throws Exception {
		return new TestFactoryBean();
	}

	@Override
	public Class<?> getObjectType() {
		return TestFactoryBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}