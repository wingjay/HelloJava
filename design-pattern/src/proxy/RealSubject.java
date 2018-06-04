package proxy;

/**
 * Created by wingjay on 06/11/2017.
 */
public class RealSubject implements ISubject, ISecondSubject {
    @Override
    public void doA() {
        System.out.println("RealSubject doA");
    }

    @Override
    public void doB(String url) {
        System.out.println("RealSubject doB");
    }

    @Override
    public void doC() {
        System.out.println("RealSubject doC");
    }
}
