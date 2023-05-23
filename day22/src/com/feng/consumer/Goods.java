package com.feng.consumer;

/**
 * @ClassName Goods
 * @Description com.feng.consumer.Goods
 * @Author AsuraTu
 * @Date 2023/5/22 16:51
 * @Version 1.0.0
 */
public class Goods {
    // Goods 这个类的作用是用于两个线程之间通信
    // 两个线程分别是生产者线程和消费者线程
    // goods.wait() 消费者等待
    // goods.notify() 生产者通知消费者消费

    private String name;
    private double price;
    // 商品是否已生产, false 表示未生产, true 表示已生产
    // false 表示消费者可以消费, true 不可以消费
    private boolean isProduced;

    public Goods(String name, double price, boolean isProduced) {
        this.name = name;
        this.price = price;
        this.isProduced = isProduced;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isProduced() {
        return isProduced;
    }

    public void setProduced(boolean produced) {
        isProduced = produced;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isProduced=" + isProduced +
                '}';
    }


}
