package string;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 *
 *  String类是final的 不可被继承
 *  string实现了Serializable接口，表示字符串是支持序列化的
 *        实现了Compareable接口，表示String可以比较大小
 *  String内部定义了final char[] 用于存储字符串数据
 *  通过字面量的方式（区别于 new的方式）给一个字符串赋值,此时的字符串声明在字符串
 *  常量池中
 *  String具有不可变性！
 *    体现1：当字符串重新赋值时需要重写指定内存区域赋值,不会在当前内存区域重新赋值
 *       2: 当字符串进行连接操作时，也需要重新指定内存区域赋值
 *       3:当调用String的replace方式修改字符串时，也是重新指定内存区域赋值
 *
 *  JVM 方法区内部 存在字符串常量池，常量池内不会存在相同的字符串。
 *
 *
 */
public class StringTest {
    @Test
    public void test() {
        String a = new String("a");
        String b ="b";//字面量的定义方式
        //以上两种定义方式是不一样的，字面量定义的值是存储在字符量常量池中
        //new String（）的值是存储在堆中
    }


    /**
     * 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
     * 只要其中有一个是变量，救国就在堆中
     *
     */
    @Test
    public void test1(){
        // 只有在这两种情况下会将对象引用自动加入到常量池
        String str1 = "aaa";
        String str2 = "aa"+"a";


        String s1 = "hello";
        String s2 = "world";
        String s3 =s1+s2; //有变量的是赋值在堆中
        String s4 = (s1+s2).intern();//intern方法返回值是常量池中的
        System.out.println(s3 == s4); //false
        System.out.println(s4 == "helloworld"); //true

        final String s5 = "hello";
        String s6 = s5+"world";
        System.out.println(s6 == s4); //true  加了final就是常量了

        final String s7 = "world";
        System.out.println((s5+s7) == s4); //true
    }

    //String 与 char[] 之间的转换
    @Test
    public void test2(){
        String str = "abc";
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length  ; i++) {
            System.out.println(i);
        }
        String str1 = new String(chars);

    }

    //String 与byte[] 互相转换
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str = "abd中国";
        byte[] bytes  =str.getBytes(); //默认字符集
        System.out.println(Arrays.toString(bytes));//[97, 98, 100, -28, -72, -83, -27, -101, -67]
        byte[] byteps = str.getBytes("gbk");
        System.out.println(Arrays.toString(byteps));//[97, 98, 100, -42, -48, -71, -6]
        //英文对应的Unicode编码两种字符集都是一样的，UTF-8 中文占三个字节 ，gbk是2个字节

        System.out.println(new String(bytes)); //abd中国
        System.out.println(new String(byteps)); //会乱码 因为字符集不一样
        System.out.println(new String(byteps, "gbk" )); //设置为正确字符集就不会报错了

    }

}


class LXB{
    String name;
    int id;
    Ice ice;
}


class Ice {
    int id;
}