package annotation;

/**
 *
 * 注解annotation其实就是代码里的特殊标记。这些标记剋在编译，类加载，运行时被读取，并执行
 * 相应的处理。通过使用annotation，程序员可以在不改变原逻辑的情况下，在源文件嵌入一些补充信息。
 *
 *  javaSe中，注解的使用目的比较简单，例如标记过时功能，忽略警告等 。
 *
 *  框架 = 注解+反射机制+设计模式
 *
 *  注解实例
 *     生成doc文档的注解
 *     在编译时进行格式检查
 *     java内置注解 override  Deprecated  SuppressWarning
 *
 *     元注解  Target Retention Inherited Repeatable
 *
 *     如果注解有成员,在使用注解时，注解成员必须有值
 *
 *
 *
 */
public class TestClass {
    @MyAnnotation(value = "123")
    public static void main(String[] args) {

    }
}
