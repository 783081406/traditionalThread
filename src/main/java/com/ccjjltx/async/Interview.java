package com.ccjjltx.async;

/**
 * 子线程10次，再主线程10次，再子线程10... ...如此循环50次
 * 经验：要用到共同数据（包括同步锁）或共同算法的若干个方法应该归在同一个类身上，这种设计正好体现了高内聚和程序的健壮性
 * 锁是上在代表是要操作的资源的类的内部方法中，而不是线程代码中
 *
 * @author ccj
 * @version 1.0
 * @since 1.8
 */
public class Interview {
    public static void main(String[] args) {

        Business business = new Interview().new Business();

        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                business.sub(i);
            }
        }).start();

        //主线程
        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

    class Business {

        private boolean bshould = true;

        public synchronized void sub(int i) {
            if (!bshould) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread sequece of " + j + " ,loop of" + i);
            }
            bshould = false;
            this.notify();
        }

        public synchronized void main(int i) {
            if (bshould) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("main thread sequece of " + j + " ,loop of" + i);
            }
            bshould = true;
            this.notify();
        }
    }
}
