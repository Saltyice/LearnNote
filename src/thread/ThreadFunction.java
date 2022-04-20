package thread;

/**
 *  Thread中常用的方法
 *  run()  需要重写的方法，线程执行的逻辑在该方法中
 *  start()  启动线程，并调用run（）方法
 *  currentThread() 静态方法，返回执行当前代码的线程
 *  getName()  获取线程名
 *  setName() 设置线程名
 *  yield()  释放当先线程的执行权，把CPU让给其他线程
 *  join()   在线程A中调用线程B的join()方法，此时线程A进入阻塞状态，直到线程B执行完，线程A才进行执行
 *  stop()   停止当前线程 （已经过时了）
 *  sleep()  让当前线程休眠 （单位毫秒）,线程进入阻塞状态
 *  isAlive() 判断线程是否存活
 *
 *
 *
 *  线程的优先级  最高是10 默认是5
 *  MAX_PRIORITY=10
 *  MIN_PRIORITY =1;
 *  NORM_PRIORITY =5
 *  线程优先级高只是代表线程被CPU执行的概率较高，不是高优先级就优先执行
 *
 *
 *
 */
public class ThreadFunction {
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Test1");
        //获取线程优先级
        Thread.currentThread().getPriority();
        PrintThread printThread = new PrintThread();
        printThread.start();
        //设置线程优先级
        printThread.setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i %2 ==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
            if (i % 10 ==0) {
                Thread.currentThread().join();
            }
        }
    }
}

class PrintThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i %2 !=0){
                System.out.println(Thread.currentThread().getName()+i);
            }
            try {
                //线程休眠
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 10 ==0) {
                //线程释放
                this.yield();
            }
            System.out.println(this.isAlive());
        }
    }
}