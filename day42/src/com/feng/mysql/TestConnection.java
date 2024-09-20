package com.feng.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName TestConnection
 * @Description com.feng.mysql.TestConnection
 * @Author AsuraTu
 * @Date 2023/5/24 15:46
 * @Version 1.0.0
 */
public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clterp?useSSL=false&serverTimezone=UTC", "root", "tu4211241992");

        System.out.println(connection); // com.mysql.cj.jdbc.ConnectionImpl@23faf8f2 代表连接成功

    }
}
