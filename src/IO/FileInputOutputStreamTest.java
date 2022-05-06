package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *
 *
 * 测试FileInputStream FileOutputStream
 *
 *  文本文件使用字符流处理
 *  非文本使用字节流处理
 *
 *  节点流复制文件比处理流慢
 */
public class FileInputOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //字节流处理中文字符比较麻烦一个中文占3个字节很容易读错
        File file = new File("hello2.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[5];
        int len;
        while((len=fileInputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }
    }
    @Test
    public void test() throws IOException {
        File file = new File("1.2KV 其二2560x1440.jpg");
        File file2 = new File("test.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bytes = new byte[100];
        int len;
        while((len = fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes);
        }
    }


    //复制文件方法
    public static void copy(File file,File file2){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream =null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);
            byte[] bytes = new byte[100];
            int len;
            while((len = fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if (fileInputStream !=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (fileOutputStream !=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
