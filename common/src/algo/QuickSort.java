package algo;

/**
 * 先排好最后一个数的位置
 * 递归
 */
public class QuickSort {

    public static void main(String[] args) {
        int input[] = {5, 4, 3, 2, 1, 9, 3, 2};
        quickSort(input);
        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void quickSort(int[] input) {
        _quickSort(input, 0, input.length - 1);
    }

    public static void _quickSort(int[] input, int start, int end) {
        if (end <= start) {
            return;
        }

        int small = start, big = start;
        int pivot = end;
        int pivotValue = input[pivot];
        while (small <= pivot) {
            if (input[small] <= pivotValue) {
                int temp = input[big];
                input[big] = input[small];
                input[small] = temp;
                big++;
                small++;
            } else {
                small++;
            }
        }
        _quickSort(input, start, big - 2);
        _quickSort(input, big, end);
    }

}
