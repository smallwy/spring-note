package com.spring.regist;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;



//自己注册一个bean
public class MyRegisterBean implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
										 BeanNameGenerator importBeanNameGenerator) {

		RootBeanDefinition beanDefinition=new RootBeanDefinition(Mybean.class);
		registry.registerBeanDefinition("rainbow",beanDefinition);
	}
}