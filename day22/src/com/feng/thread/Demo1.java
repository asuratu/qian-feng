package com.feng.thread;

/**
 * @ClassName Demo1
 * @Description com.feng.thread.Demo1
 * @Author AsuraTu
 * @Date 2023/5/19 14:15
 * @Version 1.0.0
 */
public class Demo1 {
    public static void main(String[] args) {
        // 创建线程对象
        MyThead myThead1 = new MyThead(1);
        MyThead myThead2 = new MyThead(2);
        // 启动线程
        myThead1.start();
//        myThead2.start();


        for (int i = 1; i <= 100; i++) {
            // 每隔一秒钟，打印一个数字, 一直打印到100
            System.out.println("main线程打印数字：" + i);
            // 休眠一秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 以上代码总共有三个线程:
        // 1. 主线程 main
        // 2. myThead1 线程
        // 3. 垃圾回收线程
        // 以上三个线程是并发运行的
    }
}
