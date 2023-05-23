package com.feng.wait;

/**
 * @ClassName MyThread
 * @Description com.feng.wait.MyThread
 * @Author AsuraTu
 * @Date 2023/5/22 16:08
 * @Version 1.0.0
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            // sleep 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ": " + i);
        }
    }
}
