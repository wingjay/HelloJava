package annotation;

import java.lang.annotation.*;

import static annotation.FruitColor.Color.RED;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color {
        RED,
        GREEN,
        YELLOW
    }

    Color color() default RED;
}
