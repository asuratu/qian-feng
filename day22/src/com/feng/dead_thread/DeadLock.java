package com.feng.dead_thread;

/**
 * @ClassName DeadLock
 * @Description com.feng.dead_thread.DeadLock
 * @Author AsuraTu
 * @Date 2023/5/22 11:02
 * @Version 1.0.0
 */
public class DeadLock implements Runnable {
    private final Object o1; // 锁住的对象
    private final boolean flag;
    private final Object o2; // 锁住的对象

    public DeadLock(Object o1, Object o2, boolean flag) {
        this.o1 = o1;
        this.o2 = o2;
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println("if o1");

                // 等待 1 秒, 让另一个线程先拿到 o2
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("等待锁2的释放");

                // 会造成死锁
                synchronized (o2) {
                    System.out.println("if o2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println("else o2");

                // 等待 1 秒, 让另一个线程先拿到 o1
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("等待锁1的释放");

                // 会造成死锁
                synchronized (o1) {
                    System.out.println("else o1");
                }
            }
        }

    }
}
