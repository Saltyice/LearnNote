package object;

/**
 *
 * 方法形参的传递机制：值传递
 *  形参：方法定义时 声明的小括号内的参数
 *  实参：方法调用时，实际传递给形参的值
 *
 *
 *  值传递机制：
 *  如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的值
 *  如果参数是引用类型,此时实参赋给形参的是实参存储数据的地址值
 *
 */
public class ValueTransferTest1 {
    public static void main(String[] args) {
        int m=10;
        int n=20;
        System.out.println(m+" "+n); // 10  20
        swap(m,n);
        System.out.println(m+" "+n); // 10  20

        int[] arr = new int[]{1,2};
        swap(arr[0],arr[1]);
        System.out.println(arr[0]+" "+arr[1]);//1  2

        Data data = new Data();
        data.params1=1;
        data.params2=2;
        swap(data.params1,data.params2);
        swap(data);

        System.out.println(data.params1+" "+data.params2);
    }

    /**
     * 基本数据类型实际上是把值传递到方法中
     * @param m
     * @param n
     */
    public static void swap(int m,int n){
        int temp =m;
        m=n;
        n=temp;
        System.out.println(m+" "+n);
    }

    public static void swap(Data data){
        int temp = data.params1;
        data.params1=data.params2;
        data.params2 = temp;
    }
}


class Data{
    int params1;
    int params2;
}