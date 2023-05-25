package com.feng.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName Demo1_update
 * @Description com.feng.mysql.Demo1_update
 * @Author AsuraTu
 * @Date 2023/5/24 16:14
 * @Version 1.0.0
 */
public class Demo1_query {
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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gf-demo-user?useSSL=false&serverTimezone=UTC", "root", "");

        // 3. 获得执行 sql 的对象
        // 3.1 通过连接对象获得执行 sql 的对象
        // 3.2 通过连接对象, 获得可以执行 sql 语句的对象
        // 3.3 Statement: 执行 sql 的对象
        // 3.4 调用 Connection 对象的方法 Statement createStatement() 获取 Statement 对象, 将 sql 语句发送到数据库
        java.sql.Statement statement = connection.createStatement();

        // 4. 执行 sql 语句, 获得结果
        // 4.1 定义 sql 语句
        String sql = "SELECT * FROM `user`";
        System.out.println(sql);

        // 4.2 调用 Statement 对象的方法执行 sql 语句
        // 4.3 int executeUpdate(String sql)  执行数据库中的 sql 语句,  insert, update, delete, ddl 语句
        // 4.4 executeQuery(String sql) 执行数据库中的 sql 语句,  select 语句
        // 4.5 返回值 int, 表示影响的行数
        ResultSet resultSet = statement.executeQuery(sql);

        // 5. 处理结果
        // 5.1 调用 ResultSet 对象的方法 next() 判断是否有下一行数据
        // 5.2 boolean next() 如果有下一行数据, 返回 true, 否则返回 false
        while (resultSet.next()) {
            // 5.3 获取数据
            // 5.4 使用 getInt(int index) 方法获取数据
            // 5.5 使用 getString(String label) 通过列名(或者查询的别名)获取数据, 推荐使用
            // 5.6 index 表示列的编号, 从 1 开始, 从左到右, 从上到下
            int id = resultSet.getInt(1);
            String passport = resultSet.getString(2);
            String password = resultSet.getString(3);
            String nickname = resultSet.getString("nickname"); // 推荐使用
            System.out.println(id + " " + passport + " " + password + " " + nickname);
        }

        // 6. 关流
        // 6.1 释放资源
        // 6.2 先开后关
        resultSet.close();
        statement.close();
        connection.close();
    }
}
