package algo.sort;

/**
 * Created by wingjay on 08/03/2018.
 */
public class QuickSort {
    //以最右为基准，遍历，小的放左边，大的放右边，然后分治

    public static void main(String[] args) {
        int[] case1 = {5, 8, 11,2,13,4};
        sort(case1);
        for (int i = 0; i < case1.length; i++) {
            System.out.println(case1[i]);
        }
    }

    private static void sort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int storeIndex = start;
        int pivot = nums[end];
        for (int i=start; i<end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, storeIndex++, i);
            }
        }
        swap(nums, storeIndex, end);
        sort(nums, start, storeIndex-1);
        sort(nums, storeIndex+1, end);
    }




















    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    private static void quickSort(int[] nums, int start, int end) {
        if(end - start <= 0) return;
        int pivot = nums[end];
        int store = start;
        int runner = start;
        while(runner < end) {
            if(nums[runner] <= pivot) {
                swap(nums, runner, store);
                store++;
            }
            runner++;
        }
        swap(nums, store, end);
        quickSort(nums, start, store-1);
        quickSort(nums, store+1, end);
    }

    private static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
