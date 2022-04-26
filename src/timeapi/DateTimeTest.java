package timeapi;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8之前的日期API
 *
 *
 *
 */
public class DateTimeTest {
    public static void main(String[] args) {
        //从1970年1月1日0点到现在的毫秒数
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    /**
     *
     * util.Date
     *
     * sql.date对应的是数据库中的date
     */
    @Test
    public void test() {
        //util.Date
        Date date1 =new Date();
        System.out.println(date1.toString());//显示年月日时分秒
        System.out.println(date1.getTime());//也是毫秒数
        Date date = new Date(2010,11,1);//指定年月日
        Date date2 = new Date(1650524745349L);//毫秒数构造

        new java.sql.Date(1999,1,1);//年月日
        Date date3 = new java.sql.Date(1650524745349L);
        //sql.date 和 util.date互转 赋值毫秒数就行
        Date date4 = new Date(date3.getTime());
    }

    /**
     *
     * SimpleDateFormat
     * 对日期Date类的格式化和解析
     * 两个操作
     *  1.格式化：将日期转为指定格式的字符串
     *    解析：将字符串转为日期
     */
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();//默认格式 2022/4/21 下午10:06
        //格式化
        String date = simpleDateFormat.format(new Date());
        //解析
        Date date1 = simpleDateFormat.parse(date);
        System.out.println(date);
        //指定时间格式
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    }

    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2022-04-11");
        java.sql.Date date1 = new java.sql.Date(date.getTime());
    }

    /**
     *
     * 日历类
     * Calendar
     */
     public void test3() {
         //实例化
         Calendar calendar = Calendar.getInstance();
         int days = calendar.get(Calendar.DAY_OF_MONTH);
         System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

         //设置日期
         calendar.set(Calendar.DATE,10);

         //加日期
         calendar.add(Calendar.DATE,1);
         //获取时间
         calendar.getTime();

         //设置时间
         calendar.setTime(new Date());

     }
}
