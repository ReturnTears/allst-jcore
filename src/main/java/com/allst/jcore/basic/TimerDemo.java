package com.allst.jcore.basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Java实现时钟定时器
 * 下面这个方式的定时器是有误差的
 * @author June 2019/03/02 下午 06:42
 * @version 1.0
 */
public class TimerDemo {

    private static int time;
    private static boolean isRecv;

    public static void main(String[] args) {
        final Timer timer = new Timer();
        final Timer timer2 = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!isRecv){
                    time++;
                    TimerDemo.currDate();
                    System.out.println(time);
                }else{
                    timer.cancel();
                    System.out.println("timer canceled");
                }
            }
        }, 0, 1000);

        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                isRecv = true;
                System.out.println("set isRecv");
                timer2.cancel();
                System.out.println("timer2 canceled");
            }
        }, 3000);
    }

    private static void currDate(){
        Date date = new Date();
        String reg = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        System.out.println("当前日期是:"+sdf.format(date));
    }
}
