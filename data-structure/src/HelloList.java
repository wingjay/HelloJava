import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jay on 4/17/17.
 */
public class HelloList {

    public static void main(String[] args) {
        // ArrayList, LinkedList, Vector
        // CopyOnWriteList

        //1. ArrayList 查询比 LinkedList 快
//        querySpeed();

        //2. LinkedList 比 ArrayList 插入快
//        insertSpeed();

        //3. LinkedList 比 ArrayList 删除快
//        removeSpeed();

    }

    private static void querySpeed() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        int size = 50000;
        for (int i=0; i<size; i++) {
            arrayList.add(String.valueOf(i));
            linkedList.add(String.valueOf(i));
        }

        long start = System.currentTimeMillis();
        for (int j=size-1; j>=0; j--) {
            arrayList.get(j);
        }
        System.out.println("Query ArrayList needs time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int j=size-1; j>=0; j--) {
            linkedList.get(j);
        }
        System.out.println("Query LinkedList needs time: " + (System.currentTimeMillis() - start));
    }

    private static void insertSpeed() {
        int size = 100000;
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            arrayList.add(0, String.valueOf(i));
        }
        System.out.println("Insert ArrayList needs time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            linkedList.add(0, String.valueOf(i));
        }
        System.out.println("Insert LinkedList needs time: " + (System.currentTimeMillis() - start));
    }

    private static void removeSpeed() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        int size = 50000;
        for (int i=0; i<size; i++) {
            arrayList.add(String.valueOf(i));
            linkedList.add(String.valueOf(i));
        }

        System.out.println("test " + arrayList.size());
        long start = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            System.out.println("i: " + i);
            System.out.println("size: " + arrayList.size());
            arrayList.remove(i);
        }
        System.out.println("Remove ArrayList needs time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i=0; i<size; i++) {
            linkedList.remove(i);
        }
        System.out.println("Remove LinkedList needs time: " + (System.currentTimeMillis() - start));
    }

}
