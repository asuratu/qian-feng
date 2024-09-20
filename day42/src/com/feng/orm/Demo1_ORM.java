package com.feng.orm;

import com.feng.orm.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName com.feng.orm.Demo1_ORM
 * @Description PACKAGE_NAME.com.feng.orm.Demo1_ORM
 * @Author AsuraTu
 * @Date 2023/5/25 14:16
 * @Version 1.0.0
 */
public class Demo1_ORM {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // ORM 对象关系映射 (Object Relational Mapping)
        // 通过 java 对象的方式操作数据库中的表, 将表中的一条记录封装成一个 java 对象

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 通过驱动管理对象来获得连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clterp?useSSL=false&serverTimezone=UTC", "root", "tu4211241992");

        // 3. 获得执行 sql 的对象
        java.sql.Statement statement = connection.createStatement();

        // 4. 执行 sql 语句, 获得结果
        String sql = "SELECT * FROM `user` WHERE `id` = 2";
        System.out.println(sql);

        ResultSet resultSet = statement.executeQuery(sql);

        User user = new User();

        // 5. 处理结果
        // 5.1 调用 ResultSet 对象的方法 next() 判断是否有下一行数据
        // 5.2 boolean next() 如果有下一行数据, 返回 true, 否则返回 false
        if (resultSet.next()) {
            // 5.3 获取数据
            user.setId(resultSet.getInt("id"));
            user.setPassport(resultSet.getString("passport"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
            user.setCreateAt(resultSet.getTimestamp("create_at"));
            user.setUpdateAt(resultSet.getTimestamp("update_at"));
            user.setBalance(resultSet.getDouble("balance"));
        }

        System.out.println(user);

        // 6. 关流
        // 6.1 释放资源
        // 6.2 先开后关
        resultSet.close();
        statement.close();
        connection.close();
    }
}
