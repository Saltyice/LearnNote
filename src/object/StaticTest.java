package object;

/**
 * static关键字
 *
 * static 静态的
 * static 可以用来修饰 属性 方法 代码块 内部类
 *
 * 按是否以static修饰 分为 静态变量  实例变量
 *
 *实例变量： 我们创建了类的多个对象，每个对象都拥有一套类的非静态属性，修改其中一个对象中的非静态属性
 * 不会对其他对象造成影响
 *
 * 静态变量：多个对象会共用类的同一个静态变量，修改对象中的静态变量会对其他属性造成影响。
 *
 * static其他说明：
 *     静态变量随着类的加载而加载，可以通过类.静态变量的方式进行调用
 *     静态变量的加载要早于对象的创建
 *     由于类只会加载一次，则静态变量在内存中也只会存在一份，在方法区的静态域内。
 *
 *
 *
 * 使用 static 方法修饰方法  静态方法
 *   随着类的加载而加载，不需要创建对象也可以调用
 *   静态方法只可以访问静态变量无法访问实例变量，非静态方法则可以访问所有静态和非静态的成员变量
 *   对象可以调用静态方法 非静态方法，而类只可以调用静态方法
 *   在静态的方法内，不是使用super this 关键字
 *
 *
 *
 *
 */
public class StaticTest {
    public static void main(String[] args) {
        //静态变量属于类的一部分，在jvm初始化类时便存在了，不new对象也可使用
        Chinese.nation ="";

        Chinese lin = new Chinese();

        lin.name="df";
        lin.age =1000000000;
        lin.nation = "CHN";

        Chinese li = new Chinese();
        li.name = "";
        li.age = 12;
        li.nation = "Chinese";
        //两个对象共用同一个属性。
        System.out.println(lin.nation);

        Chinese.eat();
        lin.eat();
        //非静态方法只有对象才可调用
        //Chinese.shit();


    }
}

class Chinese {
    String name;
    int age;
    static String nation;

    public void shit(){
        System.out.println("eat shit");
        //非静态则都可以访问
        age=10000;
        nation="a";
    }

    public static void eat(){
        System.out.println("eat");
        //静态方法无法访问非静态
        //age = 10;
    }
}
