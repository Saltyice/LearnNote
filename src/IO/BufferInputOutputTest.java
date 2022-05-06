package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 缓冲流的使用
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 */
public class BufferInputOutputTest {
    //用了处理流会比原来快
    @Test
    public void BufferedStreamTest() throws IOException {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File("");
            File file1 = new File("");
            //节点流
            FileInputStream fileInputOutputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            //处理流
            bufferedInputStream = new BufferedInputStream(fileInputOutputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);

                //bufferedOutputStream.flush(); 刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //要先关闭外层流再关闭内层流
            //关闭外层流的同时内层六也会自动关闭，我们可以不关内层流
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }

    //练习：
    // 加密图片
    @Test
    public void exercise() throws IOException {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File("1.2KV 其二2560x1440.jpg");
            File file1 = new File("test.jpg");
            //节点流
            FileInputStream fileInputOutputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            //处理流
            bufferedInputStream = new BufferedInputStream(fileInputOutputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //图片加密
            int b=0;
            while ((b= bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(b^5);

                //bufferedOutputStream.flush(); 刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //要先关闭外层流再关闭内层流
            //关闭外层流的同时内层六也会自动关闭，我们可以不关内层流
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }
    }



    @Test
    public void StreamTest() throws IOException {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("hello1.txt");
            File file1 = new File("hello4.txt");
            //节点流
            FileReader fileReader = new FileReader(file);
            FileWriter fileWriter = new FileWriter(file1);
            //处理流
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            //方式一
//            char[] bytes = new char[10];
//            int len;
//            while ((len = bufferedReader.read(bytes)) != -1) {
//                bufferedWriter.write(bytes, 0, len);
//            }
            String data=null;
            while((data=bufferedReader.readLine()) != null){
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
