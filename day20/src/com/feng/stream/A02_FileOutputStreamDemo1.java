package com.feng.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName A02_FileOutputStreamDemo1
 * @Description com.feng.stream.A02_FileOutputStreamDemo1
 * @Author AsuraTu
 * @Date 2023/5/18 13:54
 * @Version 1.0.0
 */
public class A02_FileOutputStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("day20/src/com/feng/stream/2.txt");

        // 1. 创建字节输出流对象
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f1, true); // true 表示追加写入, false 表示覆盖写入, 默认为 false
            // 2. 调用write方法写入数据
            fos.write(97);
            fos.write(98);
            // 换行
            fos.write("\r\n".getBytes());
            // 春眠不觉晓, 处处闻啼鸟
            fos.write("春眠不觉晓, 处处闻啼鸟\n".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 释放资源
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // 1. 创建缓冲字节输出流对象
        FileOutputStream fos2 = new FileOutputStream(f1, true);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);
        try {
            // 2. 调用write方法写入数据
            bos.write(121);
            bos.write(122);
            // 换行
            bos.write("\r\n".getBytes());
            // 春眠不觉晓, 处处闻啼鸟
            bos.write("夜来风雨声, 花落知多少\n".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 释放资源
            try {
                // 关闭外层流的时候, 会自动关闭内层流
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
