package timeapi;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 *
 *
 *
 *
 */
public class LocalDateTimeTest {
    @Test
    public void test(){
        LocalDate date = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime now = LocalDateTime.of(2020,11,11,0,0);
        System.out.println(now);

        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());

        LocalDateTime dateTime = now.withHour(3);
        System.out.println(dateTime.toString());
        System.out.println(dateTime.plusWeeks(11));
    }


    /**
     *
     * instant 瞬时
     */
    @Test
    public void test2() {
        //本初子午线时间
        Instant instant = Instant.now();
        //时区不同会相差8小时
        System.out.println(instant);
        //添加偏移量
        instant.atOffset(ZoneOffset.ofHours(8));
        //获取对应的毫秒数 从1970年1月1日开始
        System.out.println(instant.toEpochMilli());

        Instant instant1= Instant.ofEpochMilli(1650595259247L);
    }


    /**
     * DateTimeFormatter 格式化或解析日期 时间
     */
     @Test
     public void test3(){
         //预定义方式的日期格式化
         DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
         String str =formatter.format(LocalDateTime.now());
         System.out.println(str);
         System.out.println(LocalDateTime.now());
         //解析
         formatter.parse(str);


         //本地化相关的格式
         DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
         String str1 = formatter1.format(LocalDateTime.now());
         System.out.println(str1);
         System.out.println(formatter1.parse(str1));

         //自定义格式
         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd hh:mm:ss");
         String str4 = dateTimeFormatter.format(LocalDateTime.now());
         System.out.println(str4);

         TemporalAccessor aa =dateTimeFormatter.parse("20220412");

     }
}
