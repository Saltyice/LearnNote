package my.test;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.orderProtected =2;
        order.orderPublic =2;
        order.orderDefault =1;
        order.methodDefault();
    }
}
