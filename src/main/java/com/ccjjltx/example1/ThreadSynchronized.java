package com.ccjjltx.example1;

/**
 * synchronized
 *
 * @author ccj
 * @version 1.0
 * @since 1.8
 */
public class ThreadSynchronized {

    public static void main(String[] args) {
        Outputer outputer = new ThreadSynchronized().new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("ccj");
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
                    outputer.output("jltx");
                }
            }
        }).start();
    }

    class Outputer {
        public void output(String name) {
            int len = name.length();
            synchronized (this) {
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
    }
}
