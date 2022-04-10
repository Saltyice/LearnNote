package keyworld;

public class PrintTest {
    public static void main (String[] args) {
        //嵌套循环练习
//        for (int i=1;i<=6;i++) {
//            for (int j=1;j<=i;j++ ) {
//                System.out.print('*');
//            }
//            System.out.println();
//        }
        //嵌套循环练习
//        for (int i=1;i<=6;i++) {
//            for (int j=1;j<=6-i;j++ ) {
//                System.out.print('*');
//            }
//            System.out.println();
//        }
        //输出99乘法表
//        for (int i=1;i<=9;i++) {
//            for(int j=1;j<=i;j++) {
//                System.out.print(i+" * "+ j+" = "+ i*j+ " ");
//            }
//            System.out.println();
//        }
        //判断是否是质数
        boolean flag = true;
        for (int i=2;i<=100;i++) {
            for (int j=2;j<=Math.sqrt(i);j++) {
                if (i % j == 0){
                    flag = false;
                    break ;
                }
            }
            if (flag){
                System.out.println(i);
            }
            flag = true;
        }

    }
}
