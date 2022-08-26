package com.example.service;

import com.example.pojo.CoalMine;

import java.util.List;

/**
 * 表示coal数据表的业务处理方法接口
 */

public interface CoalService {

    /**
     * 返回所有检测的煤石信息
     * @return
     */
    public List<CoalMine> getCoalList();


    /**
     * 获取从视频开始到结束时每隔十分钟的煤矿石头数目
     * @return
     */
    public int getTenAccount();

}
