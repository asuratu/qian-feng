package com.feng.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @ClassName A04_FileReaderDemo1
 * @Description com.feng.stream.A04_FileReaderDemo1
 * @Author AsuraTu
 * @Date 2023/5/18 16:29
 * @Version 1.0.0
 */
public class A04_FileReaderDemo1 {
    public static void main(String[] args) {
        // 字符输入流是 FileReader
        // 只能读取普通文本
        // 不能读取图片等字节数据

        File f1 = new File("day20/src/com/feng/stream/t1/3.txt");

        FileReader fr = null;
        BufferedReader bfr = null;
        try {
            // 1. 创建字符输入流对象
            fr = new FileReader(f1);
            bfr = new BufferedReader(fr);
            // 2. 读取数据
//            char[] chars = new char[4 * 1024];
//            int len;
//            while ((len = bfr.read(chars)) != -1) {
//                System.out.println(new String(chars, 0, len));
//            }
            // 一行一行的读取
            String line;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 释放资源
            try {
                if (bfr != null) {
                    fr.close();
                    bfr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
