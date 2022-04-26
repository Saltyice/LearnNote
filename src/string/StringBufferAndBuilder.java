package string;

import org.junit.jupiter.api.Test;

/**
 *
 *  StringBuffer 和StringBuilder
 *
 *  String  StringBuffer StringBuilder 的异同
 *  String 不可变的字符序列
 *  StringBuffer  可变序列 线程安全的 效率低
 *  StringBuilder 可变序列 线程不安全 效率高 JDK5.0新增
 *
 *  效率：builder》buffer》string
 *
 */
public class StringBufferAndBuilder {
    @Test
    public void test(){
        String str = new String();//new char[0]
        String str1 = new String("abc");// new char['a','b','c']
        StringBuffer stringBuffer = new StringBuffer();/* new char[16] */
        stringBuffer.append('a'); //value[0]='a'
        StringBuffer stringBuffer1 = new StringBuffer("abc");//new char[str.length+16]
        StringBuffer stringBuffer2 = new StringBuffer();
        System.out.println(stringBuffer2.length()); //0 返回的不是数组长度是字符串长度
        System.out.println(stringBuffer1.length()); //3
        //StringBuffer的扩容，默认是原来容量的2倍+2，还不够就是加上append字符串的长度。再将字符复制到新数组
        //buffer常用方法
        stringBuffer1.append(1); //abc1
        stringBuffer1.delete(1,2);//ac1
        stringBuffer1.replace(0,1,"b");//bc1
        stringBuffer1.insert(2,"d");//bcd1
        stringBuffer1.reverse();//1dcb
    }
}
