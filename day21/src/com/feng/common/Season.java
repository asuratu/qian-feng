package com.feng.common;

/**
 * @author asura
 */

public enum Season {
    /**
     * 春天1
     */
    SPRING,
    /**
     * 夏天
     */
    SUMMER,
    /**
     * 秋天
     */
    AUTUMN,
    /**
     * 冬天
     */
    WINTER;

    /**
     * 判断枚举中是否包含某一个值
     */
    public static boolean contains(String name) {
        Season[] values = Season.values();
        for (Season value : values) {
            // equals() 方法比较的是两个字符串的内容是否相同
            if (value.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断枚举中是否包含某一个值, 忽略大小写
     */
    public static Season containsIgnoreCase(String name) {
        Season[] values = Season.values();
        for (Season value : values) {
            // equalsIgnoreCase() 方法比较的是两个字符串的内容是否相同，忽略大小写
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

    public Season[] getEnumConstants() {
        return new Season[]{SPRING, SUMMER, AUTUMN, WINTER};
    }
}
