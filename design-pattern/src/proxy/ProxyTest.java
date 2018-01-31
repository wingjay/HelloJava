package proxy;

import proxy.calculator.CalculatorFactory;
import proxy.calculator.ICalculator;
import proxy.httpRecorder.HttpLogger;
import proxy.httpRecorder.IHandler;
import proxy.httpRecorder.RequestHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wingjay on 06/11/2017.
 */
public class ProxyTest {

    public static void main(String[] args) {
        testHttpLogging(new RequestHandler.Request("https://google.com", "key=value"));
        testHttpLogging(new RequestHandler.Request("https://baidu.com", "key2=value2"));
//        testISubject();
//        testMap();
    }

    private static void testHttpLogging(RequestHandler.Request request) {
        IHandler handler = (IHandler) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class[]{IHandler.class},
                new HttpLogger(new RequestHandler()));
        handler.handle(request);
    }
    private static void testCalculator() {
        ICalculator c = CalculatorFactory.provideCalculator();
        c.calculate();
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
        InvocationHandler proxy = new MethodTimingProxy(new RealSubject());

        ISubject iSubject = (ISubject) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[]{ ISubject.class }, proxy);
        iSubject.request();
        iSubject.asyncRequest("xiami.com");
    }
}
