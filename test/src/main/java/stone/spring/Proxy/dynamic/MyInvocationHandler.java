package stone.spring.Proxy.dynamic;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	public  Object target;
	public MyInvocationHandler(Object target){
		this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行的逻辑");
		return  method.invoke(target,args);
	}
}