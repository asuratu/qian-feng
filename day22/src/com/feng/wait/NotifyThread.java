package com.feng.wait;

/**
 * @ClassName NotifyThread
 * @Description com.feng.wait.NotifyThread
 * @Author AsuraTu
 * @Date 2023/5/22 13:28
 * @Version 1.0.0
 */
public class NotifyThread implements Runnable {
    private final Message message;

    public NotifyThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        // q: 为什么要用 message 对象来加锁?
        // a: 因为 wait 和 notify 方法是 Object 类中的方法, 而 message 对象是唯一的, 所以用 message 对象来加锁
        synchronized (message) {
            System.out.println("开始唤醒线程");
            message.notify();
            System.out.println("结束唤醒线程");
        }
    }
}
