package com.feng.thread;

/**
 * @ClassName SyncDemo1
 * @Description com.feng.thread.SyncDemo1
 * @Author AsuraTu
 * @Date 2023/5/19 17:08
 * @Version 1.0.0
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        // 创建线程对象
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
