package com.feng.common;

/**
 * @ClassName A02_EnumDemo1
 * @Description com.feng.common.A02_EnumDemo1
 * @Author AsuraTu
 * @Date 2023/5/19 10:17
 * @Version 1.0.0
 */
public class A02_EnumDemo1 {
    public static void main(String[] args) {
        // 1. 获取枚举中所有的值
        // values() 方法
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }

        System.out.println("--------------");

        // 2. 获取枚举中的某一个值
        // valueOf() 方法
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);

        System.out.println("--------------1");

        // 3. 获取枚举中的某一个值
        // name() 方法
        Season spring1 = Season.SPRING;
        System.out.println(spring1.name());

        System.out.println("--------------2");

        // 4. 获取枚举中的某一个值
        // ordinal() 方法
        Season spring2 = Season.SPRING;
        System.out.println(spring2.ordinal());

        System.out.println("--------------3");

        // 5. 比较两个枚举值的大小
        // compareTo() 方法
        Season spring3 = Season.SUMMER;
        Season summer = Season.SPRING;
        System.out.println(spring3.compareTo(summer));

        System.out.println("--------------4");

        // 6. 获取枚举的类型
        // getDeclaringClass() 方法
        Season spring4 = Season.SPRING;
        Class<? extends Season> aClass = spring4.getDeclaringClass();
        System.out.println(aClass);

        System.out.println("--------------");

        // 7. 判断枚举中是否包含某一个值
        // contains() 方法
        boolean b = Season.contains("SPRING");
        System.out.println(b);

        System.out.println("--------------");

        // 8. 判断枚举中是否包含某一个值, 忽略大小写
        // containsIgnoreCase() 方法, 忽略大小写
        Season spring5 = Season.containsIgnoreCase("spring");
        System.out.println(spring5);

        System.out.println("--------------");

        // 9. 获取枚举中的某一个值
        // toString() 方法
        Season spring6 = Season.SPRING;
        System.out.println(spring6);

        System.out.println("--------------");

        // 10. 获取枚举中的某一个值
        // getEnumConstants() 方法
        Season spring7 = Season.SPRING;
        Season[] enumConstants = spring7.getEnumConstants();
        for (Season enumConstant : enumConstants) {
            System.out.println(enumConstant);
        }

        System.out.println("--------------");


        // switch (表达式),  其中表达式的数据类型只能是: byte, short, int, char, String, 枚举, 其他类型不行 !!!!

        switch (spring) {
            case SPRING -> System.out.println("春天");
            case SUMMER -> System.out.println("夏天");
            case AUTUMN -> System.out.println("秋天");
            case WINTER -> System.out.println("冬天");
        }
    }
}
