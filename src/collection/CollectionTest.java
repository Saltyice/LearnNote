package collection;

import object.PersonTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 一 集合框架的概述
 *   集合 数组都是对多个数据进行存储操作的结构 java容器
 *   此时的存储主要指的是内存层面的存储,不涉及到持久化的存储
 *
 *    数组 有序 可重复  对于无序 不可重复的需求，不能满足
 *    数组：
 *      长度确定
 *      只可以存储定义类型的数据
 *      数组提供的方法有限，对于添加 删除 插入数据等操作，非常不便
 *      获取数组实际元素的个数的需求，数组没有现成的属性或方法可用
 *
 *   集合框架
 *      Collection接口 单列数据
 *        List接口 元素有序 可重复的 动态数组
 *          实现类 ArrayList LinkedList Vector
 *
 *        Set 接口 元素无序 不可重复的
 *         实现类 HashSet LinkedHashSet TreeSet
 *
 *
 *      Map接口  双列数据  用key-value键值对存储数据
 *        实现类 HashMap LinkedHashMap TreeMap HashTable Properties
 *
 *
 *     collection接口的方法
 *        add addAll
 *
 *
 *
 *
 */
public class CollectionTest {
    public static void main(String[] args) {
        String[] ARR =new String[]{};
    }


    public void test1() {
        Collection collection = new ArrayList();
        //add
        collection.add("");
        collection.add(new String("123"));
        collection.add(12);
        collection.add(23);
        collection.add(new PersonTest());

        //size()
        System.out.println(collection.size()); //4

        //addAll()
        Collection arr = new ArrayList();
        arr.add(23);
        arr.add(12);
        collection.add(arr);
        System.out.println(collection.size());//6

        //clear() 清除数据
        collection.clear();

        //isEmpty() 判断是否为空
        System.out.println(collection.isEmpty());

        //contains
        //contains方法会调用Obj的equals方法判断是否相等，建议写的类要重写equals方法
        collection.contains(123);//true
        collection.contains(new String("123")); //true
        collection.contains(new PersonTest());//false因为PersonTest没重写equals方法,有重写equals方法就是true

        //containsAll() 判断形参中的所有元素是否都存在与当前集合中
        collection.containsAll(collection);
        collection.containsAll(arr);

        //remove()
        //也会调用equals方法判断是否存在要移除的对象，如果没有移除会返回false
        //引用数据类型如果没有重写equals方法也会移除不了
        collection.remove(123);

        //removeAll() 移除形参对象里有的对象
        collection.removeAll(arr);


    }
    @Test
    public void test2(){
        //retainAll() 获取当前集合和形参对象的交集，并返回给当前集合
        Collection list = new ArrayList();
        list.add(123);
        list.add(12);
        list.add(4);
        list.add(5);
        Collection list1 = new ArrayList();
        list1.add(12);
        list1.add(123);
        list1.add(4);
        list.retainAll(list1); //执行完后 list变成[123, 12, 4]
        System.out.println(list.toString());

        //equals()
        System.out.println(list.equals(list1));//false！集合顺序不一样也会是false

        //hashcode() 返回当前对象的哈希值
        System.out.println(list.hashCode());

        //集合可以转换为数组 toArray()
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        //数组可以转换为集合 asList
        Arrays.asList(objects);

    }
}
