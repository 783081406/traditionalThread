package com.ccjjltx.ThreadShareVariable;

import java.util.Random;

/**
 * 线程范围内共享变量2
 * 一个ThreadLocalhost代表一个变量，故其中里面只能放在一个数据
 * 如果有多个变量定义一个对象来存储
 *
 * @author ccj
 * @version 1.0
 * @since 1.8
 */
public class ThreadLocal1 {

    static ThreadLocal<Integer> x = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName()
                        + " has put data :" + data);
                x.set(data);
                new A().get();
                new B().get();
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName()
                    + " get data :" + x.get());
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName()
                    + " get data :" + x.get());
        }
    }
}
