package com.ccjjltx.example1;

/**
 * synchronized
 * 线程的互斥问题
 *
 * @author ccj
 * @version 1.0
 * @since 1.8
 */
public class ThreadSynchronized2 {

    public static void main(String[] args) {
        Outputer outputer = new ThreadSynchronized2.Outputer();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output1("aaaaa");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outputer.output3("cccc");
            }
        }).start();
    }

    static class Outputer {
        public void output1(String name) {
            int len = name.length();
            synchronized (Outputer.class) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        public synchronized void output2(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }

        public static synchronized void output3(String name) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
