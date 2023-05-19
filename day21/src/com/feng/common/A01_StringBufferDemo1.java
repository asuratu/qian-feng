package com.feng.common;

/**
 * @ClassName A01_StringBufferDemo1
 * @Description com.feng.common.A01_StringBufferDemo1
 * @Author AsuraTu
 * @Date 2023/5/19 09:38
 * @Version 1.0.0
 */
public class A01_StringBufferDemo1 {
    public static void main(String[] args) {
        // StringBuffer 是一个可变的字符序列
        // 线程安全的，效率低
        // StringBuilder 是一个可变的字符序列
        // 线程不安全的，效率高

        // 1. 创建 StringBuffer 对象
        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());

        // 2. 添加数据
        sb1.append("hello");
        sb1.append("world");
        sb1.append("java");
        System.out.println(sb1);

        // 3. 删除数据
        sb1.delete(0, 5);
        System.out.println(sb1);

        // 4. 插入数据
        sb1.insert(0, "hello");
        System.out.println(sb1);

        // 5. 替换数据
        sb1.replace(0, 5, "你好");
        System.out.println(sb1);

        // 6. 反转
        sb1.reverse();
        System.out.println(sb1);

        // 7. 截取
        String str = sb1.substring(0, 2);
        System.out.println(str);

        // 8. 修改
        sb1.setCharAt(0, 'H');
        System.out.println(sb1);

        // 9. 获取
        char ch = sb1.charAt(0);
        System.out.println(ch);

        // 10. 获取长度
        System.out.println(sb1.length());

        // 11. 获取容量
        System.out.println(sb1.capacity());

        // 12. 转换为字符串
        String s = sb1.toString();
        System.out.println(s);

        // 13. 清空
        sb1.delete(0, sb1.length());
        System.out.println(sb1);
    }
}
