package IO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 *  RandomAccessFile实现了DataInput DataOutput接口
 *  RandomAccessFile既可以输入流也可以作为输出流
 *
 * RandomAccessFile可以实现插入
 *
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        //第二个参数mode有4种方式
        // r只读
        // rw 可以读取写入
        // rws 可以读取写入同步文件内容更新
        // rwd 读取写入 同步文件内容原数据更新
        RandomAccessFile file = new RandomAccessFile("hello1.txt","rw");
        RandomAccessFile file1 = new RandomAccessFile("hello7.txt","rw");
        //获取当前指针指向的位置
        file1.getFilePointer();
        //读与 写
        byte[] bytes = new byte[1024];
        int len;
        while((len=file.read(bytes))!=-1){
            file1.write(bytes,0,len);
        }
        file.close();
        file1.close();
    }

    @Test
    public void test() throws  IOException {
        //RandomAccessFile写的文件如果不存在会创建
        //如果写的文件存在会从头开始写文件内容，而不是把整个文件覆盖
        RandomAccessFile file = new RandomAccessFile("hello8.txt","rw");
        file.write("12345".getBytes());
        //文件指针 可以调整内容写入的位置
        file.seek(5);
        file.write("678".getBytes());
        file.close();
    }
    //在文件指定位置插入内容
    //还可以通过 BufferedReader ByteArrayOutputStream实现插入
    @Test
    public void test1() throws IOException{
        RandomAccessFile file = new RandomAccessFile("hello8.txt","rw");
        file.seek(1);
        //将插入位置后的内容保存起来
        byte[] buffer = new byte[20];
        int len;
        StringBuilder builder = new StringBuilder();
        while((len=file.read(buffer))!=-1){
            builder.append(file.read(buffer,0,len));
        }
        file.seek(1);
        file.write("test".getBytes());
        file.close();
    }
}
