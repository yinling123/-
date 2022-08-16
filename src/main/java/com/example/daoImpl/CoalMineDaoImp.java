package com.example.daoImpl;

import com.example.dao.BaseDao;
import com.example.dao.CoalMineDao;
import com.example.pojo.CoalMine;
import java.sql.Connection;

public class CoalMineDaoImp extends BaseDao implements CoalMineDao {
    @Override
    public int add(Connection connection, CoalMine coalMine) {
        String sql = "insert into coalmine(`area`,`datetime`,`type`,`length`,`width`) values(?,?,?,?,?)";
        return update(connection,sql,coalMine.getArea(),coalMine.getDatetime(),coalMine.getType(),coalMine.getLength(),coalMine.getWidth());

    }
}
