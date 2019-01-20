/**
 * @author William Mou
 * @date 2019/1/18 10:29
 */
public class Fibonacci {
    public static long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long fibOne = 0; //(n-2)
        long fibTwo = 1; //(n-1)
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
