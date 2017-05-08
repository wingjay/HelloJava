package classloader;

import java.io.*;

/**
 * Load Class from file system
 */
public class FileSystemClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassDataFromFile(name);
        if (classData == null) {
            return super.findClass(name);
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassDataFromFile(String name) {
        String localPath = "/Users/Jay" + File.separatorChar + "Desktop" + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
        System.out.printf("localPath: %s\n", localPath);

        try {
            InputStream inputStream = new FileInputStream(localPath);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize]; // 4KB
            int bytesNumRead = 0;
            while ((bytesNumRead = inputStream.read(buffer)) != -1) {
                System.out.printf("bytesNumRead: %s bytes\n", bytesNumRead);
                byteArrayOutputStream.write(buffer, 0, bytesNumRead);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
