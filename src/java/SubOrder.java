package java;

import my.test.Order;

public class SubOrder extends Order {
//123123
    public void method(){
        orderProtected =1;
        orderProtected=1;
        //在不同包中的子类中，不能调用Order类中声明的private 和default的属性和方法
//        orderDefault =3;
//        orderPrivate =3;
    }

    public static void main(String[] args) {
        Order order  = new Order();
    }
}
