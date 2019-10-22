package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


@Component
public class BeanProcessor implements BeanFactoryPostProcessor {


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
/*		GenericBeanDefinition definition= (GenericBeanDefinition) beanFactory.getBeanDefinition("c");
		System.out.println(definition.getBeanClassName());
		definition.setBeanClass(CarService.class);*/
	}
}