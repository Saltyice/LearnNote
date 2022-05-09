package jdk8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamTest {
    {
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("9");
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("4");
        list.add("5");
    }
    static ArrayList<String> list =new ArrayList<>();


    //Steam 创建方式一 通过集合
    @Test
    public void test() {
        //方式一 顺序流
        Stream<String> stream = list.stream();
        //方式一 并行流   无序的 速度快
        Stream<String> stream1 = list.parallelStream();

        // 方式二 通过Stream静态方法
        Stream stream2= Stream.of(list);
        // 方式三  Arrays的方法
        IntStream stream3 =Arrays.stream(new int[]{1,2,3,4,5,});
        //方式四 无限流
        Stream.iterate(0,t->t+2).limit(100).forEach(System.out::println);
        //无限流
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //Stream的筛选切片操作
    @Test
    public void test1() {
        //filter 筛选
        list.stream().filter(s -> s.contains("2")).forEach(System.out::println);
        System.out.println("**************");
        // 截断
        list.stream().limit(4).forEach(System.out::println);
        System.out.println("**************");
        // 跳过
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("**************");
        //去重
        list.stream().distinct().forEach(System.out::println);
    }
    //映射操作
    @Test
    public void test2() {
        list.stream().map(String::hashCode).forEach(System.out::println);
        System.out.println("**************");

        list.stream().flatMap(SteamTest::stringStream).forEach(System.out::println);
        System.out.println("**************");
        list.stream().map(SteamTest::stringStream).forEach(System.out::println);
    }

    //排序
    public void test3(){
        //自然排序
        list.stream().sorted().forEach(System.out::println);
        //定制排序
        list.stream().sorted((s1,s2)-> -s1.compareTo(s2)).forEach(System.out::println);
    }

    //终止操作
    public void test4() {
        //allMatch 是否全部匹配
        boolean flag=list.stream().allMatch(s -> s.contains("1") && s.contains("2"));

        //是否存在匹配的
        boolean flag1= list.stream().anyMatch(s ->s.contains("1"));

        //不存在匹配的
        boolean flag2 = list.stream().noneMatch(s-> s.startsWith("4"));
        //返回第一个元素
        Object flag3 = list.stream().findFirst();
        //返回任意一个元素
        list.stream().findAny();

        //返回个数
        list.stream().count();
        //最大
        list.stream().max(String::compareTo);
        //最小
        list.stream().min(String :: compareTo);
        //
        list.stream().forEach(System.out::println);
    }
    //终止操作 归约
    @Test
    public void test5(){
        //计算1到10的和
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).reduce(0,Integer::sum);
        //将所有元素拼接在一起
        System.out.println(list.stream().reduce(String::concat));
    }
    //终止操作 收集
    public void test6(){
        //将流中元素转换为集合  List set Collections
        list.stream().filter(s-> s.contains("1")).collect(Collectors.toList());
        list.stream().collect(Collectors.toSet());


    }


    public static Stream stringStream(String str){
        List list = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list.stream();
    }
}
