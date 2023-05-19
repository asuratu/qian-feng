package com.feng.thread;

/**
 * @ClassName Demo3
 * @Description com.feng.thread.Demo3
 * @Author AsuraTu
 * @Date 2023/5/19 15:25
 * @Version 1.0.0
 */
public class Demo3 {
    public static void main(String[] args) {
        // currentThread() 方法可以获取当前正在执行的线程对象
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        
    }
}
