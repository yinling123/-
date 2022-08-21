package com.example.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 德鲁伊连接池工具类
 */

public class DruidUtils {

    //公共连接池
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\projectTest\\demo\\src\\main\\java\\com\\example\\utils\\druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection(){

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    //断开连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            DbUtils.close(statement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DbUtils.close(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DbUtils.close(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
