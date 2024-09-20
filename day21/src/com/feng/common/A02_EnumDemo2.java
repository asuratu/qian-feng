package com.feng.common;

import java.util.LinkedHashMap;

/**
 * @ClassName A02_EnumDemo2
 * @Description com.feng.common.A02_EnumDemo2
 * @Author AsuraTu
 * @Date 2023/5/19 10:52
 * @Version 1.0.0
 */
public class A02_EnumDemo2 {
    public static void main(String[] args) {
        int code = Color.RED.getCode();
        System.out.println(code);
        String name = Color.RED.getName();
        System.out.println(name);

        System.out.println("--------------");

        LinkedHashMap<Integer, String> colorsMap = Color.getColorsMap();
        // {1=红色, 2=蓝色, 3=黄色, 4=绿色}
        System.out.println(colorsMap);

        System.out.println("--------------");

        System.out.println(Color.contains(1));
        System.out.println(Color.contains(10));
    }
}
