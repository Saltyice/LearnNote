package compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Java中的对象，只能进行 == ！=比较，
 * 但是在开发场景中看，我们需要比较对象属性的大小，
 * 我们就可以使用两个接口 Comparable Comparator来进行比较
 *
 *
 * compare使用
 */
public class CompareTest {

    public static void main(String[] args) {

    }

    /**
     *  Comparable接口的使用举例 自然排序
     *  像 String 包装类等实现了comparable接口，重写了compareTo方法，给出了比较两个对象大小的功能
     *   compareTo（）的规则
     *   如果this大于形参对象obj则返回正整数，小于返回负数，等于返回零
     *   对于自定义类，如果需要排序，我们需要让类实现Comparable接口，重写方法compareTo（）
     *
     */
    @Test
    public void test(){
        String[] arr = new String[]{"AA","ZZ","BB","CC","RR","QQ","HH"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test2() {
        Goods[] arr = new Goods[4];
        arr[0]= new Goods("1",1);
        arr[1]= new Goods("12",10);
        arr[2]= new Goods("123",9);
        arr[3]= new Goods("1234",3);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     *  comparator接口的使用：定制排序
     *  1.背景
     *  当元素的类型没有实现comparable接口而又不方便修改代码
     *  或者实现的排序规则不适合当前的操作那么可以考虑使用comparator的对象来排序
     *
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","ZZ","BB","CC","RR","QQ","HH"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                  String s1 =(String) o1;
                  String s2 =(String) o2;
                  return -s1.compareTo(s2);
                }
                throw new RuntimeException();
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4() {
        Goods[] arr = new Goods[4];
        arr[0]= new Goods("12",11);
        arr[1]= new Goods("12",10);
        arr[2]= new Goods("123",2);
        arr[3]= new Goods("123",3);
        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if( o1.getName().equals(o2.getName())){
                    //按照价格排序 二级排序
                    if (o1.getPrice()>o2.getPrice()) {
                        return 1;
                    } else if (o1.getPrice()<o2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                  return  o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {

    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof  Goods) {
            Goods goods = (Goods)o;
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price) {
                return -1;
            }else {
                //二级排序 根据名称排
                return this.name.compareTo(goods.name);
            }
           // return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("xxxx");
    }
}