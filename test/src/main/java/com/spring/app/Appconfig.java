package com.spring.app;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.test"})
//开启动态代理
@EnableAspectJAutoProxy()
/*EnableAspectJAutoProxy介绍
1 开启aop功能
2 EnableAspectJAutoProxy 点进去会发现  会给容器注册一个AnnotationAwareAspectJAutoProxyCreator组件
3 AnnotationAwareAspectJAutoProxyCreator 是一个后置处理器
4 registerBeanPostProcessors(beanFactory); 会注册后置处理器
5 finishBeanFactoryInitialization(beanFactory); 创建业务逻辑组件和切面组件 （后置处理器会拦截创建过程） 组件创建完之后
判断组件是否需要增强 是切面通知 包装为advisor
6 执行目标方法 代理对象执行目标方法 用CglibAopProxy。intercept()方法进行拦截 利用拦截器的链式机制 依次执行通知方法
  效果
  正常执行链：前置通知---》目标方法---》后置通知---》返回通知
  出现异常情况：前置通知---》目标方法---》后置通知---》异常通知
 */
public class Appconfig {

}