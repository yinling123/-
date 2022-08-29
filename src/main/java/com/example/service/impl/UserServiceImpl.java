package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.daoImpl.UserDaoImp;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.DruidUtils;
import java.sql.Connection;
import java.util.List;

/**
 * 该类用于实现关于用户登录注册的功能
 */

public class UserServiceImpl implements UserService {

    //创建共有对象
    UserDao userDao = new UserDaoImp();

    @Override
    public int Update(User user) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //调用数据库方法
        int i = userDao.updateUserPassword(connection, user);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回参数值
        return i;
    }

    @Override
    public void registerUser(User user) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //调用数据库方法进行处理
        userDao.addUer(connection,user);
        //关闭连接
        DruidUtils.close(connection,null,null);
    }

    @Override
    public User login(User user) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //调用数据库方法进行对应的操作
        User user1 = userDao.queryUser(connection,user.getUsername(),user.getPassword());
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回值
        return user1;
    }

    @Override
    public boolean existsUsername(String username) {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //调用数据库方法进行查询
        final List<User> list = userDao.queryUsers(connection, username);
        //进行对应的判断
        if(list == null){
            return false;
        }
        return true;
    }
}
