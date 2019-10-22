package stone.spring.Aop;

import org.springframework.stereotype.Component;

@Component(value = "target")
public class TargetService implements TargetInface {

	@Override
	public void print(){
		System.out.println("原始对象的服务");
	}


	@Anno
	@Override
	public  void printeresting1(){
		System.out.println("原始对象的服务printeresting1");
	}
}