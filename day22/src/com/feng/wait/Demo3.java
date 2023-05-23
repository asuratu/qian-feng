package com.feng.wait;

/**
 * @ClassName Demo3
 * @Description com.feng.wait.Demo3
 * @Author AsuraTu
 * @Date 2023/5/22 16:07
 * @Version 1.0.0
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        // join() 方法: 等待该线程终止, 挂起线程
        // join(long millis): 等待该线程终止的时间最长为 millis 毫秒

        Thread thread1 = new Thread(new MyThread(), "线程1");
        Thread thread2 = new Thread(new MyThread2(), "线程2");

        thread1.start();
        thread1.join(); // 等待线程1终止
        thread2.start();
        thread2.join(); // 等待线程2终止

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程打印数字：" + i);
        }
    }
}
