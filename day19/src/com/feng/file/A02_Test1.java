package com.feng.file;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName A02_Test1
 * @Description com.feng.file.A02_Test1
 * @Author AsuraTu
 * @Date 2023/5/16 17:20
 * @Version 1.0.0
 */
public class A02_Test1 {
    public static void main(String[] args) throws IOException {
        // 需求: 删除某个文件夹下面的所有文件和文件夹
        File f1 = new File("day19/src/com/feng/file/xxx");
        createFile("1.txt");
        createFile("2.txt");
        createFile("3.txt");

        // 删除 xxx 文件夹下面的所有文件
        deleteFile(f1);
    }

    private static void deleteFile(File f1) {
        File[] files = f1.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    boolean deleteResult = file.delete();
                    System.out.println(deleteResult);
                } else {
                    deleteFile(file);
                }
            }
        }
    }

    public static void createFile(String name) throws IOException {
        File f1 = new File("day19/src/com/feng/file/xxx/" + name);
        if (!f1.exists()) {
            boolean r = f1.createNewFile();
            System.out.println(r);
        }
    }
}
