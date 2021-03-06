package designpattem;

/**
 *
 *   模板方法设计模式
 *
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }

}
abstract class Template {
    public void spendTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public abstract void code() ;
}
class SubTemplate extends Template{

    @Override
    public void code() {
        for (int i=1;i<1000;i++) {
            boolean flag =true;
            for (int j=2;j<Math.sqrt(i);j++){
                if (i % j ==0) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }
}