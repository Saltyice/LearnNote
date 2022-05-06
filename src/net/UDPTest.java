package net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

import static java.net.InetAddress.getLocalHost;

/**
 *
 *
 *  UDP协议
 */
public class UDPTest {
    @Test
    public void test() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket("1211".getBytes(),0,"1211".length(), getLocalHost(),22103);
        socket.send(packet);
        socket.close();
    }

    @Test
    public void test1() throws IOException {
        //记得要指定端口
        DatagramSocket datagramSocket = new DatagramSocket(22103);
        byte[] buff = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buff,0,buff.length);
        datagramSocket.receive(packet);
        packet.getData();
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        datagramSocket.close();
    }
}
