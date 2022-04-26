package collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *
 *
 *  TreeSet的练习
 */
public class SetExercise {
    public static void main(String[] args) {
        //自然排序
        TreeSet set = new TreeSet();
        comm(set);
    }

    @Test
    public void test() {
        //定制排序
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    return e1.getBirthDay().compareTo(e2.getBirthDay());
                }
                throw new RuntimeException();
            }
        });
        comm(set);
    }

    private static void comm(TreeSet set) {
        set.add(new Employee("huang",27,new MyDate(2000,1,1)));
        set.add(new Employee("shi",29,new MyDate(2006,7,7)));
        set.add(new Employee("lin",28,new MyDate(2014,11,20)));
        Iterator iterator =set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     *
     *
     * 利用set的特性给list去重
     */
    @Test
    public void test1() {
        ArrayList arr = new ArrayList();
        arr.add(new String("1"));
        arr.add(new String("1"));
        arr.add(new String("1"));
        arr.add(new Integer(2));
        arr.add(new Integer(2));
        arr.add(new Integer(2));
        arr.add(3);
        HashSet set  = new HashSet();
        set.addAll(arr);
        arr =new ArrayList(set);
        for (Object obj:arr){
            System.out.println(obj.toString());
        }

    }
}
