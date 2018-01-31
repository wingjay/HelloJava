package proxy.calculator;

import java.lang.reflect.Proxy;

/**
 * Created by wingjay on 31/01/2018.
 */
public class CalculatorFactory {
    public static ICalculator provideCalculator() {
        ElecCalculator c = new ElecCalculator();
        return (ICalculator) Proxy.newProxyInstance(CalculatorFactory.class.getClassLoader(),
                new Class[]{ICalculator.class}, new LoggerProxy(c));
    }
}
