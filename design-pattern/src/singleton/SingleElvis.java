package singleton;

import java.util.Random;

/**
 * Created by Jay on 3/24/17.
 */
public class SingleElvis implements HelloSingleInstance.ITestSingleInstance {

    private final static Random random = new Random();
    private int id = random.nextInt(1000);

    private static final SingleElvis INSTANCE = new SingleElvis();

    private SingleElvis() {
        throw new AssertionError();

    }

    public static SingleElvis getInstance() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    @Override
    public int getId() {
        return id;
    }
}