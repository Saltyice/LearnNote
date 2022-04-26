package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *  创建线程的方式四：创建线程池
 *
 *
 */
public class ThreadPool {
    public static void main(String[] args) {
        //创建固定线程数量的线程池
        //ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        //设置线程池数量
        service.setCorePoolSize(10);
        //设置最大线程数
        service.setMaximumPoolSize(20);
        //设置活跃时间
        service.setKeepAliveTime(100L, TimeUnit.DAYS);
        //设置线程池的属性
        service.execute(new Thread(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }); //适合适用于Runnable

        //service.submit(new Thread(){});//适合适用于Callable
        
        //关闭线程池
        service.shutdown();
    }
}

