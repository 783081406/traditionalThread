package com.ccjjltx.example1;

public class TraditionalThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    System.out.println(i + Thread.currentThread().getName());
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i < 20; i++) {
                    System.out.println(i + Thread.currentThread().getName());
                }
            }
        });
        thread2.start();
    }
}
