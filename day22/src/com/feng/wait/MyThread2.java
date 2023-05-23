package com.feng.wait;

/**
 * @ClassName MyThread2
 * @Description com.feng.wait.MyThread2
 * @Author AsuraTu
 * @Date 2023/5/22 16:10
 * @Version 1.0.0
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        for (int i = 0; i < 100; i++) {
            System.out.println(thread.getName() + ": " + i);
        }
    }
}
