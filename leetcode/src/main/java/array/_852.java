package array;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

/**
 * @Author jw9j
 * @create 2021/6/15 0:28
 *
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _852 {
    public static void main(String[] args) {
        long stratTime = System.nanoTime();
        long i = 4222220000000L;
        // >> 左移1位
        System.out.println(i * 1024);
        long endTime = System.nanoTime();
        System.out.println(endTime-stratTime);
    }
    // 暴力破解法
    public int peakIndexInMountainArray(int[] arr){
        int i = 1;
        while(i<arr.length-1){
            if(arr[i-1]<arr[i] && arr[i]<arr[i+1]){
                return i;
            }
            i++;
        }
        return 0;
    }

    // 二分法
    public int peakIndexInMountainArray_1(int[] arr){
        int left = 1, length = arr.length, right =length-1,result=0;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid]>arr[mid+1]){
                result = mid;
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return result;
    }
}
