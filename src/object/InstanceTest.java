package object;

import java.lang.reflect.MalformedParametersException;
import java.util.Objects;

public class InstanceTest {
    public static void main(String[] args) {
        HumanKind kind = new male();
        //父类调不了子类的方法
       // kind.dick();

        male male = (male)kind;
        //male.eat();
        //子类调不了父类的私有方法和属性
       // male.age;
        //向下强制转型就可以调用了
        male.dick();
        //这样运行会报错 向下强转错误
       // female female = (female) kind;

        //female.pussy();
        male ma = new male();
        //instanceof 判断是否是A是否是B的实例  和 A是否是B的子类或父类
        boolean a = male instanceof HumanKind;
        boolean b = male instanceof  male;
        boolean c = kind instanceof  male;
        boolean d = kind instanceof  HumanKind;
        System.out.println(a);
        System.out.println(b);


        test(new HumanKind());
        test(new male());
        test(new female());

    }


    public static void test(HumanKind kind) {
        kind.say();
    }

}

class HumanKind{


    private String age;

    private  void eat() {
        System.out.println("eat");
    }

    public void breath(){
        System.out.println("CO2");
    }

    public void say(){
        System.out.println("human");
    }
}

class male extends HumanKind{
    public void dick() {
        System.out.println("dick ");
    }

    public void say() {
        System.out.println("man");
    }

}
class female extends HumanKind{
    public void pussy(){
        System.out.println("pussy");
    }

    public void say() {
        System.out.println("women");
    }
}