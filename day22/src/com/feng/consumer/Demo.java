package com.feng.consumer;

/**
 * @ClassName Demo
 * @Description com.feng.consumer.Demo
 * @Author AsuraTu
 * @Date 2023/5/22 17:02
 * @Version 1.0.0
 */
public class Demo {
    public static void main(String[] args) {
        Goods goods = new Goods("香蕉", 5.0, false);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);

        Thread thread1 = new Thread(producer, "生产者线程");
        Thread thread2 = new Thread(consumer, "消费者线程");
        
        thread1.start();
        thread2.start();

    }
}
