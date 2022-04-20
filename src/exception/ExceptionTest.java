package exception;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 *  java异常体系结构
 *    Throwable
 *     |-- java.lang.Error
 *     |-- java.lang.Exception
 *        |-----编译时异常(check)
 *                 | ------IOException
 *                 | ------FileNotFoundException
 *                 | ------ClassNotFoundException
 *        |----运行时异常(unchecked)
 *                 |-----NullPointerException
 *                 |-----ArrayIndexOutOfBoundException
 *                 |-----ClassCastException
 *                 |-----NumberFormatException
 *                  .....
 *
 *
 *
 *  异常的处理：抓抛模型
 *   过程一：抛 程序在正常执行的过程中，一旦出现异常就会在异常代码处生成一个对应异常类的对象
 *      并将此对象抛出。
 *      一旦抛出对象以后，其后的代码就不再执行。
 *
 *   过程二：抓 可以理解为异常的处理方式
 *      try-catch-finally
 *      throws
 *
 *   try-catch-finally
 *
 *
 *   catch的异常如果没有子父类关系，则谁先写谁后写无所谓。如果存在子父类关系，则应该把子类异常写在前面，父类写在后面
 *   常用的异常处理方式： getMessage() printStackTrace()
 *
 *   try-catch结构中定义的变量只能在该结构中调用，外部无法使用
 *
 *   finally时可选的
 *   finally中声明的是一定会被执行的代码，即使catch中又出现异常了，或者存在return语言也会执行finally中的代码
 *
 *   数据库连接 输入输出流 socket等是JVM无法自动关闭回收的，所以我们要手动关闭他们，如果此时程序异常就会无法关闭。
 *   故需要将关闭语句写在finally中确保关闭成功。
 *
 *
 *
 *   throw+ 异常类型
 *   声明在方法后 指名方法执行时会抛出的异常
 *   异常并没有被解决只是将错误抛出给上层
 *   遇到异常时就生成异常对象
 *
 *
 *   回顾：
 *     子类重写抛出的异常类型不能大于父类抛出的异常类星
 *     如果父类方法没有抛出异常，子类处理异常就不能抛出异常，要使用try-catch处理
 *
 *
 *
 *   手动抛出异常
 *
 *
 */
public class ExceptionTest {




    public void throwTest(){
        //手动抛出异常
        throw new RuntimeException("");
    }


    //finally关键字使用
    @Test
    public void finallyWordTest() {
        try{
            int a = 10;
            int b = 0;
            System.out.println(a /b );
        }catch(ArithmeticException e){
            int[] arr = new int[4];
            System.out.println(arr[5]);
        } finally {
            System.out.println("aaa");
        }
    }



    @Test
    public void resolve(){
        Object date = new Date();
        try{
            String a = (String) date;
            //一旦try中的异常对象匹配到某一个catch时，就进入catch中进行异常的处理
            //catch执行完毕就会跳出当前的try-catch结构，有finally就再执行finally。再继续执行后续代码
        }catch (ClassCastException e){
            System.out.println("pao chu exception ");
            e.getMessage();
            e.printStackTrace();
        } catch (ClassCircularityError e){
            e.getLocalizedMessage();
        }finally {
            System.out.println();
        }
    }


    @Test
    public void nullPointer(){
        int[] a = null;
        System.out.println(a[1]);
    }
    @Test
    public void arrIndexOutBound(){
        int[] a =new int[3];
        System.out.println(a[3]);
    }

    @Test
    public void classCast() {
        Object date = new Date();
        String a = (String) date;
    }

    @Test
    public void numberFormat() {
        Integer a = Integer.parseInt("a");
    }
}
