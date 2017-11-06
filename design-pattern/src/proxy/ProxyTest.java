package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wingjay on 06/11/2017.
 */
public class ProxyTest {

    public static void main(String[] args) {
//        testISubject();
        testMap();
    }

    private static void testMap() {
        Map map = (Map) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[] { Map.class }, new MethodTimingProxy(new HashMap<>()));

        map.put("First", "1");
        map.put("Second", "2");
        System.out.println(map.get("First"));
        System.out.println(map.get("Second"));
    }

    private static void testISubject() {
        RealSubject realSubject = new RealSubject();
        InvocationHandler proxy = new MethodTimingProxy(realSubject);

        Class clazz = realSubject.getClass();
        ISubject iSubject = (ISubject) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(), proxy);
        iSubject.request();
        iSubject.asyncRequest("xiami.com");
    }
}
