package com.example.dao;

import com.example.pojo.Manager;
import com.example.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * 设置管理员对于managers表的一系列操作
 */

public interface ManagerDao {

    /**
     * 增加管理员
     * @param connection
     * @param manager
     */
    public int addManager(Connection connection, Manager manager);


    /**
     * 删除管理员
     * @param connection
     * @param username
     */
    public int deleteManager(Connection connection,String username);


    /**
     * 修改密码
     */
    public int updateManagerPassword(Connection connection,Manager manager);


    /**
     * 查询用户数据，返回集合
     * @param connection
     * @return
     */
    public List<User> queryUsers(Connection connection);



    /**
     * 查询用户数据，返回个人信息
     * @param connection
     * @param username
     * @return
     */
    public User queryUser(Connection connection,String username);

    /**
     * 增加User表中数据
     * @param connection
     * @param user
     * @return
     */
    public int addUer(Connection connection,User user);

    /**
     * 通过用户名删除用户数据删除用户数据
     * @param connection
     * @param username
     * @return
     */
    public int deleteUserById(Connection connection,String username);

    /**
     * 修改用户密码
     * @param connection
     * @param user
     * @return
     */
    public int updateUserPassword(Connection connection,User user);


    /**
     * 进行查询管理员操作
     * @param username
     * @return
     */
    public Manager queryManager(Connection connection,String username);
}
