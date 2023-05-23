package com.feng.consumer;

/**
 * @ClassName Consumer
 * @Description com.feng.consumer.Consumer
 * @Author AsuraTu
 * @Date 2023/5/22 16:59
 * @Version 1.0.0
 */
public class Consumer implements Runnable {

    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    public Consumer() {
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (goods) {
                if (!goods.isProduced()) {
                    // 如果商品已经生产, 则消费者等待
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 模拟消费商品
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    goods.setProduced(false);
                    System.out.println("消费者消费商品");
                    // 唤醒生产者
                    goods.notify();
                }
            }
        }

    }
}
