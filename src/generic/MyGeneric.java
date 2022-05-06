package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * @param <E>
 */
public class MyGeneric<E> {

    String AA;
    int bb;
    E cc;

    public static void show()    {
        //静态方法不能使用泛型的成员变量
        //System.out.println(cc);
    }

    //泛型方法 需要在方法中指定泛型<E>
    //泛型方法可以声明为静态的 原因泛型参数是在调用方法时确定的，并非在实例化时确定
    //泛型方法与所属的类是否时泛型类没有关系
    public <E> List<E> returnArrayList(E[] list){
        ArrayList<E> arrayList =new ArrayList<>();
        for (E A:list){
            arrayList.add(A);
        }
        return  arrayList;
    }
}
