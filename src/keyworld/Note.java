package keyworld;

public class Note {
    public static void main(String[] args) {

//        char c= 'a';
//        int num = 10;
//        String str = "hello";
//        System.out.println(c+num+str);
//        System.out.println(c+num+str);

        //连续赋值
        int i1=10;
        int j1=10;
        int i2,j2;
        i2 = j2 =10;

        int num1=10;
        num1 +=2;
        System.out.println(num1);

        int num2=12;
        num2 %=5;
        System.out.println(num2);
//      +=不会改变变量本身的数据类型
        short s1=10;
        s1 +=2;
        System.out.println(s1);
        //实现+2的写法
        //num =num+2;
        // num +=2;
        //位运算
        int i=1;
        System.out.println(0&0);

        //     丛键盘获取输入
/*        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(1);
        int height=scanner.nextInt();
        System.out.println(2);
        double wealth = scanner.nextDouble();
        System.out.println(3);
        boolean is= scanner.nextBoolean();
        if (height>=180 && wealth>=1 && is) {
            System.out.println(4);
        } else if (height>=180 || wealth>=1 || is) {
            System.out.println(4);
        } else {
            System.out.println(4);
        }*/
    }
}
