package com.feng.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName DBUtil
 * @Description com.feng.util.DBUtil
 * @Author AsuraTu
 * @Date 2023/5/25 14:54
 * @Version 1.0.0
 */
public class DBUtil {
    // 专门用来操作 properties 文件的工具类
    private static final Properties PROPERTIES = new Properties();

    // 声明 Druid 连接池对象
    // 数据连接, 一般都称作数据源, data source
    private static DruidDataSource druidDataSource = new DruidDataSource();


    // 静态代码块, 在类加载的时候执行
    // 静态修饰的类, 属性, 方法, 在内存中只有一份

    static {
        // 通过反射获取字节码文件
        // 再通过字节码文件将 properties 文件读取成流
        // 此处的路径是 src 目录下的路径, 以 / 开头
        InputStream inputStream = DBUtil.class.getResourceAsStream("/jdbc.properties");
        try {
            // 通过流将 properties 文件加载到内存中
            PROPERTIES.load(inputStream);
//            // 注册驱动 (druid 会自动注册驱动)
//            Class.forName(PROPERTIES.getProperty("driverClass"));

            // 设置连接池的连接信息
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(PROPERTIES);

        } catch (Exception e) {
            System.out.println("加载 properties 文件失败");
//            System.out.println("注册驱动失败");

            e.printStackTrace();
        }
    }

    // 获得连接
    public static Connection getConnection() {
        try {
//            return DriverManager.getConnection(
//                    PROPERTIES.getProperty("url"),
//                    PROPERTIES.getProperty("username"),
//                    PROPERTIES.getProperty("password")
//            );
            // 通过 druid 获得连接
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("获得连接失败");
            throw new RuntimeException(e);
        }
    }

    // 关流
    public static void close(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                System.out.println("关流失败");
                e.printStackTrace();
            }
        }
    }


}
