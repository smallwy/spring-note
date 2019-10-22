package com.spring.in;


import com.spring.regist.MyRegisterBean;
import com.spring.seivice.CarService;
import com.spring.selector.MyimportSelector;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


// 导入组件的三种方式
// Import直接导入类名
// MyimportSelector 导入一个数组的类名
// MyRegisterBean 自己注册一个bean
@Component("c")
@Import({CarService.class, MyimportSelector.class, MyRegisterBean.class})
public class TestService implements InitializingBean {
	CarService carService;

	public TestService(CarService carService) {
		System.out.println("--------------------------");
		this.carService = carService;
	}


	public void query() {
		System.out.println("query");
		carService.priint();

	}

	public void query1() {
		System.out.println("query1");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean初始化之后执行");
	}
}