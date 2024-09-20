package com.feng.mysql;

import java.sql.*;
import java.util.Scanner;

/**
 * @ClassName Test_Query
 * @Description com.feng.mysql.Test_Query
 * @Author AsuraTu
 * @Date 2023/5/24 16:56
 * @Version 1.0.0
 */
public class Test_Query {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // JDBC编程标准步骤 (八股文)
        // 1. 注册驱动
        // 1.1 将 sql 语句的运行环境加载到 JVM 中
        // 2. 连接数据库
        // 3. 获得执行 sql 的对象
        // 4. 执行 sql 语句, 获得结果
        // 5. 关流

        // 1. 注册驱动
        //  利用反射将驱动类加载到 JVM 中
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 通过驱动管理对象来获得连接对象
        // 2.1 定义数据库的 url, 用户名, 密码
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clterp?useSSL=false&serverTimezone=UTC", "root", "tu4211241992");

        // 3. 获得执行 sql 的对象
        // 3.1 通过连接对象获得执行 sql 的对象
        // 3.2 通过连接对象, 获得可以执行 sql 语句的对象
        // 3.3 Statement: 执行 sql 的对象
        // 3.4 调用 Connection 对象的方法 Statement createStatement() 获取 Statement 对象, 将 sql 语句发送到数据库
        java.sql.Statement statement = connection.createStatement();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            // 请输入 用户名
            System.out.println("请输入用户名:");
            String passport = scanner.nextLine();
            // 请输入 密码
            System.out.println("请输入密码:");
            String password = scanner.nextLine();

            ResultSet login = login(statement, passport, password);

            if (login.next()) {
                login.close();
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("登录失败, 请重新输入");
            }
        }

        statement.close();
        connection.close();
    }

    private static ResultSet login(Statement statement, String passport, String password) throws SQLException {
        String sql = "SELECT * FROM `user` where passport = '" + passport + "' and password = '" + password + "'";
        return statement.executeQuery(sql);
    }


}
