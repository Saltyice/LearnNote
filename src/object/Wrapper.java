package object;

import com.sun.jdi.FloatType;
import org.junit.jupiter.api.Test;

/**
 *
 * 包装类的使用
 * 8种基本数据类型的包装类
 *
 * 掌握 基本数据  包装类 String三者之间的转换
 *
 *
 *
 */
public class Wrapper {






    //基本数据类型》包装类 调用包装类的构造器
    @Test
    public void test1(){
        int num1 = 10;
        //过时装箱
        Integer i = new Integer(num1);
        //自动装箱
        Integer i1 = num1;
        System.out.println(i.toString());
        //会报错
        //Integer b = new Integer("abc");

        //过时
        Float f1 = new Float("12.3");
        Float f2 = new Float(12.3);
        //时髦
        Float f3 = Float.valueOf("123");
        Float f4 = Float.valueOf(12F);
        System.out.println(f1);
        System.out.println(f2);

        //不会报错 Boolean有特殊处理 不是true都是false
        Boolean boo = new Boolean("true123");
        System.out.println(boo);
    }

    //包装类》基本数据类型
    @Test
    public void test2(){
        Integer in1 = 12;
        int aaa=in1.intValue();

    }

    /**
     *
     * JDK5.0 新特性
     * 自动装箱  拆箱
     */
    @Test
    public void test3(){

        int innnn = 3;
        //用了自动装箱
        testMethod(innnn);

        Double ddd = 34.44;
        //自动拆箱
        double dd = ddd;
    }

    public void testMethod(Object obj){

    }

    /**
     * 包装类 基本数据类型》String
     */
    @Test
    public void test4(){
        //方式一
        int num =10;
        String str1 = num+"";
        //方式2 调用String的valueOf
        float f1 = 12.3f;
        String str = String.valueOf(f1);

        Double d1 = 1234D/5;
        String str3 = String.valueOf(d1);
        //方式3 调用包装类 的toString
        String str2 = d1.toString();
    }

    /**
     * String>包装类 基本数据类型
     */
    @Test
    public void test5(){
       Integer in =  Integer.parseInt("123");
       //会报错
       int innnn = Integer.parseInt("123a");
    }

}
