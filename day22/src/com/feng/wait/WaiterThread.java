package com.feng.wait;

/**
 * @ClassName WaiterThread
 * @Description com.feng.wait.WaiterThread
 * @Author AsuraTu
 * @Date 2023/5/22 13:27
 * @Version 1.0.0
 */
public class WaiterThread implements Runnable {
    private final Message message;

    public WaiterThread(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        // q: 为什么要用 message 对象来加锁?
        // a: 因为 wait 和 notify 方法是 Object 类中的方法, 而 message 对象是唯一的, 所以用 message 对象来加锁
        synchronized (message) {
            // 获取线程名称
            String name = Thread.currentThread().getName();
            System.out.println(name + ": 开始等待线程");
            try {
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ": 结束等待线程");
            System.out.println(message.getMessage());
        }
    }
}
