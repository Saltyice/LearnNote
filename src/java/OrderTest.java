package java;

import my.test.Order;

public class OrderTest {
    public static void main(String[] args) {
        Order order  = new Order();
        order.orderPublic=1;
        order.methodPublic();
      //不同包下的普通类要使用Order类,不可以调用声明为private  缺省 protected权限的属性 方法
//        order.orderPrivate =3;
//        order.orderDefault =3;
//        order.orderProtected = 3;
//
//        order.methodPublic();
//        order.methodDefault();
//        order.methodProtected();
    }
}
