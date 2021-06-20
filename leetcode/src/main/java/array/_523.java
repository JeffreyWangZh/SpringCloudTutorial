package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author jw9j
 * @create 2021/6/7 0:48
 *
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _523 {
    public static void main(String[] args) {
        int[] test ={23,2,4,6};
        System.out.println(checkSubarraySum_1(test,6));
    }

    public static boolean checkSubarraySum_1(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        System.out.println(sum[0]);
        for(int i=1; i<=n;i++) sum[i] = sum[i-1] + nums[i-1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i<=n ; i++){
            set.add(sum[i-2]%k);
            if(set.contains(sum[i]%k)) return true;
        }
        return false;
    }
}
