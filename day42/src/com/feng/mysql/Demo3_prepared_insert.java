package com.feng.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName Demo3_prepared_insert
 * @Description com.feng.mysql.Demo3_prepared_insert
 * @Author AsuraTu
 * @Date 2023/5/25 13:10
 * @Version 1.0.0
 */
public class Demo3_prepared_insert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        // 利用反射将驱动类加载到 JVM 中
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 通过驱动管理对象来获得连接对象
        // 定义数据库的 url, 用户名, 密码
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clterp?useSSL=false&serverTimezone=UTC", "root", "tu4211241992");

        // 获得执行 sql 的对象
        java.sql.Statement statement = connection.createStatement();

        // 预编译 sql
        String sql = "INSERT INTO `user` (`passport`, `password`, `nickname`, `create_at`, `update_at`) VALUES (?, ? , ?, ?, ?)";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 给 ? 赋值
        preparedStatement.setString(1, "user5");
        preparedStatement.setString(2, "123");
        preparedStatement.setString(3, "张三5");
        preparedStatement.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()), java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Shanghai")));
        preparedStatement.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()), java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Shanghai")));

        // 执行 sql
        int i = preparedStatement.executeUpdate();

        System.out.println("影响的行数: " + i);

        // 关流
        preparedStatement.close();
        statement.close();
        connection.close();
    }
}
