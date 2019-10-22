package com.spring.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class BeanDefineProcessortes implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

	@Autowired
	ApplicationContext applicationContext;
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {


		System.out.println("bean数量"+registry.getBeanDefinitionCount());
		RootBeanDefinition ac = new RootBeanDefinition();
		ac.setBeanClass(TestBean.class);
		registry.registerBeanDefinition("tb1", ac);

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
/*		RootBeanDefinition ac = new RootBeanDefinition();
		ac.setBeanClass(TestBean.class);
		beanFactory.registerSingleton("tb1",ac);*/

		System.out.println("bean数量"+beanFactory.getBeanDefinitionCount());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;

	}
}