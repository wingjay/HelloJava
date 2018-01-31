package proxy.httpRecorder;

/**
 * Created by wingjay on 31/01/2018.
 */
public interface IHandler {
    RequestHandler.Response handle(RequestHandler.Request request);
}
