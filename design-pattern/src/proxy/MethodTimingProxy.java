package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wingjay on 06/11/2017.
 */
public class MethodTimingProxy implements InvocationHandler {

    private Object target;

    public MethodTimingProxy(Object realObject) {
        this.target = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startNano = System.nanoTime();

        if (method.getName().equals("get") && args.length > 0 && args[0].equals("Second")) {
            return "Hacked For key: Second";
        }
        Object result = method.invoke(target, args);
        System.out.println(String.format("methods %s, consume time: %s", method.getName(), System.nanoTime() - startNano));
        return result;
    }
}
