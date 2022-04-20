package thread;

/**
 *  例子：三个售票窗口售卖100张票
 *
 *  创建多线程的方式二：实现Runnable接口
 *   创建一个实现了Runnable接口的类
 *   实现类区实现Runnable中的run()方法
 *   创建实现类的对象
 *   将此对象作为参数传递到Thread类的构造器中，创建Thread类对象
 *   通过Thread类的对象调用start（）方法
 *
 *  实现runnable接口方式比继承Thread类好
 *   实现接口的方式天然的可以共享数据，而且类无需继承父类（避免类只能单继承的问题）
 *
 *
 *   线程安全问题出现的原因，某个线程操作车票的过程中，尚未完成操作时，极小概率情况下会有其余线程参与进来也操作车票数量。导致数量异常
 *   解决方法：同步机制!确保一个线程在操作车票时，其他线程不能参与进来。直到当前线程操作完毕为止，其他线程才能继续操作。即使会造成阻塞也要
 *   这么做
 *   同步机制时用来解决线程安全问题的。
 *
 *   解决方法一：
 *      同步代码块
 *        synchronized（同步监视器） {
 *            需要同步的代码块
 *        }
 *        说明：操作共享数据的代码，即为需要被同步的代码
 *         共享数据：多个线程操作的变量就是共享数据
 *         同步监视器 俗称 锁。任何一个类的对象都可以充当锁
 *         多个线程必须要共用同一锁也就是同一个对象，锁才能生效
 *         继承方式的多线程可以考虑用类本身当锁
 *         接口方式的多项成可以用对象当锁
 *
 *
 *  解决方法二：
 *     同步方法
 *       如果操作共享数据的代码都声明在一个方法中，我们可以将方法声明为同步的。
 *       间class WindowThree
 *
 */
public class NewThread {
    public static void main(String[] args) {
        /***
         *
         *  存在线程安全问题
         *  多个线程同时访问一个静态变量会出现超卖
         */
//        Window t1 = new Window();
//        Window t2 = new Window();
//        Window t3 = new Window();
//        t1.setName("Window1");
//        t2.setName("Window2");
//        t3.setName("Window3");
//        t1.start();
//        t2.start();
//        t3.start();
         //多线程方式二：创建实现类的对象(这种方式就是设计模式中的代理人模式)
         Windows windows = new Windows();
         //将类对象作为参数传递到Thread类的构造器
         Thread thread = new Thread(windows);
         Thread thread1 = new Thread(windows);
         Thread thread2 = new Thread(windows);
         //执行thread的start
         thread.start();
         thread1.start();
         thread2.start();

    }
}


class Window extends Thread{
    private static int ticket =100;
    @Override
    public void run(){
        while(true){
            //继承方式的多线程可以用类本身当锁
            synchronized(Window.class){
                if (ticket>0) {
                    System.out.println(getName()+"  "+ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

class Windows implements Runnable{
    //可以不加static，因为只new了一个对象
    private  int ticket =100;
    private Object obj = new Object();
    @Override
    public void run() {
        while(true){
            //通过同步代码块就可以解决线程安全的问题
            //synchronized(obj){
            //使用类本身当锁就不用new对象了
            synchronized(this){
                    if (ticket>0) {
                        System.out.println(ticket);
                        ticket--;
                    } else {
                        break;
                    }
            }

        }
    }
}

//接口实现方式用同步方法来解决线程安全问题
class WindowThree implements  Runnable{
    private  int ticket =100;

    @Override
    public void run() {
        while(true){
            sell();
        }
    }

    private synchronized void sell(){ //同步方法的锁就是本身对象 this
        if (ticket>0) {
            System.out.println(ticket);
            ticket--;
        } else {
            return;
        }
    }
}

//继承实现方式用同步方法解决线程安全问题
class WindowFour extends Thread {
    private static int ticket =100;
    public void run() {
        while (true) {
            code();
        }
    }

    //继承方式要把方法声明为静态的，否则锁不会生效，锁是类本身WindowFour.class
    public static synchronized void code(){
        if (ticket>0) {
            System.out.println(ticket);
            ticket--;
        } else {
            return;
        }
    }

}