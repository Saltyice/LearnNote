package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *  代理模式：动态代理 AOP
 *
 *
 */


//接口
interface AInterface{
    void function();
    public int test(String str);

    private void momo(){
        System.out.println("1231231");
    }
}

//需要被代理的类 代理类
class ProxyClass implements AInterface{

    @Override
    public void function() {
        System.out.println("Actually done");
    }

    @Override
    public int test(String str) {
        System.out.println(str);
        return 0;
    }


}

class Handler implements InvocationHandler{
    //对应需要被代理类的对象
    private Object obj;

    public Handler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I am Proxy");
        return method.invoke(obj,args);
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        //被代理类
        ProxyClass proxyClass = new ProxyClass();
        //创建了代理类
        AInterface obj =(AInterface) Proxy.newProxyInstance(ProxyClass.class.getClassLoader(),ProxyClass.class.getInterfaces(),new Handler(proxyClass));
        //调用代理类的方法,实际上还调用了被代理类的方法
        obj.function();
        //
        obj.test("print");
    }

}
