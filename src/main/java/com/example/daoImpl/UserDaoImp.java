package com.example.daoImpl;

import com.example.dao.BaseDao;
import com.example.dao.UserDao;
import com.example.pojo.User;

import java.sql.Connection;
import java.util.List;

/**
 * userDao类的实现类，用于完成对user表的基本数据操作
 */

public class UserDaoImp extends BaseDao implements UserDao {

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
    public List<User> queryUsers(Connection connection, String username) {
        String sql = "select * from users where username = ?";
        return query(connection,User.class,sql,username);
    }

    @Override
    public User queryUser(Connection connection, String username) {
        String sql = "select * from users where username = ?";
        return queryOne(connection,User.class,sql,username);
    }


}
