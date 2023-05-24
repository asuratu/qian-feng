package com.feng.stream;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @ClassName Demo2
 * @Description com.feng.stream.Demo2
 * @Author AsuraTu
 * @Date 2023/5/24 13:19
 * @Version 1.0.0
 */
public class Demo2 {
    public static void main(String[] args) {
        // 需求:
        // 将 list 集合中, 包含 "张" 的元素, 存储到一个新集合中, 要求使用 Stream 完成

        // 1. 创建一个 list 集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "李四", "王五", "张飞", "关羽", "张小凡");

        // 2. 使用 Stream 完成, 存储到一个新集合中
        ArrayList<String> newList = new ArrayList<>();
        list.stream().filter(s -> s.contains("张")).forEach(newList::add);
        System.out.println(newList);

        // q: 为什么不直接使用 forEach 方法打印呢?
        // a: 因为 forEach 方法是一个终结方法, 会销毁 Stream 流, 无法再次使用
        // q: Stream 流是什么?
        // a: Stream 流是 JDK1.8 之后出现的, 用于操作集合的工具类
        // q: Stream 流的特点是什么?
        // a: Stream 流的特点是: 只能被使用一次, 用完就要销毁
        // q: Stream 流的使用步骤是什么?
        // a: Stream 流的使用步骤是: 获取流 -> 操作流 -> 终结流
        // q: Stream 流的获取方式有哪些?
        // a: Stream 流的获取方式有: 集合获取, 数组获取, Stream 类中的静态方法获取
        // q: Stream 流的操作方式有哪些?
        // a: Stream 流的操作方式有: 中间操作, 终结操作
        // q: Stream 流的中间操作有哪些?
        // a: Stream 流的中间操作有: filter, map, limit, skip, concat, distinct, sorted, peek
        // q: Stream 流的终结操作有哪些?
        // a: Stream 流的终结操作有: forEach, forEachOrdered, toArray, reduce, collect, min, max, count, anyMatch, allMatch, noneMatch, findFirst, findAny
        // q: Stream 流的中间操作和终结操作有什么区别?
        // a: Stream 流的中间操作是惰性的, 只有遇到终结操作时, 才会执行
        // q: Stream 流的中间操作和终结操作的返回值是什么?
        // a: Stream 流的中间操作返回值是 Stream 流, 终结操作返回值是 void 或其他类型
        // q: Stream 流的中间操作和终结操作的参数是什么?

    }
}
