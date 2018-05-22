package com.ccjjltx.async;

/**
 * synchronized
 *
 * @author ccj
 * @version 1.0
 * @since 1.8
 */
public class ThreadSynchronized1 {

    public static void main(String[] args) {
        Outputer outputer = new ThreadSynchronized1().new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output1("cccc");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output2("jjjj");
                }
            }
        }).start();
    }

    class Outputer {
        public void output1(String name) {
            int len = name.length();
            synchronized (this) {
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
    }
}
