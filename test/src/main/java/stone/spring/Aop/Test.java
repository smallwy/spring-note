package stone.spring.Aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.*;
import java.lang.reflect.Proxy;


public class Test {
	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		TargetInface targetService= (TargetInface)applicationContext.getBean("orderDao");
		System.out.println(targetService);
	/*	targetService.printeresting1();
		System.out.println(targetService instanceof TargetInface);	//代理对象也实现TargetInface
		System.out.println(targetService);
		System.out.println(targetService instanceof TargetService); //已经是代理对象了*/

	/*	//还原jdk动态代理
		Class<?>[] interfaces=new Class[]{TargetInface.class};
		byte[] bytes=ProxyGenerator.generateProxyClass("stone",interfaces);
		File file=new File("d:\\Test.class");
		FileOutputStream writer=new FileOutputStream(file);
		InputStream is = new ByteArrayInputStream(bytes);
		byte[] buff = new byte[1024];
		int len = 0;
		while((len=is.read(buff))!=-1){
			writer.write(buff, 0, len);
		}
		is.close();
		writer.close();*/

	}
}