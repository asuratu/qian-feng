package com.feng.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName A01_FileInputStreamDemo1
 * @Description com.feng.stream.A01_FileInputStreamDemo1
 * @Author AsuraTu
 * @Date 2023/5/16 17:54
 * @Version 1.0.0
 */
public class A01_FileInputStreamDemo1 {
    public static void main(String[] args) {
        // 将磁盘上的 1.txt 文件中的内容读取到内存中
        // 加上缓冲效果

        // 创建字节输入流对象
        File f1 = new File("day20/src/com/feng/stream/1.txt");

        // 1. 创建字节输入流对象
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f1);
            // 2. 读取数据
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(len);
                System.out.println(new String(bytes, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭资源
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 1. 创建字节缓冲输入流对象
        BufferedInputStream bis = null;


    }
}
