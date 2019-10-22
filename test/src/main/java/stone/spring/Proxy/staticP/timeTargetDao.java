package stone.spring.Proxy.staticP;

import stone.spring.Proxy.Dao;

public class timeTargetDao  {

	Dao dao;

	public timeTargetDao(Dao dao) {
		this.dao=dao;
	}


	public void find() {
		System.out.println("开始执行时间");

	}


}