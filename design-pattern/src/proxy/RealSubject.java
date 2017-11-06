package proxy;

/**
 * Created by wingjay on 06/11/2017.
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("RealSubject request");
    }

    @Override
    public void asyncRequest(String url) {
        System.out.println("Ready for async request: " + url);
        try {
            Thread.sleep(1000);
            System.out.println("Finish async request: " + url);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
