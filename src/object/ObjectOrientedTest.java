package object;

public class ObjectOrientedTest {
    public static void main(String[] args) {
        //匿名对象
        new Phone().price=1000d;
        new Phone().showPrice();

        //匿名对象使用场景
         PhoneMall mall = new PhoneMall();
         mall.show(new Phone());
    }

    public void method(int a,int b) throws InterruptedException {
        System.out.println("a=100");
        System.out.println("b=200");
        for(;;) {
            int aa=1;
        }
    }

}

class PhoneMall{

 public void show(Phone phone){
     phone.sendMail();
     phone.showPrice();
 }
}

class Phone {
    double price;
    String number;

    public void sendMail(){
        System.out.println("test");
    }

    public void showPrice() {
        System.out.println(number);
    }
}


