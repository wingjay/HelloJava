package proxy.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wingjay on 31/01/2018.
 */
public class LoggerProxy implements InvocationHandler {
    private Object target;

    public LoggerProxy(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("calculate")) {
            System.out.println("Start calculate");
        }
        Object result = method.invoke(target, args);
        if (method.getName().equals("calculate")) {
            System.out.println("End calculate");
        }
        return result;
    }
}
