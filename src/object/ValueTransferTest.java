package object;

/**
 *
 * 关于变量的赋值
 *  如果变量是基本数据类型，此时赋值的是变量所保存的数据值。
 *  如果变量是引用数据类型，此时赋值的是变量所保存的地址值。
 */
public class ValueTransferTest {
    public static void main(String[] args) {
        //基本数据类型的情况
        int m=10;
        int n=m;
        System.out.println(m+" "+n); // 10  10

        n=20;
        System.out.println(m+" "+n);//10 20


        ObjectO  o = new ObjectO();
        o.id = 1001;
        ObjectO oo = o;
        System.out.println(o.id+" " +oo.id);//1001 1001
        oo.id=1002;
        System.out.println(o.id+" " +oo.id); //1002 1002


    }
}


class ObjectO{
    int id;

}