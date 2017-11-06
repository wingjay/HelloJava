package proxy;

/**
 * Created by wingjay on 06/11/2017.
 */
public interface ISubject {

    void request();

    void asyncRequest(String url);

}
