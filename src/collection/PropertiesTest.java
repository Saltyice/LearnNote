package collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 *
 *
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        //用properties读取配置
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("test.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
        //获取配置中的属性 string value都是String类型
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("set")    );

    }
}
