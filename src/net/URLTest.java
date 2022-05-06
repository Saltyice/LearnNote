package net;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class URLTest {
    //URL连接下载图片
    public static void main(String[] args) throws IOException {
        //我的B站头像
        URL url = new URL("https://i2.hdslb.com/bfs/face/0e62722ece4a8588c4ee82a6c2368696de6109ac.jpg@240w_240h_1c_1s.webp");
        System.out.println(url.getPort());  //端口
        System.out.println(url.getHost());  //主机名 域名
        System.out.println(url.getAuthority());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());
        System.out.println(url.getUserInfo());
        System.out.println(url.getFile());
        System.out.println(url.getProtocol());
        System.out.println(url.getRef());
        Object content = url.getContent();
        System.out.println(content.toString());

        //从地址下载文件
        //打开连接
        URLConnection urlConnection = url.openConnection();
        //实际是Http所以进行强转
        HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
        //进行连接 否则获取不到流
        httpURLConnection.connect();
        //获取输入流
        InputStream inputStream = httpURLConnection.getInputStream();
        //建立输入流 准备写入数据
        FileOutputStream fileOutputStream = new FileOutputStream("url.webp");
        //开始读取文件
        byte[] buff  = new byte[1024];
        int len;
        while((len=inputStream.read(buff))!=-1){
            fileOutputStream.write(buff,0,len);
        }
        //关闭连接和流 实际应该用try-catch写关闭语句 有可能关闭出错
        httpURLConnection.disconnect();
        inputStream.close();
        fileOutputStream.close();

    }
}
