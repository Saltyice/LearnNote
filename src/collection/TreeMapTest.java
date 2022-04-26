package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args){
        //向TreeMap中添加key-value，要求key必须时由同一个类创建的对象
        //TreeMap排序
       // TreeMap map =new TreeMap();
        TreeMap map =new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return s1.compareTo(s2);
                }
                throw new RuntimeException();
            }
        });
        map.put("1","2");
        map.put("2","3");
        map.put("4","5");
        map.put("3","4");

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
