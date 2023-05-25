package com.feng.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName Insert
 * @Description com.feng.util.Insert
 * @Author AsuraTu
 * @Date 2023/5/25 15:15
 * @Version 1.0.0
 */
public class Insert {
    public static void main(String[] args) {
        // 1. 获得连接
        Connection connection = DBUtil.getConnection();

        Statement statement = null;
        try {
            // 2. 获得执行 sql 的对象
            // 获得执行 sql 的对象
            statement = connection.createStatement();
            // 3.预编译 sql
            String sql = "select * from user where passport = ? and password = ?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 4.给 ? 赋值
            preparedStatement.setString(1, "admin");
            preparedStatement.setString(2, "123");

            // 执行 sql
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }

            DBUtil.close(resultSet, preparedStatement);
        } catch (SQLException e) {
            System.out.println("获得执行 sql 的对象失败");
            throw new RuntimeException(e);
        } finally {
            // 关流
            DBUtil.close(statement, connection);
        }


    }
}
