package com.feng.stream;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName Demo1
 * @Description com.feng.stream.Demo1
 * @Author AsuraTu
 * @Date 2023/5/23 17:40
 * @Version 1.0.0
 */
public class Demo1 {
    public static void main(String[] args) {
        // 将 list 集合中, 包含 "张" 的元素, 存储到一个新集合中

        // 1. 创建一个 list 集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "李四", "王五", "张飞", "关羽", "张小凡");
        // 2. 创建一个新的集合, 用于存储筛选之后的元素
        ArrayList<String> newList = new ArrayList<>();
        // 3. 遍历 list 集合, 获取每一个元素
        for (String s : list) {
            // 4. 判断元素是否包含 "张"
            if (s.contains("张")) {
                // 5. 如果包含, 就存储到新的集合中
                newList.add(s);
            }
        }
        // 6. 遍历新的集合
        for (String s : newList) {
            System.out.println(s);
        }
    }
}
