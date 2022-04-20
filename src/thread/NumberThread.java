package thread;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

/**
 *   线程的通信
 *
 *   使用两个线程打印1-100 线程1 线程2 交替打印
 *
 *   wait() 一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 *   notify() 一旦执行此方法，就会唤醒wait的一个线程，如果有多个线程阻塞就唤醒优先级高的线程
 *   notifyAll() 一旦执行此方法就会唤醒所有被wait的线程
 *
 *  wait notify notifyAll 三个方法必须使用在同步代码块或同步方法种
 *  wait notify notifyAll 三个方法的调用者必须是同步代码块或者同步方法中的同步监视器
 *  否则会出现异常
 *  wait notify notifyAll 三个方法都是定义在Object类中
 *
 *
 *  面试题： sleep（）和wait（）方法的异同
 *  相同点：都可以让当前线程进入阻塞状态
 *  不同点 sleep（）到了时间后会自动唤醒   wait方法要手动唤醒
 *   sleep（）在Thread类中 wait方法定义在Object中
 *   sleep方法可以在任何需要的场景下调用，wait方法必须使用在同步监视器中
 *   wait方法会释放锁 sleep方法不会
 *
 *
 */
public class NumberThread {
    public static void main(String[] args) throws InterruptedException {
        NumberPrint thread = new NumberPrint();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        thread1.start();
        thread2.start();
    }
}

class NumberPrint implements Runnable {
    static int number = 1;

    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + number);
                    number++;
                    try {
                        //使得当前线程进入阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}