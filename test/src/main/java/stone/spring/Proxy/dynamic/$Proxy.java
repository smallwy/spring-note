package stone.spring.Proxy.dynamic;

import stone.spring.Proxy.Dao;

public class $Proxy implements Dao {
	public Dao target;

	public $Proxy(Dao target) {
		this.target = target;
	}

	public String find(String p) {
		System.out.println("开始执行日志");
		return target.find(p);
	}

	public void search(String p) {
		System.out.println("开始执行日志");
		target.search(p);
	}
}