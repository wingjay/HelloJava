package algo.sort;


import com.oracle.tools.packager.Log;

import java.util.*;

/**
 * Created by wingjay on 09/03/2018.
 * 1. 分治递归，把数组拆成两部分分别排序，最后merge
 * 2. 迭代，从左往右依次归并，每两个归并->每四个归并->每八个归并
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] nums = {3, 2, 4, 1, 5};
//        recursionSort(nums);

        List<Integer> result = new ArrayList<>();
        int a = 'a';
        System.out.println(String.valueOf(a));
        int[] num = {1, 1, 2, 2, 3, 2};
        System.out.println(majorityElement(num));
    }
    private static int majorityElement(int[] num) {
        Arrays.sort(num);
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }

    // 分治递归，把数组拆成两部分分别排序，最后merge
    public static void recursionSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        recursionSort(nums, 0, nums.length-1);
    }

    private static void recursionSort(int[] nums, int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        recursionSort(nums, start, mid);
        recursionSort(nums, mid+1, end);
        mergeSort(nums, start, mid, end);
    }

    private static void mergeSort(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) temp[index++] = nums[i++];
            else temp[index++] = nums[j++];
        }
        if (i > mid && j <= end) {
            while (j <= end) temp[index++] = nums[j++];
        }
        if (i <= mid && j > end) {
            while (i <= mid) temp[index++] = nums[i++];
        }
        for(i=start, index=0; i <= end; ) nums[i++] = temp[index++];
    }
}
