package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *  流的分类
 *   操作数据类型 字节流 字符流
 *
 *   数据流向 输出流 输入流
 *
 *   流的角色 处理流 节点流
 *
 *   流的体系结构
 *
 *   InputStream    FileInputStream      BufferedInputStream
 *   OutputStream   FileOutputStream     BufferedOutputStream
 *   Reader         FileReader           BufferReader
 *   Writer         FileWriter           BufferWriter
 *
 */
public class FileReaderWriterTest {

  @Test
  public void test() {
      FileReader reader = null;
      try {
          //实例化File类的对象，指名要操作的文件
          File file = new File("hello.txt");
          //提供具体的流
          reader = new FileReader(file);
          //数据的读入
          //read 返回读入的一个字符,如果达到文件末尾,返回-1
          //每次调用只读取一个字符
          int data;
          while ((data = reader.read()) != -1) {
              System.out.print((char) data);
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          //如果流初始化失败就不用关闭了
          if (reader !=null) {
              try {
                  reader.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }

      }
  }

  public void test1() {
      FileReader reader =null;
      File file = new File("");
      try {
          reader  = new FileReader(file);
          char[] buffer= new char[5];
          //带char[]数组的read方法，每次返回读取字符的长度，如果读到末尾则返回-1
          int len;
          while((len = reader.read(buffer))!=-1){
              //读到最后不满长度5的时候,char[]末尾几位还是上一次读取的结果所以
              //输出的时候要设定长度避免输出多了
              System.out.println(new String(buffer,0,len));
          }
      } catch (IOException e) {
          throw new RuntimeException(e);
      } finally {
          if (reader!=null){
              try {
                  reader.close();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
      }
  }

  @Test
  public void test3() throws IOException {
      File file = new File("hello2.txt");
      //write方法如果对应的文件不存在会创建文件
      //如果构造器没指定append为true则会覆盖原有文件里的内容
      //append为true的话则会在原来文件内容上继续写入
      FileWriter writer = new FileWriter(file,true);
      writer.write("hello ");
      writer.write("world!");
      writer.close();
  }

  @Test
  public void testReadAndWrite() throws IOException {
      FileWriter writer = null;
      FileReader reader = null;
      try {
          //读取文件然后写入 只能拿处理字符文件
          //图片视频无法处理
          File file = new File("hello1.txt");
          File file1 = new File("hello3.txt");
          reader = new FileReader(file);
          writer = new FileWriter(file1);

          char[] buffer = new char[5];
          int len;
          while ((len = reader.read(buffer)) != -1) {
              writer.write(buffer, 0, len);
          }
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
              reader.close();
              writer.close();
      }

  }

}
