package reflection;

import annotation.UserBean;

import java.lang.reflect.*;

/**
 * Created by Jay on 4/26/17.
 */
public class ForArticle {

    public static void main(String[] args) {
        UserBean userBean = new UserBean("Jay", 11);
//        printFieldsMethods(UserBean.class);
        try {
            invokeMethods(UserBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void invokeMethods(Class userBeanClass) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Method[] methods = userBeanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                if (Modifier.isStatic(method.getModifiers())) {
                    method.invoke(null, "wingjay");
                } else {
                    Class[] params = {String.class, long.class};
                    Constructor constructor = userBeanClass.getDeclaredConstructor(params);
                    Object userBean = constructor.newInstance("wingjay", 11);
                    if (Modifier.isPrivate(method.getModifiers())) {
                        method.setAccessible(true);
                    }
                    method.invoke(userBean);
                }
            }
        }
    }

    private static void printFieldsMethods(Class userBeanClass) {
        // fields
        Field[] fields = userBeanClass.getDeclaredFields();

        for(Field field : fields) {
            String fieldString = "";
            fieldString += Modifier.toString(field.getModifiers()) + " "; // `private`
            fieldString += field.getType().getSimpleName() + " "; // `String`
            fieldString += field.getName(); // `userName`
            fieldString += ";";
            System.out.println(fieldString);
        }

        _emptyLine();

        // methods
        Method[] methods = userBeanClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodString = Modifier.toString(method.getModifiers()) + " " ;
            methodString += method.getReturnType().getSimpleName() + " ";
            methodString += method.getName() + "(";
            Class[] parameters = method.getParameterTypes();
            for (Class parameter : parameters) {
                methodString += parameter.getSimpleName() + " ";
            }
            methodString += ")";
            System.out.println(methodString);
        }

        _emptyLine();

        // constructors
        Constructor[] constructors = userBeanClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String s = Modifier.toString(constructor.getModifiers()) + " ";
            s += constructor.getName() + "(";
            Class[] parameters = constructor.getParameterTypes();
            for (Class parameter : parameters) {
                s += parameter.getSimpleName() + ", ";
            }
            s += ")";
            System.out.println(s);
        }
    }

    private static void _emptyLine() {
        System.out.println("\n\n");
    }

}
