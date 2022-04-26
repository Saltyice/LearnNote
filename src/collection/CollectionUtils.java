package collection;

import object.PersonTest;
import org.junit.jupiter.api.Test;

import java.net.CookieHandler;
import java.util.*;

/**
 *
 *  集合工具类
 *
 *
 */
public class CollectionUtils {

    public static void main(String[] args) {

        HashMap map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");

        HashSet set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(123);
        set.add("1234");
        set.add(new PersonTest());


        ArrayList list = new ArrayList(16);
        list.add(213);
        list.add(123);
        list.add(1);
        list.add(55);

        //反转
        Collections.reverse(list);
        System.out.println(list);

        //对list随机乱序
        Collections.shuffle(list);
        System.out.println(list);

        //排序 从小到大
        Collections.sort(list);
        System.out.println(list);

        //排序 定制排序
        Collections.sort(list,
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return 0;
                    }
                });



        //交换 交换两个位置的元素
        Collections.swap(list,1,2);


        //找最大
        Collections.max(list);

        //找最小
        Collections.min(list);

        //判断元素出现了几次
        Collections.frequency(set,123);

        List arr = Arrays.asList(new Object[list.size()]);
        System.out.println(list.size()  +
                "  "+arr.size());
        //copy 要求两个数组的长度要一致不然会报错！！
        Collections.copy(arr,list);
        System.out.println(arr);

        //synchronizedXXX方法可以将指定集合包装成线程同步的集合
        //从而解决多线程并发访问时的线程安全问题
        List newList = Collections.synchronizedList(list);
    }

}
