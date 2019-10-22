package com.spring.ext;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理：
 * BeanPostProcessor bean后置处理器，在bean初始化前后进行拦截工作的
 * BeanFactoryPostProcessor beanFactory的后置处理器 在所有的bean定义已经保存加载到beanFactory 但是bean 的实例还未创建
 *
 */

@Configuration
@ComponentScan("com.test.ext")
public class ExtConfig {

}


/**
* Ioc创建对象
 *
 * 	invokeBeanFactoryPostProcessors(beanFactory); 从工厂中如果找到BeanFactoryPostProcessors
 * 		String[] postProcessorNames =
 * 				beanFactory.getBeanNamesForType(BeanFactoryPostProcessor.class, true, false);
 * 			这个方法拿到所有实现	BeanFactoryPostProcessor 组件的类
 * 		 然后是执行每个组件对应的	postProcessBeanDefinitionRegistry方法
 * 		是在bean对象初始化前面
 *
 * 	BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *
 *
 * 	BeanDefinitionRegistry优先于BeanFactoryPostProcessor执行
 *
 *
*/