/*Before.java ��ǰ֪ͨ*/
package edu.hdu.spring.aop;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
public class Before implements MethodBeforeAdvice {
public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
System.out.println("��òˣ�");
}
}

/*After.java ֮��֪ͨ*/
