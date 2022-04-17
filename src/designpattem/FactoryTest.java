package designpattem;

/**
 *  工厂模式
 *
 *
 *
 *
 */
public class FactoryTest {
    public static void main(String[] args) {
        //没有工厂模式
        BYD byd = new BYD();
        LINK link = new LINK();
        byd.run();
        link.run();

        //简单工厂模式
        BYD b = CarFactory.getBYD();
        LINK l = CarFactory.getLINK();
        b.run();
        l.run();
        Car by = CarFactory.getCar(0);

        //工厂方法
        BYD bbb = new BYDFactory().getCar();
        LINK lll = new LINKFactory().getCar();


    }
}

interface  Car {
    void run();
}

class BYD implements  Car{

    @Override
    public void run() {

    }
}

class LINK implements Car{

    @Override
    public void run() {

    }
}

//简单工厂模式
class CarFactory {
    public static BYD getBYD() {
        //方式一
        return new BYD();
    }

    public static LINK getLINK() {
        return new LINK();
    }
    //方式二
    public static Car getCar(int type){
        if (type ==0){
            return new LINK();
        }
        if (type ==1){
            return  new BYD();
        }
        return null;
    }
}

interface Factory {
    Car getCar();
}

class BYDFactory implements  Factory{

    @Override
    public BYD getCar() {
        return new BYD();
    }
}


class LINKFactory implements  Factory{

    @Override
    public LINK getCar() {
        return new LINK();
    }
}
