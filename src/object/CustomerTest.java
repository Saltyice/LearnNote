package object;

/**
 *  类中方法中的声明和使用
 *  方法：描述类中具有的功能。
 *  比如 Math.random（）
 *
 *  1.举例
 *  public void eat(){}
 *  public void sleep(){}
 *
 *  2. 方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
 *      方法体
 *  }
 *  final static abstract 后续补充
 *
 *  3. 说明：
 *   关于权限修饰符  private  public 缺省  protected
 *   返回值类型 有返回值 VS 无返回值
 *   有返回值则必须在方法声明时指定返回值类型。同时在方法体中必须返回指定返回值
 *   无返回值的时候可以用void声明，不再需要使用return返回之，例外情况是用return结束方法
 *
 *   方法名：遵循标识符的规则和规范，
 *   形参列表：方法可以声明0个 1个 或多个形参
 *   格式： 数据类型1 形参1，数据类型2，形参2，。。。。。
 *
 */

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.eat();

    }
}

class Customer{
    String name;
    int age;
    boolean male;

    public void eat(){
        System.out.println("");

    }

    public void sleep(int hour){
        System.out.println();
    }

    public String getName(){
        return name;
    }

    public String getNation(){
        return "";
    }

    private String test(){
        return "";
    }
}
