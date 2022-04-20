package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 *  创建线程的方式三：实现Callable接口 --JDK5.0新增
 *
 *
 *  使用Callable接口比用Runnable的好处
 *  1. call方法有返回值
 *  2. call方法可以抛出异常
 *  3. call方法支持泛型
 *
 *
 */
//1.创建一个类实现Callable接口
class NumThread implements Callable{
    //2.重写call方法
    @Override
    public Object call() throws Exception {
        int sum =0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2==0){
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.实例化 Callable接口实现类
        NumThread numThread = new NumThread();
        //4.将实现类对象作为对象，创建FutureTask类对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask类对象作为参数传递到Thread类的构造器种，创建thread类对象
        Thread thread = new Thread(futureTask);
        //6.执行start（）方法
        thread.start();

        try {
            Object num = futureTask.get();
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
