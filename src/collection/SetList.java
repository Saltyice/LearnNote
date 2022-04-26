package collection;

import object.PersonTest;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *  Set 接口 元素无序 不可重复的
 *    实现类
 *    HashSet  Set接口的主要实现类，线程不安全 可以存储null值
 *    LinkedHashSet hashSet的子类，遍历其内部数据时,可以按照添加的顺序遍历
 *    对于频繁的遍历操作,LinkedHashSet效率高于HashSet
 *    TreeSet  可以按照添加对象的指定属性，进行排序
 */
public class SetList {
    /**
     *
     * set 的特点
     *
     *  1.无序性
     *   无序不是随机性！
     *   HashSet无序指的是元素存入并非按照数组索引的顺序添加，而是根据数据的哈希值添加
     *
     *  2.不可重复性
     *    保证添加的元素按照equals（）方法判断时，不能返回true，即相同的元素
     *    只能添加一个。
     *
     *  HashSet添加元素的过程：
     *    我们向hashSet添加元素a,首先根据元素a的hashcode方法,计算元素a的哈希值
     *    此哈希值接着通过某种算法计算出在Hashset底层数组中的存放位置（即为索引位置），
     *    判断此数组此位置上是否已经有元素
     *    没有元素则将元素a添加上去
     *    如果此元素上有其他元素B（或以链表形式存在多个元素）,则比较元素a与元素b的hash值
     *    如果hash值不相同，则将元素a添加到该位置的链表里
     *    如果哈希值相同，进而需要调用元素a的equals方法：equals返回true则元素a添加失败
     *    返回false则元素a添加成功
     *
     *    元素存在对应索引上有数据的话，与已经存在指定索引上的数据以链表方式存储
     *
     *
     *    HashSet底层是数组+链表
     *    new 一个HashSet对象实际上是new了一个HashMap
     *
     */
    @Test
    public void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new PersonTest("123",12));
        set.add(new PersonTest("123",12));
        set.add(new String("1"));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            //输出的顺序与添加顺序不一样，无序
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        //元素增加了双向链表的特性，可以指向上下元素
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add(new PersonTest("123",12));
        set.add(new PersonTest("123",12));
        set.add(new String("1"));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     *
     * 向TreeSet添加的对象要求是相同类型的对象
     * 两种排序方式：自然排序  定制排序
     * 自然排序中，比较两个对象是否相同的标准是 compareTo返回0，不再是equals（）
     * 定制排序中，比较两个对象是否相同的标准为 compare返回0，不再是equals（）
     *  Comparable  Comparator接口
     *
     */
    @Test
    public void test2(){


        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if( o1 instanceof PersonTest &&  o2 instanceof PersonTest ){
                    PersonTest personTest = (PersonTest) o1;
                    PersonTest personTest1 = (PersonTest) o2;
                    if (personTest.getAge()>personTest1.getAge()){
                        return 1;
                    } else if (personTest.getAge()< personTest1.getAge()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        };

        //TreeSet会自动排序
       //Set set = new TreeSet();  //自动排序
        Set set = new TreeSet(comparator); //定制排序

        //int类型排序
        //set.add(123);
        //set.add(345);
        //TreeSet不能添加不同类型的对象
        //set.add("123");
        //set.add(3);


        //cannot be cast to class java.lang.Comparable
        //引用类型对象要求实现了Comparable接口 Comparator接口
        set.add(new PersonTest("1",12));
        set.add(new PersonTest("2",1));
        set.add(new PersonTest("3",11));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
