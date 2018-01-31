package proxy.httpRecorder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by wingjay on 31/01/2018.
 */
public class HttpLogger implements InvocationHandler {
    private Object target;
    public HttpLogger(Object o) {
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("handle")
                && args[0].getClass() == RequestHandler.Request.class) {
            RequestHandler.Request r = (RequestHandler.Request) args[0];
            System.out.println("Request. Url: " + r.url + "; params: " + r.params);
            RequestHandler.Response response = (RequestHandler.Response) method.invoke(target, args);
            System.out.println("Response. StatusCode: " + response.statusCode + "; response: " + response.response);
            return response;
        }
        return method.invoke(target, args);
    }
}
