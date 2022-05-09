package jdk8;

import collection.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructRefTest {
    public void test(){
        Supplier<Employee> supplier =()->new Employee();

        Supplier<Employee> supplier1 =Employee::new;
        Employee employee = supplier1.get();
        System.out.println(employee);
    }


    public void test1(){
        Function<Integer,Employee> supplier =(id)->new Employee(id);

        Function<Integer,Employee> supplier1 =Employee::new;
        Employee employee = supplier1.apply(12);
        System.out.println(employee);
    }

    public void test2(){
        BiFunction<Integer,String,Employee> biFunction = (in,str)-> new Employee(str,in);

        BiFunction<String,Integer,Employee> biFunction1 = Employee::new;
        Employee employee = biFunction1.apply("123",1);
        System.out.println(employee);
    }
}
