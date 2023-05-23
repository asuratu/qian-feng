package com.feng.consumer;

/**
 * @ClassName Producer
 * @Description com.feng.consumer.Producer
 * @Author AsuraTu
 * @Date 2023/5/22 17:00
 * @Version 1.0.0
 */
public class Producer implements Runnable {

    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    public Producer() {
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
                if (goods.isProduced()) {
                    try {
                        // 如果商品已经生产, 则等待消费者消费
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 模拟生产商品
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    goods.setProduced(true);
                    System.out.println("生产者生产商品");
                    // 唤醒消费者
                    goods.notify();
                }
            }
        }
    }
}
