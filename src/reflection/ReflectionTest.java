package reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ReflectionTest {
    public static void main(String[] args) {
        Class clazz = ReflectionChild.class;
        //getFields 获取当前运行时类及其父类种声明为public的属性
        Field[] fields = clazz.getFields();
        for (Field field: fields){
            //System.out.println(field);
        }

        //获取运行时类的所有属性包括private的，但是不包含父类的属性
        Field[] fields1 = clazz.getDeclaredFields();
        for(Field field:fields1) {
            System.out.println(field);
            //获取权限修饰符 输出1是public 0是default 2是private
            System.out.println(field.getModifiers());
            System.out.println(Modifier.toString(field.getModifiers()));
            //获取数据类型
            Class type = field.getType();
            System.out.println(type.getName());
            //变量名
            System.out.println(field.getName());
        }
    }
    @Test
    public void test(){
        Class clazz = ReflectionDemo.class;

        // 获取权限为public的方法包括父类中的
        Method[] methods= clazz.getMethods();
        for(Method method:methods){
            System.out.println(method);
        }

        //获取当前运行时类中的所有方法 包括私有的
        Method[] methods1 = clazz.getDeclaredMethods();
        for(Method method:methods1) {
            System.out.println(method);
        }
    }

    @Test
    public void test2() {
        Class clazz = ReflectionChild.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods) {
            //获取注解
            Annotation[] annotations= method.getAnnotations();
            for(Annotation annotation:annotations) {
                System.out.println(annotation);
            }
            //获取方法的权限修饰符
            System.out.print(Modifier.toString(method.getModifiers())+"\t");
            //获取方法的返回值类型
            System.out.print(method.getReturnType()+"\t");
            //获取方法名
            System.out.println(method.getName()+"\t");
            //获取方法的形参列表
            Class[] parameterTypes = method.getParameterTypes();
            //打印形参列表
            if(parameterTypes!=null&& parameterTypes.length!=0){
                for(int i=0;i<parameterTypes.length;i++){
                    if(i==parameterTypes.length-1){
                        System.out.println(parameterTypes[i].getName()+ "args_");
                        break;
                    }
                    System.out.println(parameterTypes[i].getName()+ "args_" +i+",");
                }
            }
            //获取方法抛出的异常
            Class[] exceptions = method.getExceptionTypes();
            if(exceptions!=null&& exceptions.length!=0){
                System.out.println("throws  ");
                for (int i = 0; i < exceptions.length; i++) {
                    if(i ==exceptions.length-1){
                        System.out.println(exceptions[i].getName());
                        break;
                    }
                    System.out.println(exceptions[i].getName()+ ",");
                }
            }
            System.out.println();
        }
    }
    @Test
    public void test3() throws NoSuchMethodException {
        Class clazz = ReflectionChild.class;
        Constructor[] constructor= clazz.getConstructors();
        //获取权限为public的构造器 不包括父类的构造器
        for (Constructor constructor1:constructor){
            System.out.println(constructor1);
        }
        //获取当前类的构造器
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor1:constructors){
            System.out.println(constructor1);
        }

        //获取指定参数的构造器
        Constructor constructor1 = clazz.getConstructor(int.class);
    }
    @Test
    public void test4() {
        Class clazz = ReflectionChild.class;
        //获取运行时类的父类
        Class superClass =  clazz.getSuperclass();
        System.out.println(superClass.getName());
        //获取带泛型的父类
        Type genericSuperClass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperClass;
        //获取泛型的类型
        Type[] types= parameterizedType.getActualTypeArguments();
        System.out.println(types[0].getTypeName());
    }
    @Test
    public void test5() {
        Class clazz= ReflectionChild.class;
        //获取类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class in:interfaces){
            System.out.println(in);
        }
        //带泛型的类的注解
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        ParameterizedType[] parameterizedTypes = (ParameterizedType[]) genericInterfaces;
        //父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
    }
    @Test
    public void test6(){
        //获取类所在的包
        Class clazz = ReflectionChild.class;
        Package aPackage = clazz.getPackage();

    }

    @Test
    public void test7(){
        //获取类的注解
        Class clazz = ReflectionChild.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation:annotations){
            System.out.println(annotation);
        }
    }

    @Test
    public void test8() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz =ReflectionChild.class;
        //只能获取public的属性
        Field filed= clazz.getField("anInt");
        Object o = clazz.newInstance();
        ReflectionChild reflectionChild = (ReflectionChild) o;
        //修改属性值
        filed.set(reflectionChild,10);
        System.out.println(filed.get(reflectionChild));

        //实际常用的方式 获取运行时类的属性
        Field field = clazz.getDeclaredField("demo");
        //私有的属性要设置为true，不然修改不了属性值
        field.setAccessible(true);
        filed.set(reflectionChild,"SSS");
        field.get(reflectionChild);
    }
    @Test
    public void test9() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = ReflectionChild.class;
        ReflectionChild reflectionChild =(ReflectionChild) clazz.newInstance();
        //获取方法 如果该方法存在多个同名重写方法则应该指定形参列表
        Method compareTo = clazz.getMethod("compareTo", String.class);
        //同样需要设置为true 以防是私有方法
        compareTo.setAccessible(true);
        //调用方法 并接受返回值，如果美哟返回值则是空
        Object obj= compareTo.invoke(reflectionChild,"123");

        //调用静态方法
        Method test = clazz.getDeclaredMethod("test");
        test.setAccessible(true);
        //静态方法 就可以不用传入指定对象，无需指定哪个对象调用方法
        test.invoke(null);
    }
    @Test
    public void test10() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //调用构造器
        Class clazz = ReflectionChild.class     ;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }


}
