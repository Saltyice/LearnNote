package object;

/**
 *
 * this关键字的使用
 * 可以用来修饰 类 变量 方法
 * this 指定当前对象
 * 在类的方式种，我们可以使用this.属性 或 this.方法的方式，调用当前对象属性或方法。但是通常情况下，我们都选择省略this。
 * 如果方法的形参和类的属性同名了，则应该加上this，指代为当前对象的属性。
 *
 *
 * this调用构造器
 * 我们在类的构造器中，可以用this（形参列表）的形式，调用本类的其他构造器
 *  不能再构造器中用this（形参列表）的形式调用构造器本身
 *  再构造器中调用其他构造器，必须写在构造器中首行
 *
 *
 */
public class HumanTest {

}

class Human{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}