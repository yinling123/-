package com.example.service.impl;

import com.example.dao.ManagerDao;
import com.example.daoImpl.ManagerDaoImp;
import com.example.pojo.Manager;
import com.example.pojo.User;
import com.example.service.ManagerService;
import com.example.utils.DruidUtils;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * manager的业务层接口实现类
 */

public class ManagerServiceImpl implements ManagerService {

    //设置公共对象
    ManagerDao managerDao = new ManagerDaoImp();

    @Override
    public int update(Manager manager) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行操作
        int i = managerDao.updateManagerPassword(connection, manager);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回对应值
        return i;
    }

    @Override
    public List<User> listUsers() {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行对应操作
        List<User> list = managerDao.queryUsers(connection);
        //关闭连接
        DruidUtils.close(connection,null,null);
        return list;
    }

    @Override
    public List<User> listUser(String username) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行对应操作
        User user = managerDao.queryUser(connection, username);
        //创建链表并且进行存储
        LinkedList<User> users = new LinkedList<>();
        users.add(user);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回对应集合
        return users;
    }

    @Override
    public int Update(User user) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行对应操作
        int i = managerDao.updateUserPassword(connection, user);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回操作结果
        return i;
    }

    @Override
    public Manager login(Manager manager) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行查询操作并且获取对象
        Manager manager1 = managerDao.queryManager(connection, manager.username);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回对象
        return manager1;
    }
}
