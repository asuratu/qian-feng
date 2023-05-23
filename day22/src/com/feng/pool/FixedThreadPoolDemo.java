package com.feng.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName FixedThreadPoolDemo
 * @Description com.feng.pool.FixedThreadPoolDemo
 * @Author AsuraTu
 * @Date 2023/5/22 17:25
 * @Version 1.0.0
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        // Executors: 线程池工厂类
        // newFixedThreadPool(int nThreads): 创建一个可重用固定线程数的线程池
        // newCachedThreadPool(): 创建一个可缓存的线程池, 如果线程池长度超过处理需要, 可灵活回收空闲线程, 若无可回收, 则新建线程
        // newSingleThreadExecutor(): 创建一个单线程化的线程池, 它只会用唯一的工作线程来执行任务, 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
        // newScheduledThreadPool(int corePoolSize): 创建一个可定时执行任务的线程池, 支持定时及周期性任务执行
        // newSingleThreadScheduledExecutor(): 创建一个单线程化的线程池, 它可以在指定延迟后执行任务, 或者定期执行任务
        // shutdown(): 关闭线程池, 等待任务执行完才关闭
        // shutdownNow(): 关闭线程池, 不等待任务执行完就关闭


        // 1. 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        // 2. 创建Runnable实例对象, 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Thread thread = Thread.currentThread();
//                thread.setName("线程1");
                System.out.println(thread.getName() + "创建了一个新的线程");
            }
        };

        // 3. execute(Runnable command): 提交一个 Runnable 任务用于执行
        //    submit(Runnable task): 提交一个 Runnable 任务用于执行
        //   execute() 方法用于提交不需要返回值的任务, 执行任务没有返回值
        //   submit() 方法用于提交需要返回值的任务, 执行任务后返回一个 Future 对象, 通过 Future 对象可以判断任务是否执行成功, 并且可以通过 Future 的 get() 方法来获取返回值, get() 方法会阻塞当前线程直到任务完成, 而使用 get(long timeout, TimeUnit unit) 方法则会阻塞当前线程一段时间后立即返回, 这时候有可能任务没有执行完
        threadPool.execute(runnable);
        threadPool.submit(runnable);
        threadPool.execute(runnable);
        threadPool.submit(runnable);
        threadPool.execute(runnable);
        threadPool.submit(runnable);

        // 4. 关闭线程池
        threadPool.shutdown();

    }
}
