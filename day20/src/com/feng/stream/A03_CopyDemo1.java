package com.feng.stream;

import java.io.*;
import java.nio.file.Files;

/**
 * @ClassName A03_CopyDemo1
 * @Description com.feng.stream.A03_CopyDemo1
 * @Author AsuraTu
 * @Date 2023/5/18 14:59
 * @Version 1.0.0
 */
public class A03_CopyDemo1 {
    public static void main(String[] args) throws IOException {
        // 将 t1/1.txt 复制到 t2/
        // 1. 创建字节输入流对象, 关联数据源文件
        // 2. 创建字节输出流对象, 关联目的地文件
        // 3. 定义变量, 记录读取到的内容
        // 4. 循环读取, 只要条件满足就一直读, 并将读取到的内容赋值给变量
        // 5. 将读取到的数据写入到目的地文件中
        // 6. 释放资源

        // 记录开始时间
        long start = System.currentTimeMillis();


        // 1. 创建字节输入流对象, 关联数据源文件
        File f1 = new File("day20/src/com/feng/stream/t1/d2.mp4");

        // 直接使用 Files.copy() 方法
        Files.copy(f1.toPath(), new FileOutputStream("day20/src/com/feng/stream/t2/2.txt"));

        // 使用字节流复制
        // 将 FileInputStream 对象传递给 BufferedInputStream 的构造方法
        FileInputStream fis2 = new FileInputStream(f1);
        BufferedInputStream bis = new BufferedInputStream(fis2);

        // 2. 创建字节输出流对象, 关联目的地文件
        File f2 = new File("day20/src/com/feng/stream/t2/d2.mp4");

        // 输入字节流会自动创建文件
        // 文件不存在, 创建文件
//        if (!f2.exists()) {
//            try {
//                boolean newFile = f2.createNewFile();
//                if (newFile) {
//                    System.out.println("文件创建成功");
//                } else {
//                    System.out.println("文件创建失败");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        FileOutputStream fos2 = new FileOutputStream(f2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 2. 读取数据
        byte[] bytes = new byte[4 * 1024]; // 缓冲区字节数组
        int len;
        try {
            // 循环读取, 每次读取 4 * 1024 个字节的数据放入到 bytes 数组中
            // 将 bytes 数组中的数据写入到目的地文件中
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭资源
            try {
                bis.close();
                bos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("复制文件共耗时: " + (end - start) + " 毫秒");
    }
}
