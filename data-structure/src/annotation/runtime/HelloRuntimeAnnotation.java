package annotation.runtime;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * Created by Jay on 4/21/17.
 */
public class HelloRuntimeAnnotation {

    public static void main(String[] args) {
        UserBean userBean = new UserBean("Jay", 100);
//        printAlias(userBean);
//        System.out.println(objectToMap(userBean));
//
        doTest(userBean);
    }

    /**
     * print alias during runtime
     */
    private static void printAlias(Object userBeanObject) {
        for (Field field : userBeanObject.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Alias.class)) {
                Alias alias = field.getAnnotation(Alias.class);
                System.out.println(alias.value());
            }
        }
    }

    /**
     * Convert Object to HashMap, key is Annotation value
     */
    private static HashMap<String, Object> objectToMap(Object object) {
        HashMap<String, Object> map = new HashMap<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Alias.class)) {
                Alias alia = field.getAnnotation(Alias.class);
                try {
                    if (field.getType() == int.class) {
                        System.out.printf("field: %s is int type \n", field.getName());
                    } else if (field.getType() == double.class) {
                        System.out.printf("fields: %s is double type \n", field.getName());
                    } else if (field.getType() == String.class || field.getType() == long.class) {
                        System.out.printf("fields: %s is String/long type \n", field.getName());
                    }
                    map.put(alia.value(), field.get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return map;
    }

    /**
     * Test methods which are be annotated with @Test
     */
    private static void doTest(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                try {
                    String methodName = test.value().length() == 0 ? method.getName() : test.value();
                    System.out.printf("Testing. methodName: %s, id: %s\n", methodName, test.id());

                    // static method
                    if (Modifier.isStatic(method.getModifiers())) {
                        method.invoke(null);
                    } else if (Modifier.isPrivate(method.getModifiers())) {
                        // private method
                        method.setAccessible(true);
                        method.invoke(object);
                    } else {
                        // public method
                        method.invoke(object);
                    }

                    System.out.printf("PASS: Method id: %s\n", test.id());
                } catch (Exception e) {
                    System.out.printf("FAIL: Method id: %s\n", test.id());
                    e.printStackTrace();
                }
            }
        }
    }

}
