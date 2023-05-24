package com.feng.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @ClassName Demo3
 * @Description com.feng.stream.Demo3
 * @Author AsuraTu
 * @Date 2023/5/24 13:42
 * @Version 1.0.0
 */
public class Demo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三", "张三", "李四", "李四", "王五", "张飞", "关羽", "张小凡");

        // 获取 Stream 流
        Stream<String> stream = list.stream();

        // Stream 流中的方法

        // 中间操作:
        // 1. filter 方法
        // 作用: 用于对 Stream 流中的数据进行过滤
        // 参数: Predicate 接口, 用于对 Stream 流中的数据进行过滤
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.filter(Predicate 接口)
//        stream.filter(s -> s.startsWith("张"))
//                .filter(s -> s.length() == 3)
//                .forEach(System.out::println);

        // 2. map 方法
        // 作用: 用于对 Stream 流中的数据进行映射
        // 参数: Function 接口, 用于对 Stream 流中的数据进行映射
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.map(Function 接口)
//        stream.map(s -> s + "·").forEach(System.out::println);

        // 3. limit 方法
        // 作用: 用于对 Stream 流中的数据进行截取
        // 参数: long maxSize, 截取的个数
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.limit(long maxSize)
//        stream.limit(3).forEach(System.out::println);

        // 4. skip 方法
        // 作用: 用于对 Stream 流中的数据进行跳过
        // 参数: long n, 跳过的个数
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.skip(long n)
//        stream.skip(3).forEach(System.out::println);

        // 5. concat 方法 (静态方法)
        // 作用: 用于把流组合到一起, 合并成一个流
        // 参数: Stream 流
        // 返回值: Stream 流
        // 使用方式: Stream.concat(Stream 流对象1, Stream 流对象2)
//        Stream<String> stream2 = Stream.of("张三丰", "张无忌", "张翠山");
//        Stream.concat(stream, stream2).forEach(System.out::println);

        // 6. distinct 方法
        // 作用: 用于对 Stream 流中的数据进行去重
        // 参数: 无
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.distinct()
//        stream.distinct().forEach(System.out::println);

        // 7. sorted 方法
        // 作用: 用于对 Stream 流中的数据进行排序
        // 参数: Comparator 接口, 用于对 Stream 流中的数据进行排序, 无参默认升序
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.sorted(Comparator 接口)
//        stream.sorted().forEach(System.out::println);
//        stream.sorted((Comparator.comparingInt(String::length).thenComparing(o -> o))).forEach(System.out::println);

        // 8. peek 方法
        // 作用: 用于对 Stream 流中的数据进行遍历
        // 参数: Consumer 接口, 用于对 Stream 流中的数据进行遍历
        // 返回值: Stream 流
        // 使用方式: Stream 流对象.peek(Consumer 接口)
//        stream.peek(System.out::println).forEach(System.out::println);

        // 9. peek 和 map 的区别
        // peek 是中间操作, map 是中间操作
        // peek 无返回值, map 有返回值
        // peek 只能对流中的数据进行遍历, map 可以对流中的数据进行映射
        // peek 只能使用 Consumer 接口, map 可以使用 Function 接口
        // peek 只能使用一次, map 可以使用多次
        // peek 不能改变流中的数据, map 可以改变流中的数据
        // peek 不能延迟执行, map 可以延迟执行
        // peek 不能单独使用, map 可以单独使用
        // peek 不能提高效率, map 可以提高效率
        // peek 不能减少流中的数据, map 可以减少流中的数据
        // peek 不能对流中的数据进行过滤, map 可以对流中的数据进行过滤

        // 终结操作:
        // 1. forEach 方法
        // 作用: 用于对 Stream 流中的数据进行遍历
        // 参数: Consumer 接口, 用于对 Stream 流中的数据进行遍历
        // 返回值: 无
        // 使用方式: Stream 流对象.forEach(Consumer 接口)
//        stream.forEach(System.out::println);

        // 2. count 方法
        // 作用: 用于对 Stream 流中的数据进行统计
        // 参数: 无
        // 返回值: long, 统计的个数
        // 使用方式: Stream 流对象.count()
//        System.out.println(stream.count());

        // 3. collect 方法, 将 Stream 流中的数据收集到集合中
        // 作用: 用于对 Stream 流中的数据进行收集
        // 参数: Collector 接口, 用于对 Stream 流中的数据进行收集
        // 返回值: R, 收集后的数据
        // 使用方式: Stream 流对象.collect(Collector 接口)
//        List<String> list1 = stream.collect(Collectors.toList());
//        System.out.println(list1);
//        Set<String> set = stream.collect(Collectors.toSet());
//        System.out.println(set);

        // 4. max 方法
        // 作用: 用于对 Stream 流中的数据进行求最大值
        // 参数: Comparator 接口, 用于对 Stream 流中的数据进行比较
        // 返回值: Optional<T>, 最大值
        // 使用方式: Stream 流对象.max(Comparator 接口)
//        Optional<String> max = stream.max(Comparator.comparingInt(String::length));
//        max.ifPresent(System.out::println);

        // 5. min 方法
        // 作用: 用于对 Stream 流中的数据进行求最小值
        // 参数: Comparator 接口, 用于对 Stream 流中的数据进行比较
        // 返回值: Optional<T>, 最小值
        // 使用方式: Stream 流对象.min(Comparator 接口)
//        Optional<String> min = stream.min(Comparator.comparingInt(String::length));
//        min.ifPresent(System.out::println);

        // 6. findFirst 方法
        // 作用: 用于对 Stream 流中的数据进行查找
        // 参数: 无
        // 返回值: Optional<T>, 第一个值
        // 使用方式: Stream 流对象.findFirst()
//        Optional<String> first = stream.findFirst();
//        first.ifPresent(System.out::println);

        // 7. findAny 方法
        // 作用: 用于对 Stream 流中的数据进行查找
        // 参数: 无
        // 返回值: Optional<T>, 任意一个值
        // 使用方式: Stream 流对象.findAny()
//        Optional<String> any = stream.findAny();
//        any.ifPresent(System.out::println);

        // findFirst 和 findAny 的区别
        // findFirst 一般用于串行流, findAny 一般用于并行流
        // findFirst 一般用于查找第一个, findAny 一般用于查找任意一个
        // findFirst 一般用于串行流中的第一个, findAny 一般用于并行流中的第一个

        // 8. allMatch 方法
        // 作用: 用于对 Stream 流中的数据进行判断
        // 参数: Predicate 接口, 用于对 Stream 流中的数据进行判断
        // 返回值: boolean, 是否全部满足
        // 使用方式: Stream 流对象.allMatch(Predicate 接口)
//        boolean b = stream.allMatch(s -> s.length() == 3);
//        System.out.println(b);

        // 9. anyMatch 方法
        // 作用: 用于对 Stream 流中的数据进行判断
        // 参数: Predicate 接口, 用于对 Stream 流中的数据进行判断
        // 返回值: boolean, 是否有一个满足
        // 使用方式: Stream 流对象.anyMatch(Predicate 接口)
//        boolean b = stream.anyMatch(s -> s.length() == 3);
//        System.out.println(b);

        // 10. noneMatch 方法
        // 作用: 用于对 Stream 流中的数据进行判断
        // 参数: Predicate 接口, 用于对 Stream 流中的数据进行判断
        // 返回值: boolean, 是否全部不满足
        // 使用方式: Stream 流对象.noneMatch(Predicate 接口)
//        boolean b = stream.noneMatch(s -> s.length() == 3);
//        System.out.println(b);

        // 11. reduce 方法
        // 作用: 用于对 Stream 流中的数据进行聚合
        // 参数: BinaryOperator 接口, 用于对 Stream 流中的数据进行聚合
        // 返回值: Optional<T>, 聚合后的数据
        // 使用方式: Stream 流对象.reduce(BinaryOperator 接口)
//        Optional<String> reduce = stream.reduce((s1, s2) -> s1 + s2);
//        reduce.ifPresent(System.out::println);

        // 12. toArray 方法
        // 作用: 用于对 Stream 流中的数据进行收集
        // 参数: IntFunction 接口, 用于对 Stream 流中的数据进行收集
        // 返回值: T[], 收集后的数据
        // 使用方式: Stream 流对象.toArray(IntFunction 接口)
//        String[] array = stream.toArray(String[]::new);
//        System.out.println(Arrays.toString(array));

        // 12. toSet 方法
        // 作用: 用于对 Stream 流中的数据进行收集
        // 参数: 无
        // 返回值: Set<T>, 收集后的数据
        // 使用方式: Stream 流对象.toSet()
//        Set<String> set = stream.collect(Collectors.toSet());
//        System.out.println(set);


        // 13. iterator 方法
        // 作用: 用于对 Stream 流中的数据进行遍历
        // 参数: 无
        // 返回值: Iterator<T>, 迭代器
        // 使用方式: Stream 流对象.iterator()
//        Iterator<String> iterator = stream.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // 14. spliterator 方法
        // 作用: 用于对 Stream 流中的数据进行遍历
        // 参数: 无
        // 返回值: Spliterator<T>, 分割迭代器
        // 使用方式: Stream 流对象.spliterator()
//        Spliterator<String> spliterator = stream.spliterator();
//        while (spliterator.tryAdvance(System.out::println)) ;

        // 15. forEachOrdered 方法
        // 作用: 用于对 Stream 流中的数据进行遍历
        // 参数: Consumer 接口, 用于对 Stream 流中的数据进行遍历
        // 返回值: 无
        // 使用方式: Stream 流对象.forEachOrdered(Consumer 接口)
//        stream.forEachOrdered(System.out::println);


    }
}
