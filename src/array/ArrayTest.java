package array;

import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {
        /**
         *  一维数组的声明与初始化
         *  调用数组指定位置的元素
         *  获取数组的长度
         *  遍历数组
         *  数组元素默认初始化值
         *  数组内存解析
         *
         */
        //声明
        int[] a;
        //静态初始化:数组的初始化和赋值操作同时进行
        a=new int[]{100,101,102};
        //动态初始化:数组的初始化和数组元素赋值分开进行
        String[] names = new String[10];
        //赋值
        names[1]="12";
        names[0]="1";
        names[9]="123";
        //属性：长度
        System.out.println(names.length);
        //遍历数组
        for (int i=0;i< names.length;i++){
            //System.out.println(names[i]);
        }
        //整型数组初始化有默认赋值0，浮点数是0.0，
        int[] b = new int[100];
        System.out.println(b[99]);
        //char是'\u0000'
        char[] r = new char[2];
        System.out.println(r[1]);
        //boolean 默认赋值false
        boolean[] bool =new boolean[10];
        System.out.println(bool[1]);
        //引用数据类型数组 没有赋值是null
        String[] c = new String[4];
        System.out.println(c[0]);
        System.out.println(exe());
        /**
         * 多维数组
         *
         */
    }





    private static String exe() {
        int[] arr = new int[]{8,2,1,0,3};
        int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
        String tel = "";
        for (int i=0;i< index.length;i++) {
            tel +=arr[index[i]];
        }
        return tel;
    }

    private static void exe2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入人数"+"");
        int number = scanner.nextInt();
        int[] scores = new int[number];
        System.out.println("输入分数");
        for (int i=0;i<scores.length;i++) {
            scores[i] = scanner.nextInt();
        }
        int max = 0;
        for(int i=0;i<scores.length;i++) {
            if (max<scores[i]) {
                max=scores[i];
            }
        }
        System.out.println(max);
    }
}
