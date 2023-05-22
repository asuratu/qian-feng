package com.feng.thread;

/**
 * @ClassName Ticket
 * @Description com.feng.thread.Ticket
 * @Author AsuraTu
 * @Date 2023/5/19 17:08
 * @Version 1.0.0
 */
public class Ticket implements Runnable {
    private static int ticketNum = 500;

    @Override
//    public synchronized void run() {
    public void run() {
        while (true) {
            // synchronized 是 Java 中的关键字, 是一种同步锁
            // 可以修饰代码块, 也可以修饰方法
            // 作用是一旦一个线程访问共享数据时, 就会锁定这段代码, 直到这个线程执行完毕, 其他线程才能访问这段代码
            // 锁的是对象, 而不是代码
            // 任何时候, 只能有一个线程能够获得锁, 并且对共享数据进行操作
            // 一旦一个线程获得锁, 其他线程就不能访问这个代码块了
            // 优点: 解决了多线程的安全问题
            // 缺点: 当线程很多时, 会出现很多线程都在等待锁, 从而导致效率降低
            // 一般来说, 锁的对象是共享数据, 为了保证多个线程使用的是同一把锁, 这个锁必须是共享数据的对象
            // 一般来说, 我们使用 this 来充当锁, 因为 this 是唯一的
            // 但是在实际开发中, 为了避免 this 被修改, 一般不使用 this 来充当锁, 而是使用一个单独的对象来充当锁
            synchronized (this) {
                if (ticketNum > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + ticketNum + "张票");
                    ticketNum--;
                } else {
                    System.out.println("票已售罄");
                    break;
                }
            }
        }
    }
}
