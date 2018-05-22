package com.ccjjltx.example1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimeTest {

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        }, 10000,3000);//第一是开始时间，第二个是间隔时间
        while (true) {
            System.out.println(new SimpleDateFormat("ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
