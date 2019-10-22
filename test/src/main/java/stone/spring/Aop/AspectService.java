package stone.spring.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect("perthis")
public class AspectService {

/*	@Pointcut("execution(* stone.spring.Aop.*.*(..))")
	public void handle(){
	}*/

/*	@Before("handle()")
	public void beforHandle(){
		System.out.println("执行目标方法之前执行"+0);
	}

	@After("handle()")
	public void AfterHandle(){
		System.out.println("执行目标方法之后执行"+1);
	}
*/

	@DeclareParents(value = "stone.spring.Aop.*",defaultImpl = TargetService.class)
	public  static  TargetInface targetInface;

	@Pointcut("@annotation(stone.spring.Aop.Anno)")
	public void anno(){
	}

	@Before("anno()")
	public void befo(JoinPoint joinPoint){
		joinPoint.getThis();
		System.out.println(joinPoint.getThis());
		System.out.println(joinPoint.getTarget());
		System.out.println("执行目标方法之前执行"+0);
	}

	@After("anno()")
	public void After(){
		System.out.println("执行目标方法之后执行"+1);
	}
}