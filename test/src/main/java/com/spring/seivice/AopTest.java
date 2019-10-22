package com.spring.seivice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;


/*@Component*/
public class AopTest implements BeanPostProcessor {


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		/*if(beanName.equals("c")){
			Class<?> anInterface = bean.getClass().getInterfaces()[0];
			Class[] cs=new Class[]{anInterface};
			Object object=Proxy.newProxyInstance(AopTest.class.getClassLoader(),cs,new Handler(bean));
			return object;
		}*/
		return bean;
	}
}