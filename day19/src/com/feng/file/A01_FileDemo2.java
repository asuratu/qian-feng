package com.feng.file;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName A01_FileDemo2
 * @Description com.feng.file.A01_FileDemo2
 * @Author AsuraTu
 * @Date 2023/5/16 14:36
 * @Version 1.0.0
 */
public class A01_FileDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建文件
        // 1. 创建File对象
        File f5 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用createNewFile()方法
        boolean r = f5.createNewFile(); // 如果文件已经存在，那么就不会创建文件，返回false
        System.out.println(r);

        // 创建文件夹, 单级文件夹
        // 1. 创建File对象
        File f6 = new File("day19/src/com/feng/file/aaa");
        // 2. 调用mkdir()方法
        boolean r2 = f6.mkdir(); // 如果文件夹已经存在，那么就不会创建文件夹，返回false
        System.out.println(r2);

        // 创建文件夹, 多级文件夹
        // 1. 创建File对象
        File f7 = new File("day19/src/com/feng/file/bbb/ccc/ddd");
        // 2. 调用mkdirs()方法
        boolean r3 = f7.mkdirs(); // 如果文件夹已经存在，那么就不会创建文件夹，返回false
        System.out.println(r3);
    }
}
