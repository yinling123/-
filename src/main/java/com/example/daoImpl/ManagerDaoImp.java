package com.example.daoImpl;

import com.example.dao.BaseDao;
import com.example.dao.ManagerDao;
import com.example.pojo.Manager;
import com.example.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * manager的表的接口实现类
 */

public class ManagerDaoImp extends BaseDao implements ManagerDao{

    @Override
    public int addUer(Connection connection, User user) {
        String sql = "insert into users values(?,?,?)";
        return update(connection,sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public int deleteUserById(Connection connection, String username) {
        String sql = "delete from users where username = ?";
        return update(connection,sql,username);
    }

    @Override
    public int updateUserPassword(Connection connection, User user) {
        String sql = "update users set password = ? where username = ?";
        return update(connection,sql,user.getPassword(),user.getUsername());
    }

    @Override
    public Manager queryManager(Connection connection, String username) {
        String sql = "select * from managers where username = ?";
        return queryOne(connection,Manager.class,sql,username);
    }

    @Override
    public int addManager(Connection connection, Manager manager) {
        String sql = "insert into managers values(?,?,?)";
        return update(connection,sql,manager.getUsername(),manager.getPassword(),manager.getEmail());
    }

    @Override
    public int deleteManager(Connection connection, String username) {
        String sql = "delete from managers where username = ?";
        return update(connection,sql,username);
    }

    @Override
    public int updateManagerPassword(Connection connection, Manager manager) {
        String sql = "update users set password = ? where username = ?";
        return update(connection,sql,manager.getPassword(),manager.getUsername());
    }

    @Override
    public List<User> queryUsers(Connection connection) {
        String sql = "select * from users";
        return query(connection,User.class,sql,new Object[0]);
    }

    @Override
    public User queryUser(Connection connection, String username) {
        String sql = "select * from users where username = ?";
        return queryOne(connection,User.class,sql,username);
    }
}
