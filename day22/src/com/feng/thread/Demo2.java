package com.feng.thread;

/**
 * @ClassName Demo2
 * @Description com.feng.thread.Demo2
 * @Author AsuraTu
 * @Date 2023/5/19 15:07
 * @Version 1.0.0
 */
public class Demo2 {
    public static void main(String[] args) {
        // 创建线程对象的第二种方式
        // 1. 创建一个实现了Runnable接口的类
        // 2. 实现run方法
        // 3. 分配类的实例, 创建 Thread 对象时, 将该实例对象作为参数传递给 Thread 的构造方法

        Thread thread1 = new Thread(new MyThreadByInterface(1));
        Thread thread2 = new Thread(new MyThreadByInterface(2));

        // 启动线程
        thread1.start();
        thread2.start();

        for (int i = 1; i <= 100; i++) {
            // 每隔一秒钟，打印一个数字, 一直打印到100
            System.out.println("main线程打印数字：" + i);
            // 休眠一秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
