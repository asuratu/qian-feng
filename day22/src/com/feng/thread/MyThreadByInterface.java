package com.feng.thread;

/**
 * @ClassName MyThreadByInterface
 * @Description com.feng.thread.MyThreadByInterface
 * @Author AsuraTu
 * @Date 2023/5/19 15:08
 * @Version 1.0.0
 */
public class MyThreadByInterface implements Runnable {
    private int groupNum;

    public MyThreadByInterface(int groupNum) {
        this.groupNum = groupNum;
    }

    public MyThreadByInterface() {
        this.groupNum = 0;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    @Override
    public void run() {
        // 每隔一秒钟，打印一个数字, 一直打印到100
        for (int i = 1; i <= 100; i++) {
            System.out.println("第" + getGroupNum() + "组打印数字：" + i);
            try {
                // 此处只有 try-catch, 不能 throws, 因为 run 方法是重写的接口方法, 不能抛出异常
                // sleep 方法在开发中不会用
                // 开发中会使用锁
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
