package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Jay on 4/21/17.
 */
public class HelloAnnotation {

    public static void main(String[] args) {
//        System.out.println(objectToMap(new UserBean("Jay", 100, 19921103)));

        UserBean userBean = new UserBean("Jay", 100);
        doTest(userBean);
    }

    /**
     * Convert Object to HashMap, key is Annotation value
     */
    private static HashMap<String, Object> objectToMap(Object object) {
        HashMap<String, Object> map = new HashMap<>();

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SerializedName.class)) {
                SerializedName serializedName = field.getAnnotation(SerializedName.class);
                try {
                    if (field.getType() == int.class) {
                        System.out.printf("field: %s is int type \n", field.getName());
                    } else if (field.getType() == double.class) {
                        System.out.printf("fields: %s is double type \n", field.getName());
                    } else if (field.getType() == String.class || field.getType() == long.class) {
                        System.out.printf("fields: %s is String/long type \n", field.getName());
                    }
                    map.put(serializedName.value(), field.get(object));
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
        int pass = 0;
        int fail = 0;
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(object);
                    pass++;
                } catch (Exception e) {
                    fail++;
                    e.printStackTrace();
                }
            }
        }

        System.out.printf("Test Pass Result: %s/%s", pass, pass+fail);
    }

}
