package com.atguigu.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @auther zzyy
 * @create 2018-10-16 17:30
 */
public class DateMethod8{

    //把毫秒数转换为标准日期时间字符串
    public String formatMilliSecond(long milliSeconds) {
        ZoneId z=ZoneId.systemDefault();
        Instant instant = Instant.now();
        LocalDateTime datetime = LocalDateTime.ofEpochSecond(milliSeconds/1000, 0,z.getRules().getOffset(instant));
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return datetime.format(formatter);
    }

    //获取当前日期时间字符串
    public String getNowDateAndTimeString() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    //获取当前日期字符串
    public String getNowDateString() {
        LocalDate today=LocalDate.now();
        return today.toString();
    }

    //获取当前时间字符串
    public String getNowTimeString() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

    //获取某年某月第一天
    public String getYearMonthFirstDayString(int year, int month) throws Exception {
        if(month<1||month>12){
            throw new Exception("invalid parameters");
        }
        Integer iyear = Integer.valueOf(year);
        Integer imonth = Integer.valueOf(month);
        if(month<10){
            return iyear.toString()+"-0"+imonth.toString()+"-01 00:00:00";
        }else{
            return iyear.toString()+"-"+imonth.toString()+"-01 00:00:00";
        }
    }

    //获取某年某月最后一天
    public String getYearMonthLastDayString(int year, int month) throws Exception {
        if(month<1||month>12){
            throw new Exception("invalid parameters");
        }
        LocalDate date = LocalDate.of(year,month,1);
        Integer lastday=date.getMonth().length(date.isLeapYear());
        Integer iyear = Integer.valueOf(year);
        Integer imonth = Integer.valueOf(month);
        if(month<10){
            return iyear.toString()+"-0"+imonth.toString()+"-"+lastday.toString()+" 23:59:59";
        }else{
            return iyear.toString()+"-"+imonth.toString()+"-"+lastday.toString()+" 23:59:59";
        }
    }

    //获取某年某月某日所在周的某一天
    public String getWeekDayString(int year, int month, int day, DayOfWeek dow) throws Exception{
        try{
            LocalDate date = LocalDate.of(year,month,day);
            LocalDate newDate = date.with(TemporalAdjusters.nextOrSame(dow));
            return newDate.toString();
        }catch(Exception e){
            throw new Exception("invalid parameters");
        }
    }
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextMonth = now.plusMonths(1);  //向后延续一个月
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(nextMonth.format(formatter));
        int compareResult = nextMonth.compareTo(now); //比较日期和时间
        if(compareResult>0){
            System.out.println("晚于当前");
        }else if(compareResult==0){
            System.out.println("相同");
        }else{
            System.out.println("早于当前");
        };
        LocalDate temp = LocalDate.now();
        System.out.println(temp.with(TemporalAdjusters.lastDayOfMonth()));//月末一天的另一种方法
        Duration dtime = Duration.between(now, nextMonth);  //计算时间间隔
        long seconds = dtime.getSeconds();//秒表示
        long millis = dtime.toMillis();//毫秒表示
        System.out.println(seconds);
        System.out.println(millis);
        try{
            LocalDate newDate = LocalDate.of(2005,2,28);  //验证日期有效性
            LocalDateTime newTime = LocalDateTime.of(newDate, LocalTime.now());
            System.out.println("日期有效");
            System.out.println(newTime.format(formatter));
        }catch(Exception e){
            System.out.println("日期无效");
        }
    }
}
