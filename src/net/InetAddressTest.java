package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 *  IP和端口号
 *  java用InetAddress表示IP
 *  IP分类 IPV4 IPV6
 *  域名 baidu.com
 *  socket就是IP加端口
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("192.168.0.1");
        System.out.println(ip);
        InetAddress ip2 =InetAddress.getLocalHost();
        System.out.println(ip2);

        InetAddress ip3 =InetAddress.getByName("www.vip.com");

        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
    }

}
