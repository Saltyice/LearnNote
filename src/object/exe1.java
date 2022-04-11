package object;

/**
 * 递归
 */
public class exe1 {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));

    }

    public static double exe1(double n) {
        if (n==1){
            return 1;
        }
        return n*exe1(n-1);
    }

    public static int exe2(int n) {
        if (n==20) {
            return 1;
        }
        if (n==21){
            return 4;
        }
        return exe2(n+2)-2*exe2(n+1);
    }

    /**
     * 返回斐波那契数列
     * @param n
     * @return
     */
    public static   int fibonacci(int n)  {
        if (n<3) {
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
