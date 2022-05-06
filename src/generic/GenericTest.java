package generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 泛型的使用
 *   1 JDK5新增的特性
 *   2.在集合中使用泛型
 *     集合接口或集合类型在jdk5中都修改为带泛型的结构
 *     在实例化集合类时，可以指名具体的泛型类型
 *     指名完以后，在集合类或接口凡是定义类或接口时，内部结构比如 方法 构造器 返回值都是泛型指定的类型
 *     泛型的类型必须是类不能是基本数据类型，需要用到基本数据类型的位置都用对应的包装类
 *      如果实例化没有使用泛型则默认是object类
 *
 */
public class GenericTest {

    public static void main(String[] args) {
        //定义的泛型如果没有指名类型的话，则是Object类型的
        MyGeneric generic = new MyGeneric();
        generic.cc="";
        generic.cc=213;

        MyGeneric<String> myGeneric = new MyGeneric<>();
        myGeneric.cc="";
        //不用指定类型就会报错
        //myGeneric.cc=123;

        MyGeneric<Integer> myGeneric1 = new MyGeneric<>();
        //泛型类型不同的引用不能相互赋值
        //myGeneric1= myGeneric;

        SubMyGeneric<String> stringSubMyGeneric = new SubMyGeneric<>();


    }

    //没有泛型之前的代码
    @Test
    public void test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(123);
        arrayList.add("abc");

        for (Object integer:arrayList){
            //abc强转错误
            Integer in = (Integer) integer;
            System.out.println(in);
        }
    }
    @Test
    public void test1(){
        ArrayList<Integer> arrayList  = new ArrayList<Integer>();
        //JDK7新特性 类型推断 后面的泛型可以不写
        ArrayList<Double> doubleArrayList = new ArrayList<>();

        arrayList.add(213);
        arrayList.add(213);
        arrayList.add(213);
        //有了泛型后就可以指定顺序表里添加元素的类型
        //arrayList.add("")
        //同时编译时 默认的顺序表添加类型都是Integer
        for (Integer integer:arrayList){
            System.out.println(integer);
        }
    }
    @Test
    public void test2() {
        DAO<MyGeneric> dao = new DAO<>();
        dao.save("1001",new MyGeneric());
        dao.save("1002",new MyGeneric());
        dao.save("1003",new MyGeneric());

        dao.update("1001",new MyGeneric());

        List<MyGeneric> list = dao.list();

        dao.delete("1003");

    }
}
