package object;

/**
 *
 * 可变个数形参的方法
 * 1.jdk5.0新增的用法
 * 2.具体使用：
 *    可变形参的格式： 数据类型 ...变量名
 *    调用可变形参的方法时，传入的参数个数可以时 0个 1个 2个 3个
 *    可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
 *    可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载，换句话说，二者不能共存
 *    可变个数形参在方法的形参中，必须声明在末尾
 *    可变个数形参在方法的形参中,最多只能声明一个可变形参
 */
public class MethodArgsTest {


    public static void main(String[] args) {
        MethodArgsTest test = new MethodArgsTest();
        test.show("12","33","44","53","11","412","123");
    }

    public void show(int i){

    }


    public void show(String s){
        System.out.println("123");
    }


    //可变个数形参,相当于String数组String[] strings
    public void show(String ...strings){
        System.out.println(strings);//输出内存地址
        for(int j=0;j<strings.length;j++){
            System.out.println(strings[j]);//输出内存地址
        }
    }

    //跟可变形参会重复
//    public void show(String[] args){
//
//    }
}
