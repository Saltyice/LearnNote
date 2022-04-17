package designpattem;

/**
 *
 *  代理模式
 *  代理模式示例
 *
 */
public class ProxyTest {

    public static void main(String[] args) {
        //被代理类
        NetWork netWork = new Real();
        //代理类
        ProxyNetWork proxyNetWork = new ProxyNetWork(netWork);

        proxyNetWork.Net();

        proxyNetWork.Brose();
    }

}

interface NetWork {
    void Net();

    void Brose();
}


class Real implements NetWork{

    @Override
    public void Net() {

    }

    @Override
    public void Brose() {

    }
}


class ProxyNetWork implements NetWork {

    private NetWork netWork;


    public ProxyNetWork(NetWork netWork) {
        this.netWork = netWork;
    }

    @Override
    public void Net() {
        System.out.println();
    }

    @Override
    public void Brose() {
        //实际执行的是被代理类的方法
        System.out.println("");
        netWork.Brose();
    }
}