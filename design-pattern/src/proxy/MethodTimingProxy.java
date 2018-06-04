package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wingjay on 06/11/2017.
 */
public class MethodTimingProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object realObject) {
        this.target = realObject;
        System.out.println("abc".substring(0, 1));
        int[] r = {0,0,0,0};
        fourSum(r, 0);
        return Proxy.newProxyInstance(realObject.getClass().getClassLoader(),
                realObject.getClass().getInterfaces(),
                this);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int length = nums.length;
        for(int i=0; i<length-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) { continue; }
            threeSum(nums, i+1, -nums[i], ret);
        }

        return ret;
    }

    private void threeSum(int[] nums, int start, int target, List<List<Integer>> ret) {
        int length = nums.length;
        for(int i=start; i<length-2; i++) {
            int left = i+1;
            int right = length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> l = new ArrayList<>(4);
                    l.add(-target);
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    ret.add(l);

                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object result = method.invoke(target, args);
        System.out.println(String.format("methods %s, consume time: %s", method.getName(), System.nanoTime() - start));
        return result;
    }
}
