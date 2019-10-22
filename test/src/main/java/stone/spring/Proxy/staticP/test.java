package stone.spring.Proxy.staticP;

import stone.spring.Proxy.Dao;

public class test {
	public static void main(String[] args) {
		/*--------------------------静态代理--------------------------------------*/
		/*ProxyDao userDao=new ProxyDao();
		userDao.query();*/  //继承代理
		//聚合 实现
		/*Dao dao=new UserDao();
		logTargetDao logTargetDao=new logTargetDao(dao);
		timeTargetDao targetDao=new timeTargetDao(logTargetDao);
		targetDao.find();*/
		//静态代理的实现由继承和聚合。缺点都会产生类爆炸  就是每增加业务都需要增加类

		/*--------------------------动态代理--------------------------------------*/
	}
}