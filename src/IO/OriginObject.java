package IO;

import java.io.Serializable;
//实现Serializable接口
//自定义serialVersionUID
//保证类的内部对象也是可以序列化的
public class OriginObject implements Serializable {
    static final long serialVersionUID = 12312342L;
    public String name;
    public int number;
    //添加transient修饰的成员不会被实例化
    transient int one;

    @Override
    public String toString() {
        return "OriginObject{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
