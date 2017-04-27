package reflection;

import annotation.UserBean;

import java.lang.reflect.*;

/**
 * Created by Jay on 4/25/17.
 */
public class HelloReflection {


    public static void main(String[] args) {
//        printClass(UserBean.class);

        printClass(UserBean.class);
//        invokeMethod();
    }


    private static void printClass(String classPath) {
        try {
            printClass(Class.forName(classPath));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printClass(Class clazz) {
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();

        System.out.println("Fields: ");
        for (Field field : fields) {
            _printField(field);
        }
        _emptyLine();

        System.out.println("DeclaredFields: ");
        for (Field field : declaredFields) {
            _printField(field);
        }
        _emptyLine();

        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        System.out.println("methods: ");
        for (Method method : methods) {
            _printMethod(method);
        }
        _emptyLine();

        System.out.println("declaredMethods: ");
        for (Method method : declaredMethods) {
            _printMethod(method);
        }
        _emptyLine();

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        System.out.println("DeclaredConstructors: ");
        for (Constructor constructor : declaredConstructors) {
            _printConstructor(constructor);
        }
        _emptyLine();

        String packageName = clazz.getPackage().getName();
        String className = clazz.getName();
        String superName = clazz.getSuperclass().getName();
        System.out.printf("PackageName: %s, className: %s, superName: %s", packageName, className, superName);
    }

    private static void invokeMethod() {
        Class clazz = Calculator.class;

        Integer addResult;
        try {
            Method method = clazz.getMethod("add", new Class[]{int.class, int.class});
            addResult = (Integer) method.invoke(new Calculator(), 1, 2);
            System.out.printf("add result: %s", String.valueOf(addResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printObject(Object object) {

    }

    private static void _printField(Field field) {
        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
    }

    private static void _printMethod(Method method) {
        String methodString = Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "(";
        Class[] clazzList = method.getParameterTypes();
        for (Class clazz : clazzList) {
            methodString += clazz.getSimpleName() + " ";
        }
        methodString += ")";
        System.out.println(methodString);
    }

    private static void _printConstructor(Constructor constructor) {
        String constructorString = constructor.getName() + "(";
        Class[] types = constructor.getParameterTypes();
        for (Class type : types) {
            constructorString += type.getSimpleName() + " ";
        }
        constructorString += ")";
        System.out.println(constructorString);
    }

    private static void _emptyLine() {
        System.out.println("\n\n");
    }

}


