package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *
 *  对象流
 *
 */
public class ObjectInputStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //用对象流将String对象写入文件
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
        objectOutputStream.writeObject(new String("ABCDEFG"));
        objectOutputStream.close();
        //从文件中读取对象并输出
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
        Object readObject = objectInputStream.readObject();
        System.out.println((String) readObject);
        objectInputStream.close();
    }

    @Test
    public void test() throws IOException {
        //将自定义类持久化到文件中 ,对应的类需要实现serializable接口并定义serialVersionUID
        OriginObject originObject = new OriginObject();
        originObject.name="test";
        originObject.number=121;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("originObject.txt"));
        objectOutputStream.writeObject(originObject);
        objectOutputStream.close();
    }
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        //从文件中读取对象并输出
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("originObject.txt"));
        Object readObject = objectInputStream.readObject();
        System.out.println(readObject);
        objectInputStream.close();
    }
}
