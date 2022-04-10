package object;

/**
 * 类中属性的使用
 * 属性（成员变量） VS 局部变量
 * 1.相同点
 *       定义变量的格式： 数据格式 变量 = 变量值
 *       先声明，后使用
 *       变量都有对应的作用域
 *
 * 2.不同点
 *    在类中声明的位置不同
 *    属性：直接定义在类的一对{}中
 *    局部变量,声明在方法内，方法形参 构造器内 构造器形参 构造器内部变量
 *
 *    关于权限修饰符的不同
 *    属性：可以在声明属性时，指名其权限，使用权限修饰符
 *    常用的权限修饰符 private public 缺省 protected
 *    默认使用缺省就可以了
 *    局部变量：不可以使用权限修饰符
 *
 *    默认初始化值的情况
 *    属性：类的属性根据其类型都有默认初始化值
 *    byte shor int long 0
 *    浮点型 float double  0.0
 *    字符型 char 0（\u0000）
 *    布尔 boolean   false
 *    引用 类 接口  数组   null
 *    局部变量：没有初始化值。我们在调用局部变量前一定要显式赋值。形参在调用时赋值即可
 *
 *    在内存位置不同
 *    属性：加载在堆空间中（static）
 *    局部变量：加载到栈空间
 *
 */
public class UserTest {

    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.name);
        System.out.println(user.age);
        System.out.println(user.male);
    }
}

class User {
    String name;
    int age;
    boolean male;

    public void talk (String world) { //形参
        System.out.println(world);
    }

    public void eat() {
        String food = "noodle"; //局部变量
        System.out.println(food);
    }


}