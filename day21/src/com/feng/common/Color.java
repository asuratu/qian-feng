package com.feng.common;

import java.util.LinkedHashMap;

/**
 * @author asura
 */
public enum Color {
    // 1: 红色, 2: 绿色, 3: 蓝色

    /**
     * 红色
     */
    RED(1, "红色"),
    GREEN(2, "绿色"),
    BLUE(3, "蓝色"),
    YELLOW(4, "黄色"),
    BLACK(5, "黑色");

    private final int code;
    private final String name;

    Color(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Color contains(int code) {
        Color[] values = Color.values();
        for (Color value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    // 获取枚举的 LinkedHashMap
    public static LinkedHashMap<Integer, String> getColorsMap() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        Color[] values = Color.values();
        for (Color value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


}
