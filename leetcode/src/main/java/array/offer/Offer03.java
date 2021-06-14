package array.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author jw9j
 * @create 2021/6/7 23:13
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *
 */
public class Offer03 {
    public static void main(String[] args) {

    }
    // 方法一： 暴力破解
    //    java set
    public int findRepeatNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return 0;
    }

    // 方法二：原地置换
    public int findRepeatNumber_2(int[] nums){
        int i = 0;
        while(i<nums.length){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[nums[i]]==nums[i]) return nums[i];
            int temp = nums[i];
            nums[i] =  nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
