package stone.spring.Proxy.staticP;

import stone.spring.Proxy.Dao;

public class logTargetDao  {
	public Dao dao;
	public logTargetDao (Dao dao) {
		this.dao=dao;
	}

	public void find() {
		System.out.println("开始执行日志");
	}


}