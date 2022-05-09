package jdk8;

import collection.Employee;
import collection.MyDate;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * 方法引用
 *  使用情境 当要传递给lambda体的操作，已经有实现的方法了，可以使用方法引用
 *
 *  方法引用 本质上就是lambda的表达式 而lambda表达式作为函数式接口的实例
 *  所以方法引用也是函数式接口的实例
 *
 *  使用格式  类或对象 :: 方法名
 *
 *  对象 :: 非静态方法
 *  类 :: 静态方法
 *  类  :: 非静态方法
 *
 *
 *  方法引用的使用要求
 *    要求接口中的抽象方法的形参列表和返回值与方法引用的方法的形参列表和返回值类型相同
 */
public class MethodRef {
    public void test(){
        Consumer consumer = (in)-> System.out.println(in);
        consumer.accept(1);

        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps :: println;
        consumer1.accept("asfd");
    }

    public void test1() {
        Employee employee = new Employee("123",21,new MyDate());
        System.out.println(employee.getName());
        Supplier<String> supplier = employee :: getName;
        //实际调用的就是getName方法
        System.out.println(supplier.get());
    }

    public void test2() {
        Comparator<Integer> comparator = (t1,t2) -> Integer.compare(t1,t2);
        comparator.compare(1,2);

        Comparator<Integer> comparator1 =Integer::compare;
        comparator1.compare(3,4);
    }

    public void test3(){
        Function<Double,Long> function = (d) ->{return Math.round(d);};

        Function<Double,Long> func = Math :: round;
        func.apply(1.2333);
    }

    @Test
    public void test4(){
      Comparator<String> comparator = (s1,s2)-> s1.compareTo(s2);

      Comparator<String> comparator1 = String ::compareTo;
      comparator1.compare("String",new String("String"));
    }

    public void test5(){
        BiPredicate<String,String> predicate =(s1,s2)->s1.equals(s2);

        BiPredicate<String,String> predicate1 = String :: equals;
        predicate1.test("","");
    }
    @Test
    public void test6(){
        Employee employee = new Employee();
        Function<Employee,String> function = e -> e.getName();
        Function<Employee,String> function1= Employee::getName;
        function1.apply(employee);
    }
}
