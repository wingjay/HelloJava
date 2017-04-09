package singleton;

import java.util.Random;

/**
 * Created by Jay on 3/24/17.
 */
public class BadSingleInstance implements HelloSingleInstance.ITestSingleInstance {
    private final static Random random = new Random();
    private int id = random.nextInt(1000);

    private static BadSingleInstance INSTANCE;

    private BadSingleInstance() {}

    public static BadSingleInstance getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            INSTANCE = new BadSingleInstance();
        }
        return INSTANCE;
    }

    @Override
    public int getId() {
        return id;
    }
}