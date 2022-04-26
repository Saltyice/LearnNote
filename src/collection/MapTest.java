package collection;

import java.util.*;

/**
 *
 * Map
 *   Map
 *     HashMap：Map的主要实现类，线程不安全，key和value可以存储null，效率高
 *        LinkedHashMap ：HashMap的子类，在遍历map元素时，可以按照添加的顺序实现遍历
 *                        原因：在hashMap底层结构基础上添加了一个指针，指向前一个和后一个元素。
 *                        对于频繁的遍历操作，效率高于HashMap
 *
 *     TreeMap 保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序或定制排序
 *             底层使用红黑树
 *
 *     Hashtable 作为古老实现类，线程安全的，效率低，不能存储null的key和value
 *        Properties hashtable的子类，常用来处理配置文件。key和value都是string类型
 *
 *      haspMap的底层：数组+链表（jdk7及之前）
 *                  ：数组+链表+红黑树（jdk8后）
 *
 *      Map接口的理解
 *      Map中的key：无序的，不可重复的，使用set存储所有的key
 *      Map中的value：无序的，可重复的,使用Collection存储所有的value
 *      一个键值对：key-value构成了一个entry对象
 *      entry：无序的，不可重复的，使用set存储所有的entry
 *
 *  HashMap的底层实现原理：JDK7
 *      HashMap map = new HashMap();
 *      在实例化以后创建了一个长度为16的一维数组 entry[] table。
 *      map.put（key1,value1）;
 *      首先调用key对应类的hashcode（）计算key1哈希值，然后根据哈希值用算法计算得到在entry数组中的存放位置，
 *      如果此位置上数据为空，此时的key1-value1添加成功
 *      如果此位置上已经存在一个或多个数据（以链表形式存在）,比较key和已经存在的一个或多个数据的哈希值，
 *      如果key1的哈希值和存在数据的key哈希值都不一样，此时key1-value1添加成功
 *      如果key1的哈希值和已经存在的数组哈希值相同就调用key1所在类的equals方法
 *         equals返回false：此时key1-value1添加成功
 *         equals返回true,使用value1替换现有的value2
 *            若现有map容量不足会进行扩容，将entry[] 扩容为原来的2被，并复制原有的数据
 *
 *
 *   HashMap的jdk8改动
 *     1. new HashMap():底层没有创建一个长度为16的数组
 *     2. JDK 8 底层的数组时Node[] 而非Entry[]
 *     3.首次调用put方法时，才创建长度为16的数组
 *     4.jdk7底层实现结构是数组+链表。jdk8底层结构：数组+链表+红黑树
 *       当数组的某一个索引位置上的元素以链表形式存在的数据个数》8且当前数组的长度》64时。
 *       此时此索引位置上的所有数据改为红黑树存储
 *     DEFAULT_INITIAL_CAPACITY  hashmap的默认容量 16
 *     DEFAULT_LOAD_FACTOR    默认加载因子0.75
 *     TREEIFY_THRESHOLD     变为红黑树的临界值 链表长度大于8
 *     MIN_TREEIFY_CAPACITY  变为红黑树的最小hash表容量 64
 *
 *
 *     LinkedHashMap的底层实现就是在Map的Node基础
 *     上增加了一个指向下一个对象的指针
 *
 *    static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *
 *
 *
 *   面试题：
 *   HashMap的底层实现原理
 *   HashMap和hashtable异同
 *   CurrentHashMap与Hashtable的异同？
 *
 */
public class MapTest {
    /**
     *
     *  Map的常用方法
     *
     * @param args
     */
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        //put
        hashMap.put("123","456");
        hashMap.put(45,"456");
        hashMap.put("123","123");

        //putAll
        HashMap hashMap1 = new HashMap();
        hashMap1.put("123","456");
        hashMap.putAll(hashMap1);

        //remove 移除当前键值对并返回value
        hashMap.remove("123");

        //clear 清空map里的数据
        hashMap.clear();

         //get
        hashMap.get("123");

        //containsKey 是否包含指定的key true false
        hashMap.containsKey("123");

        //containsValue  是否包含指定的value true false
        hashMap.containsValue("456");

        //size
        hashMap.size();

        //isEmpty
        hashMap.isEmpty();

        //equals
        hashMap.equals(new HashMap());

        //遍历key
        Set set = hashMap.keySet();
        Iterator iterator= set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历value
        Collection values = hashMap.values();
        for (Object obj:values){
            System.out.println(obj.toString());
        }

        //遍历key-value
        Set entrySet = hashMap.keySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry =(Map.Entry) obj;
            entry.getKey();
            entry.getValue();
        }
    }
}
