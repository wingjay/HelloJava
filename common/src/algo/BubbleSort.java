package algo;

/**
 * 先遍历一遍找到最大值的index，换到最后
 * 递归
 */
public class BubbleSort {
    public static void main(String[] args) {
        int input[] = {100, 5, 4, 3, 2, 1, 9, 3, 2, 200};
        bubbleSort(input);
        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        }
    }

    private static void bubbleSort(int[] input) {
        _bubbleSort(input, input.length - 1);
    }
    private static void _bubbleSort(int[] input, int end) {
        if (end <= 1) {
            return;
        }
        int start = 0, maxIndex = 1;
        for (; start < end; start++) {
            if (input[start] > input[maxIndex]) {
                maxIndex = start;
            }
        }
        if (input[maxIndex] > input[end]) {
            int temp = input[end];
            input[end] = input[maxIndex];
            input[maxIndex] = temp;
        }
        _bubbleSort(input, end - 1);
    }
}
