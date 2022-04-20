package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  解决线程安全问题的方式三：lock锁 --JDK5.0新增
 *
 *
 *  面试题：synchronized和Lock异同
 *   相同：两者都是为了解决线程安全问题
 *   不同 ：synchronized机制在执行完相应的同步代码后，自动释放
 *    锁就需要手动的启动同步，和解锁
 *
 *
 *
 */
public class ThreadLock {
    public static void main(String[] args) {
        SellWindows sellWindows = new SellWindows();
        Thread thread = new Thread(sellWindows);
        Thread thread2 = new Thread(sellWindows);
        Thread thread3 = new Thread(sellWindows);

        thread.start();
        thread2.start();
        thread3.start();
    }
}


class SellWindows implements Runnable {
    private int tick =100;

    //可以设置是否是公平锁
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if (tick>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"  "+tick);
                    tick--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}