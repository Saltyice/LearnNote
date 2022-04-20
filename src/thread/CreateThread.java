package thread;

/**
 *
 *   多线程的创建
 *   创建的方式一共又四种
 *
 *
 */
public class CreateThread {
    public static void main(String[] args) {
        SmallThread smallThread = new SmallThread();
        //启动线程,执行了类中的run方法
        //start是启动线程并执行的方法，会调用run方法
        smallThread.start();
        //直接调用run方法是不会启动新线程的
        smallThread.run();
        //一个线程对象只能启动一个线程，同时启动多个线程会报错
        smallThread.start();
        //正确启动再一个线程的方式是再实例化一个对象
        SmallThread small = new SmallThread();
        small.start();
        for (int i = 0; i < 100; i++) {
            if (i %2 !=0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }

    }


    public void exercise() {
        //新建两个线程 分别输出奇数和偶数.
        //用匿名内部类的方式就不用再创建2个线程类
        new Thread(){
            @Override
            public void run() {
                //遍历100内的偶数
                for (int i = 0; i < 100; i++) {
                    if (i %2 ==0){
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                //遍历100内的偶数
                for (int i = 0; i < 100; i++) {
                    if (i %2 !=0){
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                }
            }
        }.start();
    }
}

/**
 *  创建多线程的方式一:
 *  写一个类并继承Thread类
 *  重写run方法
 *  实例化该类并调用start方法既可新建一个线程执行代码
 *
 *
 *
 *
 */
class SmallThread extends Thread{

    @Override
    public void run() {
        //遍历100内的偶数
        for (int i = 0; i < 100; i++) {
            if (i %2 ==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}