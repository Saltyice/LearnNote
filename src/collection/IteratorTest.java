package collection;

import object.PersonTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 *  集合元素的遍历
 *  使用迭代器Iterator接口
 *  方法 hasNext() Next() remove();
 *
 *
 *
 */
public class IteratorTest {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        Collection collection =new ArrayList();
        collection.add(123);
        collection.add(false);
        collection.add(new String("123"));
        collection.add(new PersonTest());

        Iterator iterator = collection.iterator();
        //遍历方式一
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //超过会报错
       // System.out.println(iterator.next());

        //遍历方式二
//        for (int i = 1; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//        }
        //遍历方式三
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //iterator的next方法是指针指向下一个位置,然后返回指针指向的值
        //遍历完迭代器的指针就不再指向集合元素需要重新初始化才可以继续使用
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        iterator = collection.iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(123)){
                iterator.remove();//移除当前元素
            }
        }
        iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void foreachTest(){
//        Collection collection =new ArrayList();
//        collection.add(123);
//        collection.add(false);
//        collection.add(new String("123"));
//        collection.add(new PersonTest());
//        //内部实现还是使用了迭代器
//        for (Object obj:collection){
//            System.out.println(obj);
//        }

        int[] arr =new int[]{1,2,3,4,5,6};
        for (int i:arr){
            System.out.println(i);
        }

        for (int i:arr){
            i=1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //for循环会改变数组的值,但是foreach循环就无法给元素重新赋值
        //因为foreach是重新new了一个对象
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
