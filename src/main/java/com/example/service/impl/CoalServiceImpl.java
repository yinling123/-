package com.example.service.impl;

import com.example.dao.CoalMineDao;
import com.example.daoImpl.CoalMineDaoImp;
import com.example.pojo.CoalMine;
import com.example.service.CoalService;
import com.example.utils.DruidUtils;

import java.sql.Connection;
import java.util.List;

public class CoalServiceImpl implements CoalService {
    //创建公共对象
    CoalMineDao coalMineDao = new CoalMineDaoImp();

    @Override
    public List<CoalMine> getCoalList() {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行数据处理
        List<CoalMine> list = coalMineDao.queryCoals(connection);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回对象
        return list;
    }

    @Override
    public int getTenAccount() {
        //获取连接
        Connection connection = DruidUtils.getConnection();
        //进行数据处理
        int account = coalMineDao.getAccount(connection);
        //关闭连接
        DruidUtils.close(connection,null,null);
        //返回数据
        return account;
    }
}
