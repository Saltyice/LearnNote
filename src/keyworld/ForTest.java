package keyworld;

import java.util.Scanner;

public class ForTest {
    public static void main (String[] args){
        //求两个整数的最大公约数和最小公倍数
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        //获取两数中的较小值
        int min = (m>=n)?n:m;
        //求最小公约数
        for (int i=min;i>=i;i--){
            if (m%i ==0 && n%i ==0) {
                System.out.println(i);
                break;
            }
        }
        int max = (m>=n)?m:n;
        for (int i=max;i<=m*n;i++) {
            if (i%m ==0 && i%n ==0) {
                System.out.println(i);
                break;
            }
        }

    }
}
