package com.feng.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadPoolExecutorDemo
 * @Description com.feng.pool.ThreadPoolExecutorDemo
 * @Author AsuraTu
 * @Date 2023/5/23 15:16
 * @Version 1.0.0
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
        // 这种方式创建线程池, 适用于自定义线程池, 重要!!!!!!!!!!!!!!
        // 参数:
        // 1. corePoolSize 核心线程数, 线程池中始终存活的线程数量
        // 2. maximumPoolSize 最大线程数, 线程池最多可以运行的线程数
        // 3. keepAliveTime 线程没有任务时最多保持多长时间后会终止, 0表示不会终止, 如果线程空闲超过了keepAliveTime, 但是线程池中的线程数大于corePoolSize, 那么这个线程就会被终止回收
        // 4. unit 时间单位, 和keepAliveTime配合使用
        // 5. workQueue 任务队列, 存储还未执行的任务
        // 6. threadFactory 线程工厂, 用于创建线程, 一般使用默认的即可
        // 7. handler 拒绝策略, 当任务太多来不及处理时, 如何拒绝任务
        // 作用: 创建一个线程池
        // 适用场景: 适用于自定义线程池

        // 如果运行的线程数少于corePoolSize, 那么创建新线程来执行任务, 即使线程池中的其他线程是空闲的, Executor倾向于创建新线程而不是去复用空闲的线程
        // 如果运行的线程数等于或者多于corePoolSize, 那么将任务加入workQueue中, 排队等待执行, 如果workQueue已满, 则创建新线程来处理任务, 如果线程数大于maximumPoolSize, 则根据拒绝策略来处理任务
        // 如果某个线程空闲时间超过keepAliveTime, 线程将会终止, 直到线程数量等于corePoolSize, 如果allowCoreThreadTimeOut设置为true, 那么核心线程也会终止

        // 无界队列
        // 优点: 可以存储大量的任务
        // 缺点: 由于队列没有大小限制, 所以当有大量任务加入时, 会导致内存溢出
        // 使用场景: 适用于任务数量特别多的场景
        // new LinkedBlockingQueue<Runnable>()

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 15; i++) {
            final int finalI = i;
            threadPoolExecutor.execute(() -> {
                Thread thread = Thread.currentThread();
                System.out.println(finalI + ": " + thread.getName() + "正在执行任务");
            });
        }

        // q: final 和 finally 的区别?
        // a: final 修饰的变量是常量, 修饰的方法不能被重写, 修饰的类不能被继承
        //    finally 用于异常处理, 一般和try一起使用, 无论是否发生异常, finally中的代码都会被执行

        // q: throw 和 throws 的区别?
        // a: throw 用于抛出异常, throws 用于声明异常

    }
}
