package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Jay on 4/21/17.
 */
public class FruitUtil {

    public static void printFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println("fruitName: " + fruitName.value());
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println("fruitColor: " + fruitColor.color());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.printf("Provider id: %s, name: %s, address: %s", fruitProvider.id(), fruitProvider.name(), fruitProvider.address());
            }
        }
    }

}
