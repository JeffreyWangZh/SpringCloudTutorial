package array.offer;

/**
 * @Author jw9j
 * @create 2021/6/15 23:56
 */
public class Offer10 {

    public static void main(String[] args) {
        System.out.println(fib_1(10));
    }
    // 1. 递归实现
    public static int fib_1(int n) {
        if(n==0) return 0;
        return rec(n);
    }
    public static  int rec(int n){
        if(n <= 2) return 1;
        return rec(n-1) + rec(n-2);
    }

    //
    public static int fib_2(int n){
        int a = 0, b = 1;
        int sum = 0;
        for(int i =0; i<n;i++){
            sum = a + b % 100000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
