package singleton;

import java.util.Random;

/**
 * Created by Jay on 3/24/17.
 */
public class SingleJay implements HelloSingleInstance.ITestSingleInstance {
    private final static Random random = new Random();
    private int id = random.nextInt(1000);

    @Override
    public int getId() {
        return id;
    }

    private static final SingleJay INSTANCE = new SingleJay();

    private SingleJay() {}

    public static SingleJay getInstance() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }
}