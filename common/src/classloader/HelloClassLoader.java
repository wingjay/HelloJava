package classloader;


/**
 * Created by Jay on 5/4/17.
 */
public class HelloClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
//        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }

    }

    private void loadExtLibClass() {
        // mv MusicPlayer.jar into jre/lib/ext/
        ClassLoader classLoader = new NetworkClassLoader();
        classLoader = classLoader.getParent().getParent(); // ExtClassLoader
        System.out.println(classLoader);
        try {
            classLoader.loadClass("classloader.MusicPlayer"); // this is in jre/lib/ext/
            classLoader.loadClass("classloader.MusicPlayer2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
