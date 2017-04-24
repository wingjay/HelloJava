package annotation;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by Jay on 4/21/17.
 */
public class HelloAnnotation {

    public static void main(String[] args) {
        System.out.println(args.length);
        for (int i=0; i<args.length; i++) {
            System.out.println(args[i]);
        }

//        FruitUtil.printFruitInfo(Apple.class);

//        System.out.println(ClassToMap(UserBean.class));

//        printObject(new UserBean("Jay", 100, 19921103));

        System.out.println(objectToMap(new UserBean("Jay", 100, 19921103)));
    }

    private static HashMap<String, String> ClassToMap(Class<?> clazz) {
        HashMap<String, String> result = new HashMap<>();

        for (Field field : clazz.getFields()) {
            if (field.isAnnotationPresent(SerializedName.class)) {
                SerializedName serializedName = field.getAnnotation(SerializedName.class);
                result.put(serializedName.value(), field.getName());
            }
        }

        return result;
    }

    @Deprecated
    private static void printObject(Object object) {
        System.out.println("Print object directly");
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println("field: " + field.getName() + "; value: " + field.get(object).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

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

}
