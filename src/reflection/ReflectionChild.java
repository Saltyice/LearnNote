package reflection;

import annotation.MyAnnotation;

import java.io.IOException;

@MyAnnotation
public class ReflectionChild extends ReflectionDemo<String> implements  Comparable<String>,ReflectionInterface  {
    private String demo;
    int id;
    public int anInt;

    public ReflectionChild() {

    }

    public ReflectionChild(int id) {
        this.id = id;
    }

    public ReflectionChild(String demo, int id, int anInt) {
        this.demo = demo;
        this.id = id;
        this.anInt = anInt;
    }

    @MyAnnotation(value="test")
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() throws ArrayIndexOutOfBoundsException {

    }

    private static void test() {

    }
}
