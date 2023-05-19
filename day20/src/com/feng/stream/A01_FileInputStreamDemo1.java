package com.feng.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName A01_FileInputStreamDemo1
 * @Description com.feng.stream.A01_FileInputStreamDemo1
 * @Author AsuraTu
 * @Date 2023/5/16 17:54
 * @Version 1.0.0
 */
public class A01_FileInputStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        // 将磁盘上的 1.txt 文件中的内容读取到内存中
        // 加上缓冲效果

        // 创建字节输入流对象
        File f1 = new File("day20/src/com/feng/stream/1.txt");

        // 1. 创建字节输入流对象
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f1);
            // 2. 读取数据
            byte[] bytes = new byte[4 * 1024];
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

        System.out.println("--------");

        // 1. 创建字节缓冲输入流对象
        if (fis != null) {
            // 将 FileInputStream 对象传递给 BufferedInputStream 的构造方法
            FileInputStream fis2 = new FileInputStream(f1);
            BufferedInputStream bis = new BufferedInputStream(fis2);
            // 2. 读取数据
            byte[] bytes = new byte[4 * 1024];
            int len;
            try {
                // 循环读取
                while ((len = bis.read(bytes)) != -1) {
                    System.out.println(len);
                    System.out.println(new String(bytes, 0, len));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 3. 关闭资源
                try {
                    bis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        // FileInputStream 和 BufferedInputStream 的区别
        // FileInputStream 是直接对文件进行操作的，而 BufferedInputStream 是对 FileInputStream 进行了包装
        // FileInputStream 是一次读取一个字节，而 BufferedInputStream 是一次读取一个字节数组
        // FileInputStream 没有缓冲区，而 BufferedInputStream 有缓冲区, 缓冲区的意思是：在内存中开辟一块空间，用来临时存储数据
        // FileInputStream 读取文件的效率低，而 BufferedInputStream 读取文件的效率高
        // FileInputStream 读取文件的效率低是因为每次读取文件都会访问磁盘，而 BufferedInputStream 读取文件的效率高是因为每次读取文件都是从缓冲区中读取的

    }
}
