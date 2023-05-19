package com.feng.thread;

/**
 * @ClassName Demo4
 * @Description com.feng.thread.Demo4
 * @Author AsuraTu
 * @Date 2023/5/19 15:47
 * @Version 1.0.0
 */
public class Demo4 {
    public static void main(String[] args) {
        // 线程优先级
        // 1. 线程的优先级有10个等级，分别用整数1-10表示，其中1为最低优先级，5为默认优先级，10为最高优先级
        // 2. 线程优先级的继承特性：A线程启动B线程，则B线程的优先级与A是一样的
        // 3. 线程优先级的具体使用：
        //  3.1. 线程的优先级可以通过setPriority(int newPriority)方法来改变
        //  3.2. 线程的优先级可以通过getPriority()方法来获取
        //  3.3. 线程的优先级可以通过Thread类的三个常量来表示
        //      public final static int MIN_PRIORITY = 1;
        //      public final static int NORM_PRIORITY = 5;
        //      public final static int MAX_PRIORITY = 10;

        // 设置优先级并不一定优先, 只是优先执行的概率大一些

        Thread thread1 = new Thread(new MyThreadByInterface(1), "线程1");
        Thread thread2 = new Thread(new MyThreadByInterface(2), "线程2");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
