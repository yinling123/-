package com.example.dao;

import com.example.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * 针对用户表进行的操作
 */

public interface UserDao {

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
     * 查询用户数据，返回集合
     * @param connection
     * @param username
     * @return
     */
    public List<User> queryUsers(Connection connection,String username);


    /**
     * 查询用户数据，返回个人信息
     * @param connection
     * @param username
     * @return
     */
    public User queryUser(Connection connection,String username,String password);



    public User query1(Connection connection, String username);
}
