package object;

/**
 * 一.设计类 其实就是设计类的成员
 *
 * 属性= 成员变量 = field = 域 字段
 *
 * 方法 = 成员方法= 函数= method
 *
 * 二:类和对象的使用（面向对象的实现）
 * 1.创建类，设计类的成员
 * 2.创建类的对象
 * 3.通过对象.属性 对象.方法调用对象的结构
 *
 * 三 如果创建了一个类的多个对象，则每个对象都独立拥有一套类的属性，非static
 * 意味这 如果我们修改对象的一个属性A，则不影响另外一个对象属性a的值
 *
 * 四 对象的内存解析
 *
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.name ="pp";
        p.male=true;
        System.out.println(p.name);

        p.eat();
        p.sleep();
        p.talk();

        Person pp = new Person();
        System.out.println(pp.name); //null
        System.out.println(pp.male); //false


        //将p变量保存的对象地址赋值给ppp,导致p和ppp指向堆空间中的同一个对象实体
        Person ppp = p;
        System.out.println(ppp.name);

        ppp.age=10;
        System.out.println(ppp.age);


    }
}

class Person{
    // 属性
    String name;
    int age;
    boolean male;

    public void eat(){
        System.out.println("eat fat");
    }

    public void sleep(){
        System.out.println(age);
    }
    public  void talk(){
        System.out.println(male);
    }

}
