package classloader;

/**
 * LocalClassCopy will be loaded by FileSystemClassLoader
 */
public class LocalClassCopy {

    public void print() {
        System.out.println("Hi Here is LocalClassCopy");
    }

    private LocalClassCopy instance;
    public void setInstance(Object instance) {
        this.instance = (LocalClassCopy) instance;
    }

}
