package singleton;

import java.util.Random;

/**
 * Created by Jay on 3/24/17.
 */
public enum SingleEnum implements HelloSingleInstance.ITestSingleInstance {
    INSTANCE;

    private final static Random random = new Random();
    private static int id;

    public static SingleEnum getInstance() {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        id = random.nextInt(1000);
        return INSTANCE;
    }

    @Override
    public int getId() {
        return id;
    }
}