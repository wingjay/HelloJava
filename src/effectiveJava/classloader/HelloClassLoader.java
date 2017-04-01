package effectiveJava.classloader;

/**
 * Created by Jay on 3/30/17.
 */
public class HelloClassLoader {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println("counter1="+Singleton.counter1);
        System.out.println("counter2="+Singleton.counter2);
    }

}
