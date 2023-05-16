package com.feng.file;

import java.io.File;

/**
 * @ClassName A01_FileDemo1
 * @Description com.feng.file.A01_FileDemo1
 * @Author AsuraTu
 * @Date 2023/5/16 14:29
 * @Version 1.0.0
 */
public class A01_FileDemo1 {
    public static void main(String[] args) {
        File f1 = new File("day19/src/com/feng/file/1.txt");

        File f2 = new File("day19/src/com/feng/file", "1.txt");

        File f3 = new File("day19/src/com/feng/file");
        File f4 = new File(f3, "1.txt");

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f4);
    }
}
