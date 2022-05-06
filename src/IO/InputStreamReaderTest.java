 package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之二：转换流
 * 转换流属于字符流
 * InputStreamReader ：将字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流的转换
 *
 * 解码：字节 字节数组》字符数组 字符串
 *  编码：字符数组 字符串》字节 字节数组
 *
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        //字节流转字符流 主要用于修改指定字符集
        FileInputStream fileInputStream = new FileInputStream("hello1.txt");
       // InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);//使用系统默认的字符集
        //参数2 指明了字符集，具体使用哪个字符集取决于文件保存时使用的字符集
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");//使用系统默认的字符集
        char[] chars = new char[10];
        int len;
        while((len = inputStreamReader.read(chars))!=-1){
            String str = new String(chars,0,len);
            System.out.println(str);
        }
        inputStreamReader.close();
    }

    @Test
    public void test() throws IOException{
        File file = new File("hello1.txt");
        File file1 = new File("hello5.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
        char[] chars = new char[10];
        int len;
        while((len = inputStreamReader.read(chars))!=-1){
            outputStreamWriter.write(chars,0,len);
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }

}
