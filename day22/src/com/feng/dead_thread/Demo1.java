package com.feng.dead_thread;

/**
 * @ClassName Demo1
 * @Description com.feng.dead_thread.Demo1
 * @Author AsuraTu
 * @Date 2023/5/22 11:01
 * @Version 1.0.0
 */
public class Demo1 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        DeadLock deadLock1 = new DeadLock(o1, o2, true);
        DeadLock deadLock2 = new DeadLock(o1, o2, false);

        Thread thread1 = new Thread(deadLock1, "线程1");
        Thread thread2 = new Thread(deadLock2, "线程2");

        thread1.start();
        thread2.start();
    }
}
