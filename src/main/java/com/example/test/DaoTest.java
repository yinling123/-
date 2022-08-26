package com.example.test;

import com.example.dao.CoalMineDao;
import com.example.dao.UserDao;
import com.example.daoImpl.CoalMineDaoImp;
import com.example.daoImpl.UserDaoImp;
import com.example.pojo.CoalMine;
import com.example.pojo.User;
import com.example.utils.DruidUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class DaoTest {

//    @Test
//    public void test() throws SQLException {
//        String sql = "insert into coalmine(`area`,`datetime`,`type`,`length`,width) values(?,?,?,?,?)";
//        Object[] objects = new Object[]{1,"2022-11-22 21:23:22",1,"22",1};
//
//        final int update = BaseDao.update(sql, objects);
//        System.out.println(update);
//    }
//
//    @Test
//    public void delete() throws SQLException {
//        String sql = "delete from coalmine";
//        Object[] objects = new Object[0];
//
//        //格式符合要求即可
//        final int update = BaseDao.update(sql, objects);
//        System.out.println(update);
//    }
//
//    @Test
//    public void query() throws SQLException, NoSuchFieldException, IllegalAccessException, InstantiationException {
//        String sql = "select * from coalmine";
//        Object[] objects = new Object[0];
//        final List query = BaseDao.query(sql, objects);
//        System.out.println(query);
//    }
    @Test
    public void testAdd(){
        Connection connection = DruidUtils.getConnection();
        UserDao userDao = new UserDaoImp();
        if(userDao.addUer(connection,new User("1","2","ds")) == 0){
            System.out.println("注册失败");
        }else{
            System.out.println("注册成功");
        }
        DruidUtils.close(connection,null,null);
    }

    @Test
    public void testDelete(){
        final Connection connection = DruidUtils.getConnection();
        UserDao userDao = new UserDaoImp();
        if(userDao.deleteUserById(connection,"1") == 0){
            System.out.println("删除失败");
        }else{
            System.out.println("删除成功");
        }
        DruidUtils.close(connection,null,null);
    }

//    @Test
//    public void testUpdate(){
//        final Connection connection = DruidUtils.getConnection();
//        UserDao userDao = new UserDaoImp();
//        if(userDao.updateUser(connection,new User("1","3","dad")) == 0){
//            System.out.println("修改失败");
//        }else{
//            System.out.println("修改成功");
//        }
//        DruidUtils.close(connection,null,null);
//    }

    @Test
    public void testQuery(){
        final Connection connection = DruidUtils.getConnection();
        UserDao userDao = new UserDaoImp();
        List<User> list = userDao.queryUsers(connection,"1");
        if(list.size() == 0){
            System.out.println("未查询到");
        }else{
            System.out.println(list);
        }
        DruidUtils.close(connection,null,null);
    }

    @Test
    public void testCoalMine(){
        Connection connection = DruidUtils.getConnection();
        CoalMineDao coalMineDao = new CoalMineDaoImp();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        final CoalMine coalMine = new CoalMine(1, new Timestamp(date.getTime()), "煤流", 23, 22);
        coalMineDao.add(connection,coalMine);
        DruidUtils.close(connection,null,null);
    }
}
