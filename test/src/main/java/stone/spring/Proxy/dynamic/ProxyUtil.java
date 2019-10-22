package stone.spring.Proxy.dynamic;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/***
 *
 * 手写实现代理对象的实现
 */
public class ProxyUtil {

	public static Object newInstance(Object target) {
		Object proxy = null;
		try {
			String tab = "\t";
			String line = "\n";
			Class targetInfo = target.getClass().getInterfaces()[0];
			String packageName = "package stone.spring.Proxy.dynamic;" + line;
			Method[] methods = targetInfo.getDeclaredMethods();//获取该类下的所有方法
			String className = targetInfo.getSimpleName();
			String wholeClassName = targetInfo.getName();
			String importClassName = "import   " + wholeClassName + ";" + "" + line;

			String classCreate = "public class" + "  $Proxy" + "  implements    " + className + " {" + line;
			String attribute = tab + "public   " + className + "  " + "target;" + line;
			String contructMethod = tab + "public   $Proxy  " + "(" + className + " " + "target" + "){" + line +
					tab + "this.target=target;" + line +
					tab + tab + "}" + line;
			String methodConten = "";
			for (Method method : methods) {
				String returnType = method.getReturnType().getSimpleName();//返回类型
				String methodName = method.getName();//方法名
				Class[] args = method.getParameterTypes();//参数
				String argsContent = "";
				String paramContent = "";
				int flag = 0;
				for (Class arg : args) {
					String temp = arg.getSimpleName();
					// String P1,String P2
					argsContent += temp + " p" + flag + ",";
					paramContent += " p" + flag + ",";
					flag++;
				}
				if (argsContent.length() > 0) {
					argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
					paramContent = paramContent.substring(0, paramContent.lastIndexOf(",") - 1);
				}
				methodConten += tab + "public  " + returnType + " " + methodName + " " + "(" + argsContent + " " + "){" + line +
						tab + tab + "System.out.println(\"开始执行日志\");" + line;
				if (returnType.equals("void")) {
					methodConten += tab + tab + "target." + methodName + "(" + paramContent + ");" + line +
							"}" + line;
				} else {
					methodConten += tab + tab + "return target." + methodName + "(" + paramContent + ");" + line +
							"}" + line;
				}
			}
			String wholeClass = packageName + importClassName + classCreate + attribute + contructMethod + methodConten + line + "}";
			File file = new File("C:\\spring-framework\\test\\src\\main\\java\\stone\\spring\\Proxy\\dynamic\\$Proxy.java");
			try {
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(wholeClass);
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			//下面是手动将类进行编译
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
			Iterable units = fileManager.getJavaFileObjects(file);
			JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
			t.call();
			fileManager.close();

			URL[] uris = new URL[]{new URL("file:C:\\\\")};
			URLClassLoader urlClassLoader = new URLClassLoader(uris);
			Class clazz = urlClassLoader.loadClass("stone.spring.Proxy.dynamic.$Proxy");
			Constructor constructor = clazz.getConstructor(targetInfo);
			proxy = constructor.newInstance(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proxy;
	}
}