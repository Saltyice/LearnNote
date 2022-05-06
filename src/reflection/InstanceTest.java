package reflection;

import object.PersonTest;

import java.util.Random;

public class InstanceTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<PersonTest> clazz = PersonTest.class;
        //调用的是类对应的空参的构造器，如果没有空参构造器会报错
        //而且构造器要是默认权限及以上的,private的会报错
        PersonTest obj =  clazz.newInstance();
    }

    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int mode = new Random().nextInt(3);
        String cla = "";
        switch (mode){
            case 0:
                cla="String";
            case 1:
                cla = "Integer";
            case 2:
                cla = "Double";
            case 3:
                cla = "Float";
            default:
                cla = "Long";
        }
        getInstance(cla);
    }

    public Object getInstance(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class clazz = Class.forName(className);
        Object o = clazz.newInstance();
        return o;
    }
}
