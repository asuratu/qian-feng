package com.feng.wait;

/**
 * @ClassName Message
 * @Description com.feng.wait.Message
 * @Author AsuraTu
 * @Date 2023/5/22 13:24
 * @Version 1.0.0
 */
public class Message {
    // wait 和 notify 方法是 Object 类中的方法
    // wait 和 notify 方法必须在同步代码块或者同步方法中使用
    // wait 方法: 使当前线程进入等待状态, 并且释放同步监视器
    // notify 方法: 唤醒一个处于等待状态的线程, 如果有多个线程处于等待状态, 那么就唤醒优先级最高的那个线程
    // notifyAll 方法: 唤醒所有处于等待状态的线程

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
