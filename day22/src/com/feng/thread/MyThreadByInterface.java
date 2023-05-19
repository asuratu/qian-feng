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
            // 休眠一秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
