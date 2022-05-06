package reflection;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //当前类的类加载器   systemLoader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //再上一层的类加载器  拓展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        // 再上一层的类加载器  引导类加载器
        //引导类加载器主要负责加载java的核心类库,无法加载自定义类，会获取不到
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        //String是核心库的 对应加载器是获取不到的
        ClassLoader classLoader3 =String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();
//        try {
//            //此时的文件默认在当前的module下
//            properties.load(new FileInputStream("test.properties"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //这种方式默认在src下
        InputStream inputStream = classLoader.getResourceAsStream("test.properties");
        properties.load(inputStream);
        String a = properties.getProperty("name");
    }
}
