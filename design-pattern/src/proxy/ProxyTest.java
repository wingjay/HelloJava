package proxy;

import proxy.httpRecorder.HttpLoggerProxy;
import proxy.httpRecorder.IHandler;
import proxy.httpRecorder.RequestHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wingjay on 06/11/2017.
 */
public class ProxyTest {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        testISubject();
//        testMap();
//        testHttpLogging(new RequestHandler.Request("https://google.com", "key=value"));
//        testHttpLogging(new RequestHandler.Request("https://baidu.com", "key2=value2"));
    }

    private static void testISubject() {
        ISubject iSubject = (ISubject) new MethodTimingProxy().bind(new RealSubject());
        iSubject.doA();
    }

    private static void testMap() {
        Map map = (Map) new MethodTimingProxy().bind(new HashMap<>());
        map.put("First", "1");
        map.put("Second", "2");
        System.out.println(map.get("First"));
        System.out.println(map.get("Second"));
    }

    private static void testHttpLogging(RequestHandler.Request request) {
        IHandler handler = (IHandler) new HttpLoggerProxy().bind(new RequestHandler());
        handler.handle(request);
    }

}
