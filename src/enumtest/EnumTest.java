package enumtest;

/**
 *
 * 枚举类
 * 但类的对象是有限个的，确定的，我们×此类为枚举类
 * 当需要定义一组变量时，强烈建议使用枚举类
 * 如果枚举类中只有一个对象，则可以作为单例模式的实现
 *
 *  5.0之前自定义枚举类
 *  5.0新增Enum
 *
 *
 *  enum常用方法 toString values  valueOf
 *
 *  enum继承接口接口
 *   1，实现接口，重写接口方法
 *   2.枚举类中的对象，每个对象分别重写接口方法
 */
public class EnumTest {
    public static void main(String[] args) {
        Season.SPRING.getSeasonDesc();
        Season.AUTUMN.getSeasonDesc();
        Season spring = Season.SPRING;
        System.out.println(spring.toString());

        //Enum类的常用方法
        SeasonEnum[] enums= SeasonEnum.values();
        for (int i = 0; i < enums.length; i++) {
            System.out.println(enums[i]);
        }

        SeasonEnum winter=SeasonEnum.valueOf("WINTER");
        //不存在对应的对象会报错
        SeasonEnum winter1=SeasonEnum.valueOf("WINTER1");
        Thread.State[] values = Thread.State.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }

}

/**
 * 自定义枚举类
 *
 *
 */
class Season{
    // 用private final修饰成员变量
    private final String seasonName;
    private final String seasonDesc;

    //私有类构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc=seasonDesc;
        this.seasonName = seasonName;
    }
    //构造当前枚举类的多个对象：public static final
    public static final Season SPRING = new Season("春","1");
    public static final Season SUMMER = new Season("夏","2");
    public static final Season AUTUMN = new Season("秋","3");
    public static final Season WINTER = new Season("冬","4");

    //获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

/**
 *
 * 枚举类
 *  默认继承于java.lang.enum类
 *   可以重写toString方法，但是重写了就不再继承Enum类
 *   可以继承接口
 *
 */
enum SeasonEnum implements Info {
    //提供当前枚举类的对象，多个对象之间用,隔开，用；结束对象

    //对象重写接口的方法
    SPRING("1","1"){
        @Override
        public void show() {

        }
    },
    SUMMER("1","1"){
        @Override
        public void show() {

        }
    },
    AUTUMN("1","1"){
        @Override
        public void show() {

        }
    },
    WINTER("1","1"){
        @Override
        public void show() {

        }
    };
    //声明对象属性
    private final String seasonName;
    private final String seasonDesc;

    private SeasonEnum(String seasonName,String seasonDesc){
        this.seasonDesc=seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


//    public void show() {
//        System.out.println("test");
//    }
}


interface Info {
    void show();
}