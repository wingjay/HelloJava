package equals_hashcode;

import java.util.HashMap;

/**
 * REMEMBER: ** if a.equals(b), then a.hashcode() must equal to b.hashcode(). It's a rule in Java **
 */
public class HelloEqualsHashcode {

    public static void main(String[] args) {
//        testEqualsNonHashcode();

        testEqualsHashcode();

//        testStringEquals();
    }

    private static void testStringEquals() {
        String x = "First";
        String y = "First";
        String z = new String("First");
        System.out.println(x.equals(x));
        System.out.println((x.equals(y) && y.equals(x)));
        if (x.equals(y) && y.equals(x)) {
            System.out.println(x.equals(z));
        }
        System.out.println(x.equals(null));

        System.out.println("aa".hashCode());
    }

    private static void testEqualsHashcode() {
        PhoneNumber p1 = new PhoneNumber(86, 12);
        PhoneNumber p2 = new PhoneNumber(86, 12);
        System.out.println("p1.equals(p2)=" + p1.equals(p2));
        System.out.println("p1.hashcode()=" + p1.hashCode());
        System.out.println("p2.hashcode()=" + p2.hashCode());


        HashMap<PhoneNumber, String> map = new HashMap<>(2);
        map.put(p1, "Jay");
        System.out.println("testEqualsHashcode Name must be Jay: " + map.get(p2));
        // different object in HashMap, but same result.
    }

    private static void testEqualsNonHashcode() {
        PhoneNumberWithoutHashcode p1 = new PhoneNumberWithoutHashcode(86, 123123);
        PhoneNumberWithoutHashcode p2 = new PhoneNumberWithoutHashcode(86, 123123);
        System.out.println("p1.equals(p2)=" + p1.equals(p2));
        System.out.println("p1.hashcode()=" + p1.hashCode());
        System.out.println("p2.hashcode()=" + p2.hashCode());


        int p1hash=0;
        int p2hash=0;
        p1hash = (p1.hashCode()) ^ (p1hash >>> 16);
        p2hash = (p2.hashCode()) ^ (p2hash >>> 16);
        System.out.println("p1 hash() " + p1hash);
        System.out.println("p2 hash() " + p2hash);

//        HashMap<PhoneNumberWithoutHashcode, String> map = new HashMap<>(2);
//        map.put(new PhoneNumberWithoutHashcode(86, 123123), "Jay");
//        System.out.println("testEqualsNonHashcode Name must be Jay: " + map.get(new PhoneNumberWithoutHashcode(86, 123)));
    }

}