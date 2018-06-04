package proxy.httpRecorder;

/**
 * Created by wingjay on 31/01/2018.
 */
public class RequestHandler implements IHandler {

    @Override
    public Response handle(Request request) {
        System.out.println("Parse doA...");
        System.out.println("Read database...");
        System.out.println("Assemble result...");
        return new Response(200, "PersonJson");
    }

    public static class Request {
        public Request(String url, String params) {
            this.url = url;
            this.params = params;
        }
        String url;
        String params;
    }
    public static class Response {
        Response(int statusCode, String response) {
            this.statusCode = statusCode;
            this.response = response;
        }
        int statusCode;
        String response;
    }
}
