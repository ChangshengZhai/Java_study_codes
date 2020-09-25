package com.zf.s3;

import java.io.*;

public class TextControl {
    static int year, monthDay, weekDay;     //定义静态变量，以便其他类调用
    public static boolean isLeapYear(int y){        //判断是否为闰年
        return ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0));
    }
    public static int firstDay(int y){      //计算该年第一天是星期几
        long n = y * 365;
        for (int i = 1; i < y; i++)
            if (isLeapYear(i))
                n += 1;
        return (int) n % 7;
    }
    public static  void printWeek(){        //打印表头
        System.out.println("=============================================");
        System.out.println("日     一      二     三     四      五     六  ");
    }
    public static int getMonthDay(int m){       //获取每个月的天数
        switch (m){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year))
                    return 29;
                else
                    return 28;
            default:
                return 0;
        }
    }
    public static void printMonth(){        //分别按不同条件逐月打印
        for (int m = 1; m <= 12; m++) {
            System.out.println(m + "月");
            printWeek();
            for (int j = 1; j <= weekDay; j++) {      //按每个月第一天是星期几打印相应的空格
                System.out.print("       ");
            }
            int monthDay = getMonthDay(m);
            for (int d = 1; d <= monthDay; d++){
                if (d < 10)     //以下4行对输出格式化
                    System.out.print(d + "      ");
                else
                    System.out.print(d + "     ");
                weekDay = (weekDay + 1) % 7;        //每打印一天，反映第二天是星期几
                if (weekDay == 0)       //如果第二天是星期天，便换行
                    System.out.println();
            }
            System.out.println("\n");
        }
    }
    public static void main(String [] agrs) throws IOException{
        System.out.print("请输入一个年份：");
        InputStreamReader ir;       //以下接受从控制台的输入
        BufferedReader in;
        ir = new InputStreamReader(System.in);
        in = new BufferedReader(ir);
        String s = in.readLine();
        year = Integer.parseInt(s);
        weekDay = firstDay(year);
        System.out.println("\n                 "+ year + "年   ");
        printMonth();
    }
}
