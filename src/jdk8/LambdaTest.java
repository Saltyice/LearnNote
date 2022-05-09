package jdk8;

/**
 *  Lambda表达式  (o1,o2) -> Integer.compare(o1,o2)
 *   -> Lambda操作符  箭头操作符
 *   左边是 lambda 形参列表
 *   右边 lambda 体   就是抽象方法的方法体
 *
 *  lambda表达式的使用  6种格式
 *
 *  lambda表达式的本质：作为函数式接口的实例
 *  如果一个接口种，只声明了一个抽象接口，则该接口则称为函数式接口
 */
public class LambdaTest {
    public static void main(String[] args) {
        //格式一 无参 无返回值
        Runnable run = ()-> System.out.println("test");
        run.run();
        //格式二  有参 无返回值
        TestLambda runnable =(String str) -> System.out.println(str);
        runnable.fun1("fun1");
        //格式三 类型推断
        TestLambda1<Integer> lambda =(in) -> System.out.println(in);
        //格式四 若只需要一个参数，括号可以忽略
        TestLambda lambda1 = str -> System.out.println(str);
        //格式五   参数多余两个 ，且需要返回值
        TestLambda2 testLambda2 = (a,b)->{
          return b;
        };
        //格式六  若执行语句只有一句，则大括号和return都可以省略
        TestLambda2 testLambda3 = (a,b)-> b;
        System.out.println(testLambda3.fun(1,2));
    }
}
@FunctionalInterface
interface TestLambda<T>{
    void fun1(String str);
}
@FunctionalInterface
interface TestLambda1<T> {
    void fun1(T str);
}
@FunctionalInterface //表明是函数式接口的注解
interface TestLambda2 {
    int fun(int a,int b);
}