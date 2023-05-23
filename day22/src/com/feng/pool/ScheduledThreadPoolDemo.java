package com.feng.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ScheduledThreadPoolDemo
 * @Description com.feng.pool.ScheduledThreadPoolDemo
 * @Author AsuraTu
 * @Date 2023/5/23 14:29
 * @Version 1.0.0
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        // Executors.newScheduledThreadPool(int corePoolSize) 创建一个定长线程池, 支持定时及周期性任务执行
        // 参数: corePoolSize 核心线程数
        // 作用: 定时执行任务或周期性执行任务
        // 适用场景: 定时任务或周期性任务

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        // add time
        System.out.println("添加任务时间：" + new Date());

        // 延迟执行任务
        scheduledExecutorService.schedule(() -> {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "正在执行延迟任务, 执行时间：" + new Date());
        }, 3, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

        // 周期性执行任务
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            Thread thread = Thread.currentThread();
//            System.out.println(thread.getName() + "正在执行周期任务, 执行时间：" + new Date());
//        }, 1, 3, TimeUnit.SECONDS);

        // 关闭线程池
//        scheduledExecutorService.shutdown();
    }
}
