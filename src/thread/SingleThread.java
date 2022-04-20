package thread;

/**
 *
 * 将单例模式中的懒汉式修改为线程安全的
 *
 *
 *
 */
public class SingleThread {
   public static  SingleThread ojb;

    private SingleThread(){

    }
    //方式一：同步方法
//    private static synchronized SingleThread getInstance(){
//        if (ojb ==null){
//            return new SingleThread();
//        }
//        return ojb;
//    }
    //方式二：同步代码块
//     private static SingleThread getInstance(){
//        synchronized (SingleThread.class){
//        if (ojb ==null){
//            return new SingleThread();
//        }
//        return ojb;
//        }
//     }
    //方式三： 比上面2种效率高些，如果有许多线程同时执行的话，能减少线程等待的时间
    private static SingleThread getInstance(){
        if (ojb ==null) {
            synchronized (SingleThread.class){
                if (ojb ==null){
                    return new SingleThread();
                }
            }
        }
        return ojb;
    }


}
