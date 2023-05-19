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

        thread.setName("主线程");
        System.out.println(thread.getName());

        // q: native 关键字的作用是什么？
        // a: native 关键字的作用是调用本地方法, 本地方法是指在本地机器上执行的方法

        // q:解释下值传递和引用传递
        // a:值传递是指将实际参数的值复制一份传递给函数, 这样在函数中如果对参数进行修改, 将不会影响到实际参数
        // java 中的基本数据类型都是值传递, 如 int, double, float, char, boolean 等
        // java 中的引用类型都是引用传递, 如 String, 数组, 对象等
        // java 中的引用类型都是指向堆内存中的对象, 传递的是对象的地址, 因此在函数中对参数进行修改, 将会影响到实际参数

        // new Thread(Runnable target, String name), 通过构造方法给线程设置名字
        Thread thread1 = new Thread(new MyThreadByInterface(1), "线程1");
        Thread thread2 = new Thread(new MyThreadByInterface(2), "线程2");
        // 获取线程的名字 (默认情况下, 线程的名字是 Thread-0, Thread-1, Thread-2, ...)
        String thread1Name = thread1.getName();
        String thread2Name = thread2.getName();
        System.out.println(thread1Name);
        System.out.println(thread2Name);

        // 设置线程的名字
//        thread1.setName("线程1");
//        thread2.setName("线程2");

        // q: 为什么要给线程设置名字?
        // a: 1. 方便调试
        //    2. 方便日志输出
        //    3. 方便区分线程


    }
}
