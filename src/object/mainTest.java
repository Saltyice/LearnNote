package object;

/**
 * main方法入口
 * main（）方法作为程序的入口
 * main（）也是一个普通的静态方法
 * main()方法还可以作为控制台作为与程序的交互
 *
 *
 *
 * 代码块
 * 静态代码块会随着类的加载而执行
 * 初始化类的信息
 * 静态代码块先于非静态代码块执行
 * 静态代码块只能访问静态方法和静态成员变量跟方法一样
 *
 *
 * 非静态代码块随着对象的创建而执行
 * 作用：初始化对象的属性信息
 *
 *
 *
 * 代码块先于构造器执行！！
 *
 */
class Main{
    public static void main(String[] args) {
        System.out.println("12");
    }
    //大括号括起来就是代码块
    static {
        System.out.println("Main 静态方法快");
    }
    //静态代码块
    {
        System.out.println("Main 非静态方法块");
    }

    public Main(){
        System.out.println("main 构造器");
    }

}

class MainSon extends  Main {

    static {
        System.out.println("MainSon 静态方法快");
    }
    //静态代码块
    {
        System.out.println("MainSon 非静态方法块");
    }

    public MainSon(){
        System.out.println("MainSon 构造器");
    }

}
public class mainTest {
    static {
        System.out.println("mainTest 静态方法快");
    }
    //静态代码块
    {
        System.out.println("mainTest 非静态方法块");
    }

    public static void main(String[] args) {
        /**
         *
         * 执行顺序如下：
         *  1.加载mainTest类，所以先执行mainTest静态代码块然后调main方法
         *  2.调用MainSon构造器时会会先执行suoer()，所以加载父类执行 Main静态方法快
         *  3.再加载MainSon类执行MainSon静态方法块
         *  4.再继续执行main构造器，再到MainSon构造器
         *  5.因为要new MainSon对象所以执行非静态代码块
         *  6.最后执行完MainSon构造器
         */
        MainSon son = new MainSon();
    }
}

