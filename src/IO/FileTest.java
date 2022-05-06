package IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 * File类
 *  File类的一个对象，代表一个文件或一个文件目录
 *  File类声明在java.io包下
 *  File类涉及到关于文件的创建 修改 重命名 修改时间 文件大小等方法
 *  并未设计到写入或读取操作，如果要读取写入文件内容必须使用IO流完成
 *
 * 1.创建实例
 *
 * 2. 相对路径
 *    绝对路径
 *
 * 3.路径分隔符
 *  windows：\\
 *  unix:/
 *  */

public class FileTest {
    public static void main(String[] args) {
        //相对路径
        File file = new File("hello.txt");
        //绝对路径
        File file2 = new File("\u202AD:\\Genshin Impact\\api-ms-win-core-processthreads-l1-1-1.dll") ;

        //file可以是一个目录
        File file1 = new File("D:\\","Genshin Impact");
        //构造器3
        File file3 = new File(file1,"api-ms-win-core-processthreads-l1-1-1.dll");

        System.out.println(file.getAbsolutePath());//绝对路径
        System.out.println(file.getPath()); //获取路径
        System.out.println(file.getName());  //获取文件名
        System.out.println(file.getParent());  //
        System.out.println(file.length());  //文件长度
        System.out.println(file.lastModified()); //修改时间

        //获取当前目录下文件目录与文件
        String[] list = file1.list();
        for (String name: list){
            System.out.println(name);
        }
        //获取当前目录下文件目录与文件
        File[] fileList = file1.listFiles();
        for (File filePath:fileList){
            System.out.println(filePath);
        }
    }
    @Test
    public void test()  {
        //文件重命名 要重命名成功需要 file1不存在  file存在
        File file = new File("hello.txt");
        File file1 = new File("hello1.txt");

       // System.out.println(file.renameTo(file1));

        repeat(file1);

        File file2= new File("D:\\","Genshin Impact");
        repeat(file2);


    }

    private void repeat(File file2) {
        System.out.println(file2.isDirectory()); //是否目录
        System.out.println(file2.isFile()); //是否文件
        System.out.println(file2.exists());//是否存在
        System.out.println(file2.canRead()); //是否可读
        System.out.println(file2.canWrite()); //是否可写
        System.out.println(file2.isHidden()); //是否隐藏
    }
    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        if (!file.exists()) {
            //创建文件
            file.createNewFile();
        } else{
            //删除文件或目录
            file.delete();
        }
    }
    @Test
    public void test2(){
        File file = new File("D://12/1");
        //创建文件夹，连上级目录一起创建
        file.mkdirs();
        //创建文件夹，上级目录不存在就不创建
        file.mkdir();
    }
}
