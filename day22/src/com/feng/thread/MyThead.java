package com.feng.thread;

/**
 * @ClassName MyThead
 * @Description com.feng.thread.MyThead
 * @Author AsuraTu
 * @Date 2023/5/19 14:16
 * @Version 1.0.0
 */
public class MyThead extends Thread {

    private int groupNum;

    public MyThead(int groupNum) {
        this.groupNum = groupNum;
    }

    public MyThead() {
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

    /**
     * 重写run方法
     */
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
