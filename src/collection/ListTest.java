package collection;

import object.PersonTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * List接口 元素有序 可重复的 动态数组
 *     实现类
 *     ArrayList：list接口的主要实现类 线程不安全 效率高,底层使用Object[]存储，查找效率高于LinkedList
 *     LinkedList：底层使用双向链表存储,频繁使用插入,删除操作的话使用此类效率更高
 *     Vector：List接口的古老实现类，使用频率低，线程安全的,底层使用Object[]存储
 *
 *   ArrayList的源码分析  jdk7 8实现有不同
 *   1.7
 *    ArrayList list = new ArrayList();//ArrayList底层数组初始化容量为10
 *    list.add(123); //elementData[0] = new Integer(123);
 *    ....
 *    list.add(1);如果此次的添加导致elementData数组容量不够，则扩容
 *    默认情况是把容量括为1.5倍，同时将原数组的元素复制到新数组
 *    建议：开发中使用带参的构造器，避免扩容的情况 ArrayList list = new ArrayList(10)
 *  1.8
 *    ArrayList list = new ArrayList();//在8 Object[] elementData底层不再初始化，不为
 *    elementData分配内存空间。知道执行add操作才开始分配内存空间。后续添加和扩容和7一样。
 *
 * 总结：
 *    JDK7中的ArrayList对象创建有点类似于单例模式中的饿汉式,而JDK8的对象创建有点类似于单例中的
 *    懒汉式，延迟了数组的创建。
 *
 *
 *
 *    LinkedList源码分析‘
 *      LinkedList list = new LinkedList(),内部声明了Node类型的first和last属性，默认值为null
 *      list.add（123） //将123封装到Node中,创建了Node对象  没有长度限制。双向链表只知道上下两个节点
 *
 *      Node类
 *         private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *  vector源码类似ArrayList，创建vector对象时也是创建了一个长度为10的object[] elementdata
 *  每次扩容时原长度的2倍
 *
 *
 *
 *  面试题： ArrayList LinkedList Vector 三个类的异同
 *   同：三个类都是实现了List接口，存储有序不重复的数据
 *   不同：ArrayList：线程不安全 比Vector效率高,底层使用Object[]存储
 *        LinkedList：底层使用双向链表存储,频繁使用插入,删除操作的话比arrayList高
 *        Vector：线程安全的,效率比ArrayList低,底层使用Object[]存储
 */
public class ListTest {

    //arrayList的特有方法
    public void test() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(345);
        list.add("AA");
        list.add(new PersonTest());
        list.add(new String("123"));

        //add（int index，Object ele）在指定位置插入元素
        list.add(1,1);
        //boolean addAll（index,Collection ele）从index位置开始将ele中的所有元素添加到list
        list.addAll(3, Arrays.asList(1,2,3));

        //get 获取指定位置的元素
        System.out.println(list.get(2));

        //int indexOf  返回obj在集合中首次出现的位置，如果不存在返回-1
        list.indexOf(123);

        //lastIndexOf返回obj在集合中末次出现的位置，如果不存在返回-1
        list.lastIndexOf(345);

        //remove(int index ) 移除指定位置的元素,并返回该元素
        list.remove(1);

        //set(int ,Object ele)  设置指定位置的元素
        list.set(5,100);

        //sublist 截取list，但不会对原list进行修改
        list.subList(0,9);

    }
}
