package jdk.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author tengjinbao
 * <p>
 * 时间api用法
 * 包括LocalDate LocalTime LocalDateTime Instant 以及操作时间、格式化
 * <p>
 * 2019/3/15
 */
public class DateApi {

    public static void main(String[] args) {


        /**
         * 总结
         * Java8 java.time包下方法
         *
         * 方法名                  说明
         * now          静态工厂方法 创建当前实例
         * of           静态工厂方法 多用于创建实例
         * parse        静态工厂方法 设置默认格式
         * format       配合DateTimeFormatter用来格式化
         * is           检测某些东西是不是true
         * with         不可变的setter等价物
         * plus         为对象添加一些量
         * minus        为对象减少一些量
         * to           转换到另一个类型
         * at           把这个对象和另一个对象组合起来
         *
         */

        //LocalDate LocalTime LocalDateTime 皆是不可变

        /**
         * 创建实例 start
         */
        //ZoneId来设置时区
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        //now()获取当前时间实例 now()方法还能来接收时区
        LocalDate localDate = LocalDate.now(zoneId);
        LocalTime localTime = LocalTime.now(zoneId);
        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
        //Instant 是Unix时间戳
        Instant instant = Instant.now();

        //LocalDate of()是工厂方法来指定年月周日
        localDate = LocalDate.of(2019, 3, 15);
        //ofYearDay() 是工厂方法 指定年份 后多少天
        localDate = LocalDate.ofYearDay(2019, 74);
        //ofYearDay() 指定离1970 0101 差距多少天
        localDate = LocalDate.ofEpochDay(17970);
        //LocalTime of()是工厂方法来指定时分秒
        localTime = LocalTime.of(10, 22, 33);
        //LocalDateTime of() 工厂方法
        localDateTime = LocalDateTime.of(localDate, localTime);

        //LocalDate 默认格式 yyyy-MM-dd
        System.out.println("LocalDate 默认格式 yyyy-MM-dd ↓\r\n" + localDate);
        //LocalTime 默认格式 hh:mm:ss.zzz
        System.out.println("LocalTime 默认格式 hh:mm:ss.zzz ↓\r\n" + localTime);
        //LocalDateTime 默认格式 yyyy-MM-dd-HH:mm:ss.zzz
        System.out.println("LocalDateTime 默认格式 yyyy-MM-dd-HH:mm:ss.zzz ↓\r\n" + localDateTime);
        /**
         * 创建实例 end
         */


        /**
         * 操作实例 start
         */
        //DateTimeFormatter用来格式化 LocalDate LocalTime LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("DateTimeFormatter用来格式化 ↓\r\n" + localDate.format(formatter));

        //minusYears() 减年 minusMonths() 减月 minusWeeks() 减周 minusDays() 减天
        //负数即增
        localDate = localDate.minusYears(1).minusMonths(1).minusWeeks(1).minusDays(1);
        System.out.println("minusYears() 减年 minusMonths() 减月 minusWeeks() 减周 minusDays() 减天 负数即增 ↓\r\n" + localDate.format(formatter));

        //plusYears() 加年 plusMonths() 加月 plusWeeks() 加周 plusDays() 加天
        //负数即减
        localDate = localDate.plusYears(1).plusMonths(1).plusWeeks(1).plusDays(1);
        System.out.println("plusYears() 加年 plusMonths() 加月 plusWeeks() 加周 plusDays() 加天 负数即减 ↓\r\n" + localDate.format(formatter));

        //使用TemporalAdjusters来获取某些特定的值
        //如当年首尾天 当月首尾天 当周首尾天
        localDate = localDate.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("使用TemporalAdjusters来获取次年首日 ↓\r\n" + localDate.format(formatter));

        //Instant获得精确秒的时间戳
        System.out.println("Instant获得精确秒的时间戳 ↓\r\n" + instant.getEpochSecond());
        //Instant获得精确毫秒的时间戳
        System.out.println("Instant获得精确毫秒的时间戳 ↓\r\n" + instant.toEpochMilli());

        /**
         * 操作实例 end
         */

        /**
         * 和以前的Date api 转换 start
         */

        //旧 转 新
        //Date 转 instant  date.toInstant()
        Instant timestamp = new Date().toInstant();
        LocalDateTime dateTime = LocalDateTime.ofInstant(timestamp, zoneId);
        System.out.println("Date 转 instant  date.toInstant() ↓\r\n" + dateTime);

        //Calendar 转 instant  calendar.toInstant()
        Instant time = Calendar.getInstance().toInstant();
        System.out.println("Calendar 转 instant  calendar.toInstant() ↓\r\n" + time);

        //TimeZone 转 ZoneId timeZone.toZoneId()
        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        System.out.println("TimeZone 转 ZoneId timeZone.toZoneId() ↓\r\n" + defaultZone);

        //新 转 旧
        //Instant 转 Date Date.from(Instant.now())
        Date d = Date.from(Instant.now());
        System.out.println("instant 转 Date Date.from(Instant.now()) ↓\r\n" + d);

        //ZoneId 转 TimeZone
        TimeZone timeZone = TimeZone.getTimeZone(defaultZone);

        /**
         * 和以前的Date api 转换 end
         */
    }
}
