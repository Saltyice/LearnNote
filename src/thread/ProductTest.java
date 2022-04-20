package thread;


/**
 *  生产者与消费者
 *
 *
 *
 *
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Customer customer =new Customer(clerk);
        product.setName("product");
        customer.setName("customer");
        product.start();
        customer.start();
    }
}
//店员
class Clerk {
    private int productCount = 0;

    public synchronized void produceProduct() throws InterruptedException {
        if(productCount<20) {
            productCount++;
            System.out.println(Thread.currentThread().getName()+" "+productCount);
            notify();
        } else {
            wait();
        }
    }

    public synchronized void customProduct() throws InterruptedException {
        if (productCount>0) {
            System.out.println(Thread.currentThread().getName()+" "+productCount);
            productCount--;
            notify();
        } else {
            wait();
        }
    }
}
//生产者
class Product extends Thread{
    private Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run(){
        System.out.println("开始生产");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.produceProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//消费者
class Customer extends Thread {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run(){
        System.out.println("开始消费");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.customProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}