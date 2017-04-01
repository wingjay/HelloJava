import java.util.ArrayList;

/**
 * Created by Jay on 2/19/17.
 */
public class HelloList {

    public static void main(String [] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

}
