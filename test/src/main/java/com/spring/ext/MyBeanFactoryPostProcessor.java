package com.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/*@Component*/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		/*System.out.println("MyBeanFactoryPostProcessor执行了");

		int count=beanFactory.getBeanDefinitionCount();
		System.out.println("当前有"+count+"个bean");
		String[] beanNames=beanFactory.getBeanDefinitionNames();
		System.out.println("beanFactory"+beanNames);
		System.out.println(Arrays.asList(beanNames));*/

	}
}