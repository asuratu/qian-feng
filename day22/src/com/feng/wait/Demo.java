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

        Thread thread1 = new Thread(waiterThread, "等待线程");
        Thread thread2 = new Thread(notifyThread, "唤醒线程");

        thread1.start();
        thread2.start();
    }
}
