package jdk8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 函数式接口
 *   消费型接口 Consumer
 *   供给型接口  Supplier
 *   函数型接口  Function
 *   断定型接口  Predicate
 *
 *
 */
public class Functional {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)-> System.out.println(str);

        Supplier<String> supplier =() -> {return "";};


    }
}
