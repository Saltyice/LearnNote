package object;

/**
 *
 * 内部类
 *  java允许将一个类A声明在另一个类B中，则A就是内部类  B是外部类
 *
 *
 *  成员内部类的分类 成员内部类    局部内部类
 *
 *
 *
 *   成员内部类：
 *     作为内部类的成员
 *       可以被static修饰
 *       调用外部的结构
 *       可以被4中不同的权限修饰
 *
 *
 *       类内可以定义属性 方法  构造器
 *       可以被final修饰
 *       可以被abstract修饰
 *
 *
 *
 *   如何实例化成员内部类
 *   如何在成员内部类中区分调用外部类的结构
 *   开发中局部内部类的使用
 *
 *
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //静态内部类的实例化
        HumanA.GG a = new HumanA.GG();
        //非静态内部类的实例化
        HumanA humanA = new HumanA();
        HumanA.ZZ zz = humanA.new ZZ();

    }

}



class HumanA{
    String dick;

    public void throwShit(){

    }

    //成员内部类
     class ZZ{
        String id;
        int number;
        public ZZ() {

        }
        public void print(){
            //调用外部结构
            HumanA.this.dick="";
            HumanA.this.throwShit();
        }
    }
    //静态内部类
    static class GG{
        String id;
        int number;
        public void print(){

        }
    }

    public void method(){
        //局部内部类
        class AA{}
    }

    {
        class BB{}
    }
}