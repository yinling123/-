package com.example.service;


import com.example.pojo.Manager;
import com.example.pojo.User;

import java.util.List;

/**
 * 标注manager在service层需要进行的操作
 */
public interface ManagerService {

    /**
     * 修改管理员的密码
     * @param manager
     * @return  返回值为0时代表返回失败
     */
    public int update(Manager manager);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> listUsers();


    /**
     * 查询特定用户
     * @param username
     * @return
     */
    public List<User> listUser(String username);


    /**
     * 修改用户信息
     * @param user
     * @return 返回值为0时表示修改失败
     */
    public int Update(User user);


    /**
     * 进行管理员的登录检验
     * @param manager
     * @return
     */
    public Manager login(Manager manager);
}
