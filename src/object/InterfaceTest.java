package object;

/***
 *   接口的使用
 *    1. 接口使用interface来定义
 *    java中 接口和类是并列的两个结构
 *     如何定义接口
 *       JDK7以及以前
 *         只能定义全局常量和抽象方法
 *            全局常量  public  static final的
 *            抽象方法 public abstract
 *
 *
 *       JDK8：
 *         除了定义全局常量和抽象方法之外，还可以定义静态方法 默认方法
 *
 *      接口中不能定义构造器！无法实例化
 *
 *      接口可以通过implement的方式让类继承接口来实现方法
 *      如果类实现了接口中的所有方法。则此类可以实例化
 *      如果实现类没有覆盖接口中的抽象方法。则此实现类仍为一个抽象类
 *
 *
 *      Java类可以实现多个接口，弥补了java单继承的局限性
 *
 *      接口与接口之间可以互相继承
 *
 *       接口的使用体现了多态性
 *
 *      如果一个类继承的父类和实现的方法存在同名同参数的默认方法。默认调用的话是用父类中的方法
 *      存在类优先原则。
 *
 *      如果一个类实现的多个接口中存在同名同参数的默认方法，则会出现接口冲突，必须重写该方法
 *
 */
public class InterfaceTest {
    public static void main(String[] args) {
        Plane plane = new Plane();
        //默认方法可以调用
        plane.defaultMethod();
        //继承接口的类无法调用静态方法，只能用接口名.方法的形式调用
        //plane.staticMethod();
        //调用接口静态方法的方式
        Flyable.staticMethod();

    }
}




interface Flyable{
    //全局常量
    public static final int MAX_SPEED = 7900;
    public static final int MIN_SPEED = 1;
    //默认是public static final！
    int test = 10;
    //抽象方法
    public abstract void fly();
    //public abstract可以忽略，接口默认都是 public abstract
    void stop();
    //JDK8以后新增的接口中的静态方法
    public static void staticMethod(){

    }
    //默认方法
    public default  void  defaultMethod() {
        System.out.println("123");
    }
}


interface Attack{
    void attack();
}


interface AA{
    void method();
}

interface  BB{
    void method1();
}

interface CC extends AA,BB{

}

//类必须实现接口的方法
class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("");
    }

    @Override
    public void stop() {
        System.out.println("");
    }
}

abstract class Kite implements Flyable{
    @Override
    public void stop() {

    }
}

class Bullet implements Flyable,Attack,CC{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void method() {

    }

    @Override
    public void method1() {

    }
}

