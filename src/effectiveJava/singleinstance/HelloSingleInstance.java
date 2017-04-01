package effectiveJava.singleinstance;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Three methods for single instance implementation.
 */
public class HelloSingleInstance {

    public static void main(String[] args) {
//        testSingleInstance(Type.BadSingleInstance);
//        testSingleInstance(Type.SingleEnum);
//        testSingleInstance(Type.SingleElvis);
        testSingleInstance(Type.SingleJay);
    }

    private static void testSingleInstance(Type type) {
        int count = 10;
        ArrayList<Integer> arrayList = new ArrayList<>(count);
        CountDownLatch latch = new CountDownLatch(count);
        for (int i=0; i<count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ITestSingleInstance singleInstance;
                    switch (type) {
                        case BadSingleInstance:
                            singleInstance = BadSingleInstance.getInstance();
                            break;
                        case SingleElvis:
                            singleInstance = SingleElvis.getInstance();
                            break;
                        case SingleJay:
                            singleInstance = SingleJay.getInstance();
                            break;
                        case SingleEnum:
                            singleInstance = SingleEnum.getInstance();
                            break;
                        default:
                            throw new IllegalArgumentException("wrong type");
                    }
                    System.out.println("singleElvis id: " + singleInstance.getId());
                    arrayList.add(singleInstance.getId());
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i=0; i<arrayList.size(); i++) {
            System.out.println("id: " + arrayList.get(i));
        }
    }

    enum Type {
        SingleElvis,
        SingleJay,
        BadSingleInstance,
        SingleEnum;
    }

    public interface ITestSingleInstance {
        int getId();
    }

}
