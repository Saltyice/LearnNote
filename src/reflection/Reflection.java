package reflection;

import object.BankAccountTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *  反射
 *
 */
public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //获取对应的类
        Class clazz = BankAccountTest.class;
        //通过类获取对应的构造器
        Constructor constructor = clazz.getConstructor();
        //用对应类的构造器 new一个对象
        Object object = constructor.newInstance();
        BankAccountTest bankAccountTest = (BankAccountTest)object;
        //获取类的对应属性
        Field field = clazz.getDeclaredField("");
        //再通过类的属性去设置对象的值
        field.set(bankAccountTest,10);
        //获取类的对应方法
        Method show = clazz.getDeclaredMethod("");
        //用反射的方式去调用类的方法
        show.invoke("","");

        //通过反射，可以调用类的私有方法 私有属性
    }

    /**
     *  关于java.lang.Class的理解
     *  1.类的加载过程
     *  程序经过java.exe命令以后，会生成一个或多个字节码文件
     *  接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
     *  加载到内存种，此过程称为类的加载。加载到内存种的类，我们就称为运行时类/
     *  此类就是Class的一个实例
     *
     *  换句话说，Class的实例就是一个运行时类
     *  记载到内存种的运行时类，会缓存一定的时间，直到被jvm回收。在缓存时，我们可以通过不同方式来
     *  获取此运行时类
     *
     *
     *
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test() throws ClassNotFoundException {
        //获取类的四种方式

        //1 调用运行时类的属性
        Class clazz = Object.class;

        //2  通过运行时类的对象的getClass方法
        Object object = new Object();
        Class clazz1 = object.getClass();

        //3 调用Class的静态方法 forName  （常用）
        Class clazz2 = Class.forName("Object");

        // 4 通过类的加载器
        ClassLoader classLoader = Object.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("java.lang.Object");

    }
}
