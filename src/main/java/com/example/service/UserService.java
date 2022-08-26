package com.example.service;

import com.example.pojo.User;

/**
 * 该接口用于确定User的service层需要完成的功能
 */

public interface UserService {

    /**
     * 进行用户注册
     * @param user
     */
    public void registerUser(User user);


    /**
     * 进行用户登录
     * @param user
     * @return 返回null时表明登录失败
     */
    public User login(User user);


    /**
     * 检测用户名是否可用
     * @param username
     * @return 返回true时表示用户名已经存在
     */
    public boolean existsUsername(String username);
}
