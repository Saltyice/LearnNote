package IO;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;

/**
 *  标准的输入 输出流
 *  System.in 标准的输入流 默认从键盘输入
 *  System.out 标准的输出流，默认输出到控制台
 *
 *  可以用System的 setIn setOut方法重新指定输入输出的流
 *
 *  练习
 *   从键盘输入自负床，要求将读取到的整行字符串转成大写输出
 *   然后继续进行操作知道 输入 e 或exit退出
 *
 *   方法一 使用scanner实现 调用next() 返回一个字符串
 *   方法二 使用System.in实现
 *
 *
 */
public class SystemStreamTest {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader   bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("请输入字符串");
        while(true){
            String data = bufferedReader.readLine();
            if (data.equalsIgnoreCase("e")|| data.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println(data.toUpperCase());
        }
        bufferedReader.close();

    }
}
