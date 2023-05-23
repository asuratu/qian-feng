package com.feng.wait;

class Message1 {
    private String Message1;

    public Message1(String Message1) {

        this.Message1 = Message1;
    }

    public String getMessage1() {
        return Message1;
    }

    public void setMessage1(String Message1) {
        this.Message1 = Message1;
    }

    @Override
    public String toString() {
        return "Message1{" +
                "Message1='" + Message1 + '\'' +
                '}';
    }

}

class WaiterThread1 implements Runnable {
    //想一个问题？WaiterThread1  使用Message1对象调用
    //wait() 咋解决？
    private final Message1 msg;

    public WaiterThread1(Message1 msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        //先获取当前线程名字
        String name = Thread.currentThread().getName();
        System.out.println(name + "等待唤醒时间:" + System.currentTimeMillis());
        //让等待线程去阻塞，去等待  这个线程执行不下去了
        //锁的是msg对象
        synchronized (msg) {//为啥是哟个wait的时候要加锁？等会将
            try {
                msg.wait();//代码走到这，当前这个线程阻塞，不往下走了
                //咱们得想办法让这个等待线程继续执行下去，咋办？
                //在另外一个线程中去调用notify方法那么等待线程就会执行下去
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("123");
            System.out.println(name + "被唤醒的时间:" + System.currentTimeMillis());
        }


    }
}

//唤醒线程
class NotifyThread1 implements Runnable {
    //也要用同一个对象是WaiterThread1线程中同一个对象调用notify()方法
    private final Message1 msg;

    public NotifyThread1(Message1 msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            //我的想法是不能先让唤醒线程执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始唤醒等待线程");
        synchronized (msg) {
            msg.setMessage1("我是修改之后的Message1值");
            //msg.notify();
            msg.notifyAll();//唤醒所有线程
        }

    }
}

public class Demo2 {
    public static void main(String[] args) {
        Message1 Message1 = new Message1("我是Message1属性");
        WaiterThread1 WaiterThread1 = new WaiterThread1(Message1);
        NotifyThread1 NotifyThread1 = new NotifyThread1(Message1);
        //如果等待线程好几个 咋办呢？
        new Thread(WaiterThread1, "等待线程1").start();
        new Thread(WaiterThread1, "等待线程2").start();
        new Thread(WaiterThread1, "等待线程3").start();
        new Thread(NotifyThread1, "唤醒线程").start();

        //等待线程等待唤醒时间:1660187660718   等待线程
        //唤醒线程开始唤醒等待线程        唤醒线程
        //123  等待线程
        //等待线程被唤醒的时间:1660187661740  等待线程
        //这叫线程之间的通信问题！！！
    }
}
