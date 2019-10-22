package stone.spring.Proxy;

public class UserDao implements Dao {
	public void query(){

	}

	public void find() {
		System.out.println("开始查找数据库");
	}

	@Override
	public String find(String str) {
		System.out.println("开始查找数据库");
		return null;
	}

	@Override
	public void search(String str) {
		System.out.println("开始盘算");
	}
}