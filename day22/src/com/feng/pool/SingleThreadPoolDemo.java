package com.feng.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SingleThreadPoolDemo
 * @Description com.feng.pool.SingleThreadPoolDemo
 * @Author AsuraTu
 * @Date 2023/5/23 14:15
 * @Version 1.0.0
 */
public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        // SingleThreadExecutor: 单线程化的线程池, 有且仅有一个工作线程执行任务, 单例模式
        // 作用: 保证任务按照指定顺序(FIFO, LIFO, 优先级)执行, 先进先出
        // 适用场景: 一个任务一个任务执行的场景
        // 优点: 保证任务按照指定顺序执行, 不会有多个线程同时执行任务

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "正在执行第" + index + "个任务");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }
}
