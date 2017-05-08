package classloader;

/**
 * This will be loaded by FileSystemClassLoader
 */
public class LocalClassDuplicate {

    public void print() {
        System.out.println("I'm local Class");
    }

}
