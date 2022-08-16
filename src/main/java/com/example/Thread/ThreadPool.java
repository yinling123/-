package com.example.Thread;

import com.example.dao.CoalMineDao;
import com.example.daoImpl.CoalMineDaoImp;
import com.example.pojo.Analysis;
import com.example.pojo.CoalMine;
import com.example.utils.Analyzing;
import com.example.utils.DruidUtils;
import com.example.utils.EasyDl;
import com.example.utils.Util;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置线程池进行同时检测
 */

@SuppressWarnings("all")
public class ThreadPool {

    //创建线程池
    static ExecutorService executorService = Executors.newFixedThreadPool(6);
    //设置线程结束标识
    static boolean end1;
    static boolean end2;
    static boolean end3;
    static boolean end4;

    //启动第一线程
    public static void startOne(){
        //设置启动
        end1 = true;
        //获取数据库连接
        Connection connection = DruidUtils.getConnection();
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        while(end1){
            //接口和本地图片暂代填充
            String s = EasyDl.doPostFile("", "");
            //获取元素对应值
            Analysis analyzing = Analyzing.analyzing(s);
            final CoalMine coalMine = new CoalMine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
            //将解析值存入数据库
            coalMineDao.add(connection,coalMine);
        }

        //关闭数据库连接
        DruidUtils.close(connection,null,null);
    }

    //关闭第一线程
    public static void closeOne(){
        end1 = false;
    }

    //启动第二线程
    public static void startTwo(){
        //设置启动
        end2 = true;
        //获取数据库连接
        Connection connection = DruidUtils.getConnection();
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        while(end2){
            //接口和本地图片暂代填充
            String s = EasyDl.doPostFile("", "");
            //获取元素对应值
            Analysis analyzing = Analyzing.analyzing(s);
            final CoalMine coalMine = new CoalMine(2,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
            //将解析值存入数据库
            coalMineDao.add(connection,coalMine);
        }

        //关闭数据库连接
        DruidUtils.close(connection,null,null);
    }

    //关闭第二线程
    public static void closeTwo(){
        end2 = false;
    }

    //启动第三线程
    public static void startThree(){
        //设置启动
        end3 = true;
        //获取数据库连接
        Connection connection = DruidUtils.getConnection();
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        while(end3){
            //接口和本地图片暂代填充
            String s = EasyDl.doPostFile("", "");
            //获取元素对应值
            Analysis analyzing = Analyzing.analyzing(s);
            final CoalMine coalMine = new CoalMine(3,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
            //将解析值存入数据库
            coalMineDao.add(connection,coalMine);
        }

        //关闭数据库连接
        DruidUtils.close(connection,null,null);
    }

    //关闭第三线程
    public static void closeThree(){
        end3 = false;
    }

    //启动第四线程
    public static void startFour(){
        //设置启动
        end4 = true;
        //获取数据库连接
        Connection connection = DruidUtils.getConnection();
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        while(end4){
            //接口和本地图片暂代填充
            String s = EasyDl.doPostFile("", "");
            //获取元素对应值
            Analysis analyzing = Analyzing.analyzing(s);
            final CoalMine coalMine = new CoalMine(4,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
            //将解析值存入数据库
            coalMineDao.add(connection,coalMine);
        }

        //关闭数据库连接
        DruidUtils.close(connection,null,null);
    }

    //关闭第四线程
    public static void closeFour(){
        end4 = false;
    }

}
