package com.feng.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName Demo4_Transaction
 * @Description com.feng.mysql.Demo4_Transaction
 * @Author AsuraTu
 * @Date 2023/5/25 13:52
 * @Version 1.0.0
 */
public class Demo4_Transaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // JDBC 事务
        // 1. 事务: 一组逻辑操作单元, 使数据从一种状态变换到另一种状态
        // 2. 事务处理的原则: 保证所有事务都作为一个工作单元来执行, 即使出现故障, 都不能改变这种执行方式
        // 3. 事务处理的特性: 原子性, 一致性, 隔离性, 持久性
        // 4. MySQL 事务处理主要用于处理操作量大, 需要并发的场景, 通过事务可以保证数据一致性, 防止数据异常
        // 5. 事务的 ACID 属性: 原子性(Atomicity, 或称不可分割性), 一致性(Consistency), 隔离性(Isolation, 又称独立性), 持久性(Durability)

        // 事务的隔离级别
        // 1. 读未提交(Read Uncommitted): 允许脏读, 也就是可能读取到其他会话中未提交事务修改的数据
        // 2. 读提交(Read Committed): 可以读取并发事务已经提交的数据, 可以阻止脏读, 但是不能阻止不可重复读和幻读
        // 3. 可重复读(Repeatable Read): 可以阻止脏读和不可重复读, 但是不能阻止幻读, InnoDB 默认级别
        // 4. 串行化(Serializable): 阻止所有的并发问题, 严重影响性能, 一般不使用

        // 在 JDBC 中使用 Connection 对象来管理事务
        // 1. 开启事务: setAutoCommit(false)
        // 2. 提交事务: commit()
        // 3. 回滚事务: rollback()
        // 4. 事务的隔离级别: setTransactionIsolation(int level)
        // 5. 关闭连接: close()

        // 1. 注册驱动
        //  利用反射将驱动类加载到 JVM 中
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 通过驱动管理对象来获得连接对象
        // 2.1 定义数据库的 url, 用户名, 密码
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clterp?useSSL=false&serverTimezone=UTC", "root", "tu4211241992");

        // 3. 获得执行 sql 的对象
        java.sql.Statement statement = connection.createStatement();

        try {
            // 开启事务
            connection.setAutoCommit(false);

            // 4. 定义 sql
            String sql1 = "update user set balance = balance - 100 where id = 2";
            String sql2 = "update user set balance = balance + 100 where id = 3";

            // 5. 执行 sql
            statement.executeUpdate(sql1);
            // 手动制造异常
//            int i = 3 / 0;
            statement.executeUpdate(sql2);

            // 提交事务
            System.out.println("事务提交");
            connection.commit();
        } catch (Exception e) {
            // 事务回滚
            System.out.println("事务回滚");
            connection.rollback();
        } finally {
            // 6. 释放资源
            statement.close();
            connection.close();
        }


    }
}
