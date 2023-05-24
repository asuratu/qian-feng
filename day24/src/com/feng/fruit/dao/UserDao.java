package com.feng.fruit.dao;

import com.feng.fruit.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description 读取 users.json 文件中的数据
 * @Author AsuraTu
 * @Date 2023/5/24 14:48
 * @Version 1.0.0
 */
public class UserDao {
    /**
     * 读取 users.json 文件中的数据
     */
    public static List<User> getUsers() {
        File f1 = new File("day24/src/com/feng/fruit/users.json");

        FileReader fr = null;
        BufferedReader bfr = null;
        String json = null;
        try {
            // 1. 创建字符输入流对象
            fr = new FileReader(f1);
            bfr = new BufferedReader(fr);
            // 2. 读取数据
            char[] chars = new char[4 * 1024];
            int len;
            while ((len = bfr.read(chars)) != -1) {
                json = new String(chars, 0, len);
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

        // 将 json 字符串数据转换为 map 集合
        return null;
    }

}
