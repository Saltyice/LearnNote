package designpattem;

/**
 * 单例设计模式
 *
 * 饱汉式和饿汉式 区别就是类的实例对象在何时实例化
 * 需要获取实例化对象才实例化时饱汉式
 * 类加载时就实例化时饿汉式
 *
 *
 *  饿汉式：
 *   好处：线程安全的
 *   坏处：占用系统内存比饱汉式高，因为一开始就实例化了
 *
 *
 *  饱汉式
 *  好处 占用系统内存少，需要使用才实例化
 *  坏处：线程不安全的
 *
 *
 *
 */
public class Singleton {

    public static void main(String[] args) {
        XXX x = XXX.getXXX();
    }
}

//饿汉式
class XXX{

    private XXX() {

    }

    private static XXX xxx=new XXX();

    //因为构造器权限时private，所以单例模式获取对象的方法要加上static，不然无法在类外调用
    public static XXX getXXX(){
        return xxx;
    }

}

//饱汉式
class SSS{

    private SSS(){

    }

    private static SSS sss=null;

    private static SSS getSSS(){
        if (sss == null){
            return new SSS();
        }
        return sss;
    }
}