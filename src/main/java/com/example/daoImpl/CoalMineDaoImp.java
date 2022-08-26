package com.example.daoImpl;

import com.example.dao.BaseDao;
import com.example.dao.CoalMineDao;
import com.example.pojo.CoalMine;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class CoalMineDaoImp extends BaseDao implements CoalMineDao {
    @Override
    public int add(Connection connection, CoalMine coalMine) {
        String sql = "insert into coalmine(`area`,`datetime`,`type`,`length`,`width`) values(?,?,?,?,?)";
        return update(connection,sql,coalMine.getArea(),coalMine.getDatetime(),coalMine.getType(),coalMine.getLength(),coalMine.getWidth());

    }

    @Override
    public List<CoalMine> queryCoals(Connection connection) {
        String sql = "select * from coalmine";
        return query(connection,CoalMine.class,sql,new Object[0]);
    }

    @Override
    public int getAccount(Connection connection) {
        //获取当前时间
        String sql = "SELECT * FROM coalmine WHERE `datetime` > DATE_SUB(NOW(),INTERVAL 10 MINUTE);";
        List<CoalMine> list = query(connection,CoalMine.class,sql,new Object[0]);
        return list.size();
    }
}
