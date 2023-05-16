package com.feng.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        // 立即删除文件
        // 1. 创建File对象
//        File f8 = new File("day19/src/com/feng/file/2.txt");
//        // 2. 调用delete()方法
//        boolean r4 = f8.delete(); // 如果文件不存在，那么就不会删除文件，返回false
//        System.out.println(r4);

        // 立即删除文件夹, 只能删除空文件夹, 如果文件夹不为空，返回 false
        // 1. 创建File对象
        File f9 = new File("day19/src/com/feng/file/bbb");
        // 2. 调用delete()方法
        boolean r5 = f9.delete(); // 如果文件夹不为空，那么就不会删除文件夹，返回false
        System.out.println(r5);

        // 程序退出时删除文件
        // 1. 创建File对象
//        File f10 = new File("day19/src/com/feng/file/2.txt");
//        // 2. 调用delete()方法
//        f10.deleteOnExit();

        // 判断文件是否存在
        // 1. 创建File对象
        File f11 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用exists()方法
        boolean r7 = f11.exists();
        System.out.println(r7);

        // 判断是否是文件
        // 1. 创建File对象
        File f12 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用isFile()方法
        boolean r8 = f12.isFile();
        System.out.println(r8);

        // 判断是否是文件夹
        // 1. 创建File对象
        File f13 = new File("day19/src/com/feng/file");
        // 2. 调用isDirectory()方法
        boolean r9 = f13.isDirectory();
        System.out.println(r9);

        // 判断是否是绝对路径
        // 1. 创建File对象
        File f14 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用isAbsolute()方法
        boolean r10 = f14.isAbsolute();
        System.out.println(r10);

        // 判断是否是隐藏文件
        // 1. 创建File对象
        File f15 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用isHidden()方法
        boolean r11 = f15.isHidden();

        // 获取文件的绝对路径
        // 1. 创建File对象
        File f16 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用getAbsolutePath()方法
        String r12 = f16.getAbsolutePath();
        System.out.println(r12);

        // 获取文件的大小
        // 1. 创建File对象
        File f17 = new File("day19/src/com/feng/file/3.txt");
        // 2. 调用length()方法
        long r13 = f17.length();
        System.out.println("r13 = " + r13);

        // 获取文件或者文件夹的名称
        // 1. 创建File对象
        File f18 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用getName()方法
        String r14 = f18.getName();
        System.out.println(r14);

        // 获取文件或者文件夹的父路径
        // 1. 创建File对象
        File f19 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用getParent()方法
        String r15 = f19.getParent();
        System.out.println("r15 = " + r15); // r15 = day19/src/com/feng/file

        // 获取文件或者文件夹的路径
        // 1. 创建File对象
        File f20 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用getPath()方法
        String r16 = f20.getPath();
        System.out.println("r16 = " + r16); // r16 = day19/src/com/feng/file/2.txt

        // 获取文件的最后修改时间, 返回的是毫秒值
        // 1. 创建File对象
        File f21 = new File("day19/src/com/feng/file/2.txt");
        // 2. 调用lastModified()方法
        long r17 = f21.lastModified();
        System.out.println("r17 = " + r17); // r17 = 1590996000000
        // 将毫秒值转换为日期对象
        Date d = new Date(r17);
        // 将日期对象转换为指定格式的字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String r18 = sdf.format(d);
        System.out.println("r18 = " + r18); // r18 = 2020-06-01 00:00:00

    }
}
