package jdk8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional为了防止空指针而出现
 * 常用方法 OfNullable
 *         OrElse
 *
 *
 */
public class OptionalTest {
    public static void main(String[] args) {
        //创建空的optional实例
        Optional optional = Optional.empty();
        Integer integer = 1;
        //创建一个实例 里面的value不能为空
        Optional.of(integer);
        //创建一个实例 里面的对象可以为空
        Optional.ofNullable(integer);
        Integer integer1=null;
        Optional.ofNullable(integer1);
        //会报错
        Optional.of(integer1);
    }

    @Test
    public void test() {
        var optional = Optional.empty();
        //判断value是否为空
        System.out.println(optional.isEmpty());;
        //判断value是否存在
        System.out.println(optional.isPresent());;
    }


    public Integer getInteger(Integer in){
        //这样写就是安全的不会报空指针
        Optional<Integer> optional= Optional.ofNullable(in);



        return optional.orElse(0);
    }
}
