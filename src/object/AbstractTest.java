package object;

/**
 *   abstract关键字的使用
 *   1.abstract:抽象的
 *   2.abstract可以用来修饰的结构 类 方法
 *
 *   abstract 修饰类-》 抽象类
 *   抽象类一定有构造器，便于类实例化调用（涉及 子类对象实例化的过程）
 *   开发中都会提供抽象类的子类，让子类对象实例化，完成相关的操作
 *
 *   abstract 修饰方法 抽象方法
 *    抽象方法只有方法的声明，没有方法体。
 *    包含抽象方法的类，一定是 抽象类。反之抽象类可以没有抽象方法
 *    继承了抽象类的子类，一定要实现父类的抽象方法，否则无法通过编译。
 *    若子类没有重写抽象方法，则此子类也是一个抽象类
 *
 *   注意点：
 *   abstract 不能用来修饰属性 构造器！！！！
 *   abstract 不能用来修饰静态方法！！  静态方法不能重写而抽象方法需要重写互相矛盾了！！！
 *   abstract和 final static互斥！
 *
 *
 */
public class AbstractTest {
    public static void main(String[] args) {
        //被抽象 abstract修饰过的类无法实力化
        //MyPerson person = new MyPerson();
        //person.eat();
        MyStudent student =new MyStudent();
        student.walk();
        //抽象类的匿名子类
        MyPerson pp = new MyPerson() {
            @Override
            public void eat() {
                System.out.println();
            }
        };
        //匿名子类的匿名对象
        MyPerson.mySon(new MyPerson(){

            @Override
            public void eat() {

            }
        });

    }

}
abstract class MyPerson{
    String name;
    int age;
    //此时构造器是给子类实例化时用的
    public MyPerson(){}

    public MyPerson(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //抽象方法只有方法的声明，没有方法体。抽象方法无法被调用
    public abstract void eat();

    public void walk() {
        System.out.println("walk");
    }

    public static void mySon(MyPerson person){

    };

 }

 class MyStudent extends MyPerson{
     public MyStudent() {
     }

     public MyStudent(String name, int age) {
         super(name, age);
     }

     @Override
     public void eat() {

     }
 }

abstract class Worker extends MyPerson{
    //抽象子类就可以不重写父类的抽象方法
}