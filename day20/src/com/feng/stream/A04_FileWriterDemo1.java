package com.feng.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @ClassName A04_FileWriterDemo1
 * @Description com.feng.stream.A04_FileWriterDemo1
 * @Author AsuraTu
 * @Date 2023/5/18 16:53
 * @Version 1.0.0
 */
public class A04_FileWriterDemo1 {
    public static void main(String[] args) {
        // 字符输出流是 FileWriter
        // 只能输出普通文本
        // 不能输出图片等字节数据

        File f1 = new File("day20/src/com/feng/stream/t2/3.txt");

        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            // 1. 创建字符输出流对象
            fw = new FileWriter(f1, true);
            bfw = new BufferedWriter(fw, 1024);
            // 2. 写出数据
//            bfw.write("hello\n");
//            bfw.write("world\n");
//            bfw.write("java\n");
            String str = "今天天气真好, ";
            bfw.write(str, 0, str.length());
            bfw.newLine();
            bfw.write("很适合学习\n");
            // 3. 刷新
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. 释放资源
            try {
                if (bfw != null) {
                    bfw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // 一个中字符占用三个字节
        System.out.println("执".getBytes().length);
        System.out.println("执".length());
        System.out.println("执".toCharArray().length);
        // 一个英文字符占用一个字节
        System.out.println("a".getBytes().length);
        System.out.println("a".length());
        System.out.println("a".toCharArray().length);
    }
}
