package exception;

/**
 *  自定义异常
 *  1.构造器
 *  2. 继承exception相关类
 *
 *
 *
 *
 */
public class MyException extends RuntimeException{
    //类唯一标识
    static final long serialVersionUID = -7034897190745766939L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
