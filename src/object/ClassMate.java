package object;

/**
 *
 *
 *
 * 方法的重写
 * 子类继承父类方法后，可以对父类中同名同参数的方法进行覆盖
 * 重写方法以后，创建子类对象以后，通过子类对象调用父类中的同名同参方法时，实际执行的是子类重写后的方法。
 * 子类重写的方法的方法名和形参与父类被重写的方法的方法名与形参列表相同
 * 子类重写的权限修饰符不小于父类被重写方法
 * 特殊情况：子类不能重写父类中的private方法
 * 父类被重写的返回值类型是void,则子类重写的方法的返回值类型只能是void
 * 父类被重写的返回值类型是A类型,则子类重写的方法的返回值类型可以是A类或者A类型的子类
 * 父类被重写的返回值类型是基本数据类型,则子类重写的方法的返回值类型必须是相同的基本数据类型
 * 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 * 父类声明为static的方法不能被重写
 *
 */
public class ClassMate extends Man{
    String major;
    int id=100;
    public ClassMate(){

    }

    public ClassMate(String major) {
        this.major = major;
    }

    public void study(){
        System.out.println(major);
    }

    public void eat(){
        System.out.println("123");
    }


    public ClassMate info(){
        return null;
    }

    public double info1(){
        return 1;
    }

    public void print(){
        System.out.println(this.id);
        System.out.println(super.id);
    }

    public static void main(String[] args) {
        ClassMate mate = new ClassMate("CS");
        mate.eat();
        mate.walk(10);
        mate.study();
        mate.print();
    }
}
