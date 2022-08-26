package com.example.dao;

import com.example.pojo.CoalMine;

import java.sql.Connection;
import java.util.List;

/**
 * 设置针对Coal数据表的应用操作
 */

public interface CoalMineDao {

    /**
     * 数据表中插入数据
     * @param connection
     * @param coalMine
     * @return
     */
    public int add(Connection connection, CoalMine coalMine);


    /**
     * 获取全部数据
     * @return
     */
    public List<CoalMine> queryCoals(Connection connection);

    /**
     * 统计数目
     * @return
     */
    public int getAccount(Connection connection);


}
