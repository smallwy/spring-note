package com.spring.ext;


import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/*@Component*/
public class MyApplIster {


	@EventListener
	@Async
	public void handler(AventType aventType) {

		if(aventType.getId()==1) {
			System.out.println("处理接受的时间" + aventType.getId() + aventType.getName());
		}
	}
}