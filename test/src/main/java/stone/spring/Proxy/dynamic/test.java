package stone.spring.Proxy.dynamic;


import stone.spring.Proxy.Dao;
import stone.spring.Proxy.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {
	public static void main(String[] args) {
/*	//自定义代理
		try {
			Dao proxy = (Dao) ProxyUtil.newInstance( new UserDao());
			System.out.println(proxy);
			System.out.println(proxy.find("2222"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		//Jdk动态代理
		/*Dao proxyObject= (Dao) Proxy.newProxyInstance(test.class.getClassLoader(), new Class[]{Dao.class}, new MyInvocationHandler(new UserDao()) );{
		proxyObject.find("sss");*/


		Dao proxyObject=(Dao) Proxy.newProxyInstance(test.class.getClassLoader(), new Class[]{Dao.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				UserDao userDao=new UserDao();
				System.out.println("增强代理对象");
				return  method.invoke(userDao,args);
			}
		});
		proxyObject.find("");

	}
}