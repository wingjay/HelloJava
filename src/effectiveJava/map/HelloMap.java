package effectiveJava.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Jay on 3/24/17.
 */
public class HelloMap {

    public static void main(String[] args) {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("key1", "value1");
        weakHashMap.put("key2", "value2");
        weakHashMap.get("key1");

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key1", "value1");
        linkedHashMap.put("key2", "value2");
        linkedHashMap.get("key1");
//        linkedHashMap.removeEldestEntry

        LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("key1", "value1");
        linkedHashMap2.put("key2", "value3");
        System.out.println("==? " + (linkedHashMap.equals(linkedHashMap2)));
    }

    // override
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    // overload
    public boolean equals(HelloMap obj) {return false;}


    // Map.equals(o)
//    public boolean equals(Object o) {
//        if (o == this)
//            return true;
//
//        if (!(o instanceof Map))
//            return false;
//        Map<?,?> m = (Map<?,?>) o;
//        if (m.size() != size())
//            return false;
//
//        try {
//            Iterator<Map.Entry<K,V>> i = entrySet().iterator();
//            while (i.hasNext()) {
//                Map.Entry<K,V> e = i.next();
//                K key = e.getKey();
//                V value = e.getValue();
//                if (value == null) {
//                    if (!(m.get(key)==null && m.containsKey(key)))
//                        return false;
//                } else {
//                    if (!value.equals(m.get(key)))
//                        return false;
//                }
//            }
//        } catch (ClassCastException unused) {
//            return false;
//        } catch (NullPointerException unused) {
//            return false;
//        }
//
//        return true;
//    }

    // Map.hashCode()
//    public int hashCode() {
//        int h = 0;
//        Iterator<Map.Entry<K,V>> i = entrySet().iterator();
//        while (i.hasNext())
//            h += i.next().hashCode();
//        return h;
//    }
}
