package algo;

/**
 * 先分治到长度为2的数组，短数组排序
 * 所有短数组合并
 *
 * 合并可以在原有数组上，通过挪动整体数组来merge
 */
public class MergeSort {

    public static void main(String[] args) {
        int input[] = {100, 5, 4, 3, 2, 1, 9, 3, 2, 200};
        mergeSort(input);
        for (int i=0; i<input.length; i++) {
            System.out.println(input[i]);
        }
    }

    private static void mergeSort(int[] input) {
        _mergeSort(input, 0, input.length - 1);
    }

    private static void _mergeSort(int[] intput, int start, int end) {
        if (start == end) {
            return;
        }
        int middle = start + (end - start) / 2;
        _mergeSort(intput, start, middle);
        _mergeSort(intput, middle + 1, end);

        int i=start, j=middle+1;
        while (i <= middle &&  j <= end) {
            if (intput[i] > intput[j]) {
                int temp = intput[j];
                for (int tempIndex = j; tempIndex > i; tempIndex--) {
                    intput[tempIndex] = intput[tempIndex - 1];
                }
                intput[i++] = temp;
                j++;
                middle++; //注意，middle应该时刻指向左数组的最大值，当整体右移时，该index也要随着移动
            } else {
                i++;
            }
        }
    }
}
