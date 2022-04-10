package object;

/**
 * 封装与隐藏
 * 当我们创建一个类的对象以后，我们可以通过“对象.属性”的方式，堆对象属性进行赋值，这里赋值操作受到
 * 属性的数据类型和存储范围的制约。除此之外，没有其他的制约条件。但是,在时间问题当中，我们往往需要给属性赋值
 * 加入额外的限制条件，这个条件就不能在属性声明时体现。我们只能通过方法进行限制条件的添加。（比如：set
 * 同时，我们需要避免用户在使用对象.属性的方式对属性进行赋值，则需要将属性声明为私有的）
 * 这丫对于属性就体现了封装性
 *
 *
 * 封装性的体现
 * 我们将雷达属性私有化（private）,同时，提供公共的get set方法来获取和设置此属性的值
 *
 *  封装性的体现 ： 私有化属性  不对外暴露的方法  单例模式
 *
 *
 *  封装性的体现，需要权限修饰符的配合
 *  1，java 规定的4种权限  private  default（缺省） protected public
 *  2.4种权限可以用来修饰类及类的内部结构 属性 方法 构造器 内部类
 *  3. 修饰类的话 只能用 public default
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
       // animal.name = "007";
       // animal.age=1;
      //  animal.legs=2;

        animal.show();

      //  animal.legs = -4;

    }
}


class Animal{

    private String name;
    private int age;
    private int legs;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLegs(int legs){
        if (legs%2 != 0 && legs<0){
            return;
        }
        this.legs =legs;
    }

    public int getLegs(){
        return legs;
    }

    public void eat() {
        System.out.println("eat");
    }

    public void show()  {
        System.out.println(age+name+legs);
    }
}