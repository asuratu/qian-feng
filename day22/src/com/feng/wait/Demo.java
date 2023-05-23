package com.feng.wait;

/**
 * @ClassName Demo
 * @Description com.feng.wait.Demo
 * @Author AsuraTu
 * @Date 2023/5/22 13:27
 * @Version 1.0.0
 */
public class Demo {
    public static void main(String[] args) {
        Message message = new Message("Hello World");
        WaiterThread waiterThread = new WaiterThread(message);
        NotifyThread notifyThread = new NotifyThread(message);

        Thread thread1 = new Thread(waiterThread, "等待线程1");
        Thread thread2 = new Thread(waiterThread, "等待线程2");
        Thread thread3 = new Thread(waiterThread, "等待线程3");
        Thread thread4 = new Thread(notifyThread, "唤醒线程1");
//        Thread thread5 = new Thread(notifyThread, "唤醒线程2");
//        Thread thread6 = new Thread(notifyThread, "唤醒线程3");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
//        thread5.start();
//        thread6.start();
    }
}
