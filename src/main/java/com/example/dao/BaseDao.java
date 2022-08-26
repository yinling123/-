package com.example.dao;

import com.example.pojo.CoalMine;
import com.example.utils.DruidUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 数据库通用基本功能实现类
 */

public abstract class BaseDao{

    /**
     * 作用为进行通用的增删改操作
     * @param connection 传入外部连接，方便进行后续操作
     * @param sql 传入sql语句
     * @param objects 串入对应的占位符值
     */
    public int update(Connection connection,String sql,Object ... objects) {
        //进行预编译
        PreparedStatement preparedStatement = null;
        int k = 0;
        try {
            System.out.println(1111);
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            int len = objects.length;
            for (int i = 0; i < len; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
                System.out.println(objects[i]);
            }
            //进行执行
            k = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DruidUtils.close(null,preparedStatement,null);
        }
        return k;
    }

    /**
     * 调用泛型方法查询表中所有字段构成的多条记录
     * @param connection 传入外部连接，方便进行后续操作
     * @param sql 传入sql语句
     * @param objects 传入占位符的值
     * @return
     * @throws SQLException
     */
    public <T> List<T> query(Connection connection,Class<T> tClass,String sql, Object ... objects)  {
        //进行预编译
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            //填充占位符
            int len = objects.length;
            for(int i = 0; i < len; i++){
                preparedStatement.setObject(i + 1,objects[i]);
            }

            //生成结果集和元数据
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            //求出对应的字段列数
            int columnCount = metaData.getColumnCount();

            //进行循环获取对应的值
            list = new LinkedList<>();
            while(resultSet.next()){
                T t = tClass.newInstance();
                for(int i = 0; i < columnCount; i++){
                    //获取对应的值
                    Object object = resultSet.getObject(i + 1);
                    //获取对应的字段名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //利用反射进行对象赋值
                    Field declaredField = tClass.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,object);
                }
                list.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(null,preparedStatement,resultSet);
        }
        return list;
    }


    /**
     * 调用泛型方法返回单个数据的查询值
     * @param connection
     * @param tClass
     * @param sql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> T queryOne(Connection connection,Class<T> tClass,String sql, Object ... objects)  {
        //进行预编译
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        T list = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            //填充占位符
            int len = objects.length;
            for(int i = 0; i < len; i++){
                preparedStatement.setObject(i + 1,objects[i]);
            }

            //生成结果集和元数据
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            //求出对应的字段列数
            int columnCount = metaData.getColumnCount();

            //进行循环获取对应的值
            while(resultSet.next()){
                list = tClass.newInstance();
                for(int i = 0; i < columnCount; i++){
                    //获取对应的值
                    Object object = resultSet.getObject(i + 1);
                    //获取对应的字段名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //利用反射进行对象赋值
                    Field declaredField = tClass.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(list,object);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(null,preparedStatement,resultSet);
        }
        return list;
    }


}
