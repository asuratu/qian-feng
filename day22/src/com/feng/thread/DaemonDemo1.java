package com.feng.thread;

/**
 * @ClassName DaemonDemo1
 * @Description com.feng.thread.DaemonDemo1
 * @Author AsuraTu
 * @Date 2023/5/21 10:08
 * @Version 1.0.0
 */
public class DaemonDemo1 {
    public static void main(String[] args) {
        // 守护线程, 一般用于做日志, 监控等功能
        // 1. 守护线程是为其他线程服务的线程, JVM在退出时不用等待守护线程执行完毕
        // 2. 守护线程不能持有需要关闭的资源(如打开文件等)
        // 3. 守护线程的设置必须在启动线程之前设置, 不能在启动线程之后设置
        // 4. 守护线程的默认值与启动它的线程一样

        // 非守护线程, 主线程, 用户线程, 一般用于做业务逻辑
        // 1. 用户线程可以持有需要关闭的资源(如打开文件等)
        // 2. 用户线程的执行完毕, JVM才会退出
        // 3. 用户线程可以设置为守护线程
        // 4. 用户线程的默认值与启动它的线程一样

        for (int i = 0; i < 200; i++) {
            System.out.println("main线程--->" + i);
            if (i == 10) {
                // 创建线程对象
                Thread thread = new Thread(new MyThreadByInterface(), "子线程");
                // 设置为守护线程
                thread.setDaemon(true);
                // 启动线程
                thread.start();
            }
        }

        // 在非守护线程结束的时候，守护线程也会结束
    }
}
