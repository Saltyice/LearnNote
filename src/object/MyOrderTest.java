package object;

import java.util.Objects;

public class MyOrderTest {

}
class MyOrder {
    String orderName;
    int orderId;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public MyOrder(String orderName, int orderId) {
        this.orderName = orderName;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyOrder)) return false;
        MyOrder myOrder = (MyOrder) o;
        return getOrderId() == myOrder.getOrderId() && Objects.equals(getOrderName(), myOrder.getOrderName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderName(), getOrderId());
    }
    //    public boolean equals(Object obj) {
//        if (this ==obj)
//            return true;
//        if (obj instanceof MyOrder) {
//            MyOrder order = (MyOrder) obj;
//            return this.orderName.equals(order.orderName) && this.orderId == order.orderId;
//        }
//        return false;
//    }

}

class MyDate {
    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }



    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}