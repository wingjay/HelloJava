import java.util.Arrays;

/**
 * Created by Jay on 3/24/17.
 */
public class HelloSort {

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 3, 14, 5};
        Arrays.sort(unsorted); // DualPivotQuicksort.sort(a, 0, a.length - 1, null, 0, 0);
        for (int i=0; i<unsorted.length; i++) {
            System.out.println(unsorted[i]);
        }
    }
}
