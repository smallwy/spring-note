package stone.spring.SourceCode1;


import org.springframework.stereotype.Component;

@Component
public class UserDao {

	public void print(){
		System.out.println("执行UserDao操作");
	}
}