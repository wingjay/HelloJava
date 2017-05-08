package classloader;


import sun.misc.Launcher;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * Created by Jay on 5/4/17.
 */
public class HelloClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
//        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
//        for (int i = 0; i < urls.length; i++) {
//            System.out.println(urls[i].toExternalForm());
//        }

//        loadExtLibClass();
//        loadClass();
        // mock String class
//        mockStringClass();

        // fileSystemClassLoader, load ~/Desktop/LocalClassCopy , print()
//        loadFileSystemClass();
        // different classloader will load different class
//        loadClassByDifferentLoader();

        // load Network class. load http://localhost/java/classloader/NetworkClass.class, it's under /Library/WebServer/Documents directory
        loadNetworkClass();
    }

    private static void loadNetworkClass() throws ClassNotFoundException {
        String className = "classloader.NetworkClass";
        NetworkClassLoader networkClassLoader = new NetworkClassLoader();
        Class<?> clazz  = networkClassLoader.loadClass(className);

        Method printMethod = null;
        try {
            printMethod = clazz.getDeclaredMethod("print", null);
            printMethod.invoke(clazz.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void loadFileSystemClass() throws ClassNotFoundException {
        String className = "classloader.LocalClassCopy";
        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader();
        Class<?> clazz = fileSystemClassLoader.loadClass(className);

        try {
            Method printMethod = clazz.getDeclaredMethod("print", null);
            printMethod.invoke(clazz.newInstance(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void loadClassByDifferentLoader() throws ClassNotFoundException {
        FileSystemClassLoader classLoader1 = new FileSystemClassLoader();
        FileSystemClassLoader classLoader2 = new FileSystemClassLoader();

        Class clazz1 = classLoader1.loadClass("classloader.LocalClass");
        Class clazz2 = classLoader2.loadClass("classloader.LocalClass");

//        System.out.println(ClassLoader.getSystemClassLoader()); // AppClassLoader
        System.out.println(clazz1.getClassLoader()); // FileSystemClassLoader
        System.out.println(clazz2.getClassLoader()); // FileSystemClassLoader

        try {
            Object object1 = clazz1.newInstance();
            Method printMethod = clazz1.getDeclaredMethod("print", null);
            printMethod.invoke(object1);

            Method setInstanceMethod = clazz1.getMethod("setInstance", Object.class);
            Object object2 = clazz2.newInstance();
            setInstanceMethod.invoke(object1, object2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void mockStringClass() throws ClassNotFoundException {
        Class<?> stringClass = Class.forName("java.lang.String");
        try {
            Method printNameMethod = stringClass.getMethod("printName", null); // NoSuchMethodException
            System.out.printf("printNameMethod = %s", (printNameMethod == null));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void loadClass() throws ClassNotFoundException {
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz1 = appClassLoader.loadClass("classloader.MusicPlayer");
        System.out.println(clazz1.getClassLoader());

        Class<?> clazz2 = Class.forName("classloader.MusicPlayer2");
        ClassLoader classLoader = clazz2.getClassLoader();
        System.out.println(classLoader);

        Class<?> clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3.getClassLoader());

        Class<?> clazz4 = new NetworkClassLoader().loadClass("java.lang.String");
        System.out.println(clazz4.getClassLoader());
    }

    private static void loadExtLibClass() {
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
