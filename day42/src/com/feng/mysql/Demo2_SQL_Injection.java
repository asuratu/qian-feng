package com.feng.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName Demo2_SQL_Injection
 * @Description com.feng.mysql.Demo2_SQL_Injection
 * @Author AsuraTu
 * @Date 2023/5/24 17:44
 * @Version 1.0.0
 */
public class Demo2_SQL_Injection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // SQL 注入
        // select * from user where passport = '111' and password = '111 ' or '1 = 1'

        // 预编译 sql
        // select * from user where passport = ? and password = ?
        // 1. 获得执行 sql 的对象
        // 2. 获得预编译 sql 的对象
        // 3. 给 ? 赋值
        // 4. 执行 sql

        // 注册驱动
        // 利用反射将驱动类加载到 JVM 中
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 通过驱动管理对象来获得连接对象
        // 定义数据库的 url, 用户名, 密码
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gf-demo-user?useSSL=false&serverTimezone=UTC", "root", "");

        // 获得执行 sql 的对象
        java.sql.Statement statement = connection.createStatement();

        // 预编译 sql
        String sql = "select * from user where passport = ? and password = ?";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 给 ? 赋值
        preparedStatement.setString(1, "admin");
        preparedStatement.setString(2, "123");

        // 执行 sql
        java.sql.ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        // 关流
        resultSet.close();
        preparedStatement.close();
        statement.close();
        connection.close();

    }
}
