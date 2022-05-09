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
 *
 *
 *  根据 jdk9 10 11新特性进行修改
 */
public class FileInputOutputStreamTest {
    public static void main(String[] args) throws IOException {
        //字节流处理中文字符比较麻烦一个中文占3个字节很容易读错
        var file = new File("hello2.txt");
        var fileInputStream = new FileInputStream(file);
        try(fileInputStream) {
            byte[] bytes = new byte[5];
            int len;
            while((len=fileInputStream.read(bytes))!=-1){
                System.out.print(new String(bytes,0,len));

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void test() throws FileNotFoundException {
        var file = new File("1.2KV 其二2560x1440.jpg");
        var file2 = new File("test.jpg");
        var fileInputStream = new FileInputStream(file);
        var fileOutputStream = new FileOutputStream(file2);
        try(fileInputStream;fileOutputStream) {
            byte[] bytes = new byte[100];
            int len;
            while((len = fileInputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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


    public static void copy(String file,String file2) throws FileNotFoundException {
        var fileInputStream = new FileInputStream(file);
        var fileOutputStream =new FileOutputStream(file2);
        try (fileInputStream;fileOutputStream;) {
            fileInputStream.transferTo(fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test6() throws FileNotFoundException {
        copy("copy.txt","copy1.txt");
    }

}
