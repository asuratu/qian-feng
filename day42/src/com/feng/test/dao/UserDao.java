package com.feng.test.dao;

import com.feng.test.model.User;
import com.feng.util.DBUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @ClassName UserDao
 * @Description com.feng.test.dao.UserDao
 * @Author AsuraTu
 * @Date 2023/5/25 16:20
 * @Version 1.0.0
 */
public class UserDao {
    public static User getUserById(Integer id) {
        // 1. 获得连接
        Connection connection = DBUtil.getConnection();

        User user = null;

        Statement statement = null;
        try {
            // 2. 获得执行 sql 的对象
            // 获得执行 sql 的对象
            statement = connection.createStatement();
            // 3.预编译 sql
            String sql = "select * from user where id = ?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 4.给 ? 赋值
            preparedStatement.setInt(1, id);

            // 执行 sql
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // 5.处理结果集
                user = new User();
                setUserAttribute(user, resultSet);

//                user.setId(resultSet.getInt("id"));
//                user.setPassport(resultSet.getString("passport"));
//                user.setPassword(resultSet.getString("password"));
//                user.setNickname(resultSet.getString("nickname"));
//                user.setCreateAt(resultSet.getTimestamp("create_at"));
//                user.setUpdateAt(resultSet.getTimestamp("update_at"));
//                user.setBalance(resultSet.getDouble("balance"));
            }

            DBUtil.close(resultSet, preparedStatement);
        } catch (SQLException e) {
            System.out.println("获得执行 sql 的对象失败");
            throw new RuntimeException(e);
        } finally {
            // 关流
            DBUtil.close(statement, connection);
        }

        return user;
    }

    private static void setUserAttribute(User user, ResultSet resultSet) {
        // 获取 user 的字节码文件
        Class<? extends User> userClass = user.getClass();
        // 获取 user 的所有属性
        Field[] files = userClass.getDeclaredFields();
        System.out.println(Arrays.toString(files));
        // 遍历属性
        for (Field file : files) {
            // 设置属性可访问
            file.setAccessible(true);
            // 获取属性名
            String name = file.getName();
            // 小驼峰转下划线
            name = name.replaceAll("([A-Z])", "_$1").toLowerCase();

            // 获取属性值
            try {
                Object value = resultSet.getObject(name);

                System.out.println("original value: " + value);

                // 如果是 Long 类型，转换成 Integer 类型
                if (value instanceof Long) {
                    value = ((Long) value).intValue();
                }

                // 如果是 LocalDateTime 类型，转换成 java.util.Date 类型
                if (value instanceof LocalDateTime) {
                    System.out.println("LocalDateTime: " + value);
                    // 转换成 java.util.Date 类型
                    value = java.util.Date.from(((LocalDateTime) value).atZone(java.time.ZoneId.systemDefault()).toInstant());
                }

                // java.math.BigDecimal to java.lang.Double
                if (value instanceof java.math.BigDecimal) {
                    System.out.println("java.math.BigDecimal: " + value);
                    value = ((java.math.BigDecimal) value).doubleValue();
                }

                // 给属性赋值
                file.set(user, value);
            } catch (IllegalAccessException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int createUser(User user) {
        // 1. 获得连接
        Connection connection = DBUtil.getConnection();

        Statement statement = null;

        int i = 0;

        try {
            // 2. 获得执行 sql 的对象
            // 获得执行 sql 的对象
            statement = connection.createStatement();
            // 3.预编译 sql
            String sql = "insert into user (passport, password, nickname, create_at, update_at, balance) values (?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 4.给 ? 赋值
            preparedStatement.setString(1, user.getPassport());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNickname());
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(user.getCreateAt().getTime()), java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Shanghai")));
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(user.getUpdateAt().getTime()), java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Shanghai")));
            preparedStatement.setDouble(6, user.getBalance());

            // 执行 sql
            i = preparedStatement.executeUpdate();

            DBUtil.close(preparedStatement);
        } catch (SQLException e) {
            System.out.println("执行 sql 的对象失败");
            throw new RuntimeException(e);
        } finally {
            // 关流
            DBUtil.close(statement, connection);
        }

        return i;
    }

    public static int updateUser(User user) {
        // 1. 获得连接
        Connection connection = DBUtil.getConnection();

        Statement statement = null;

        int i = 0;

        try {
            // 2. 获得执行 sql 的对象
            // 获得执行 sql 的对象
            statement = connection.createStatement();
            // 3.预编译 sql
            String sql = "update user set passport = ?, password = ?, nickname = ?, create_at = ?, update_at = ?, balance = ? where id = ?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 4.给 ? 赋值
            preparedStatement.setString(1, user.getPassport());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNickname());
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(user.getCreateAt().getTime()), java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Shanghai")));
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(user.getUpdateAt().getTime()), java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Shanghai")));
            preparedStatement.setDouble(6, user.getBalance());
            preparedStatement.setInt(7, user.getId());

            // 执行 sql
            i = preparedStatement.executeUpdate();

            DBUtil.close(preparedStatement);
        } catch (SQLException e) {
            System.out.println("执行 sql 的对象失败");
            throw new RuntimeException(e);
        } finally {
            // 关流
            DBUtil.close(statement, connection);
        }

        return i;
    }

    public static int deleteUserById(Integer id) {
        // 1. 获得连接
        Connection connection = DBUtil.getConnection();

        Statement statement = null;

        int i = 0;

        try {
            // 2. 获得执行 sql 的对象
            // 获得执行 sql 的对象
            statement = connection.createStatement();
            // 3.预编译 sql
            String sql = "delete from user where id = ?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 4.给 ? 赋值
            preparedStatement.setInt(1, id);

            // 执行 sql
            i = preparedStatement.executeUpdate();

            DBUtil.close(preparedStatement);
        } catch (SQLException e) {
            System.out.println("执行 sql 的对象失败");
            throw new RuntimeException(e);
        } finally {
            // 关流
            DBUtil.close(statement, connection);
        }

        return i;
    }


}
