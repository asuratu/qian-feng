package com.feng.file;

import java.io.File;

/**
 * @ClassName A01_FileDemo3
 * @Description com.feng.file.A01_FileDemo3
 * @Author AsuraTu
 * @Date 2023/5/16 17:06
 * @Version 1.0.0
 */
public class A01_FileDemo3 {
    public static void main(String[] args) {
        // listFiles() 获取当前目录下的所有文件和文件夹的File对象
        File f1 = new File("day19/src/com/feng/file");
        File[] files = f1.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
        }

        System.out.println("--------");

        // list() 获取当前目录下的所有文件和文件夹的名称
        String[] list = f1.list();
        if (list != null) {
            for (String s : list) {
                System.out.println(s);
            }
        }

    }
}
