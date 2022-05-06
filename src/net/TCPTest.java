package net;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;

public class TCPTest {
    //客户端 接收传输内容
    @Test
    public void test() throws IOException {
        //获取本机IP地址
        InetAddress inetAddress = InetAddress.getLocalHost();
        //创建socket连接向指定IP端口发送数据
        Socket socket = new Socket(inetAddress,22103);
        //用输出流传数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("test".getBytes());
        //关闭socket 和流
        outputStream.close();
        socket.close();
    }
    //服务端
    @Test
    public void test1() throws IOException {
        //建立服务端接受数据，IP就是本机不用填IP
        ServerSocket serverSocket = new ServerSocket(22103);
        //获取对应socket连接
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //不建议这么写是因为字节流转字符有可能 转字符乱码
//        byte[] buff = new byte[1024];
//        int len;
//        StringBuilder stringBuilder= new StringBuilder()
//        while((len=inputStream.read(buff))!=-1){
//            stringBuilder.append(buff);
//        }
        //获取并输出信息
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer= new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,len);
        }
        System.out.println(byteArrayOutputStream.toString());
    }
    //服务端 传输文件
    @Test
    public void test2() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),22012);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("1.2KV 其二2560x1440.jpg"));
        byte[] buff = new byte[1024];
        int len;
        while((len=fileInputStream.read(buff))!=-1  ){
            outputStream.write(buff,0,len);
        }
        //关闭socket的输出，不关闭的话后续代码无法执行接收不了服务端的返回
        socket.shutdownOutput();
        //增加接收服务端的返回
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream( );
        byte[] bytes = new byte[1024];
        int length;
        while((length=inputStream.read(bytes))!=-1  ){
            byteArrayOutputStream.write(bytes,0,len);
        }
        System.out.println(byteArrayOutputStream.toString());
        inputStream.close();
        byteArrayOutputStream.close();
        outputStream.close();
        fileInputStream.close();
        socket.close();

    }
    //客户端接收文件
    @Test
    public void test3() throws IOException {
        ServerSocket serverSocket = new ServerSocket(22012);
        Socket accept = serverSocket.accept();
        InputStream inputStream= accept.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("socket.jpg"));
        byte[] buff = new byte[1024];
        int len;
        while((len=inputStream.read(buff))!=-1){
            fos.write(buff,0,len);
        }

        //增加服务端返回成功给客户端
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("接收成功".getBytes());

        outputStream.close();
        inputStream.close();
        fos.close();
        accept.close();
        serverSocket.close();
    }
}
