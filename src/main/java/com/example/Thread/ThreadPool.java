package com.example.Thread;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.dao.CoalMineDao;
import com.example.daoImpl.CoalMineDaoImp;
import com.example.pojo.Analysis;
import com.example.pojo.CoalMine;
import com.example.utils.*;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.FrameRecorder;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置线程池进行同时检测
 */

@SuppressWarnings("all")
public class ThreadPool {

    //创建线程池
    static ExecutorService executorService = Executors.newFixedThreadPool(8);
    //设置线程结束标识
    public static boolean end1 = false;
    static boolean end2;
    static boolean end3;
    static boolean end4;

    //启动第一线程
    public static void startOne(){
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //获取数据库连接
                    Connection connection = DruidUtils.getConnection();
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    if(analyzing != null){
                        CoalMine coalMine = new CoalMine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                        //将解析值存入数据库
                        coalMineDao.add(connection,coalMine);
                    }
                    //关闭数据库连接
                    DruidUtils.close(connection,null,null);
                }
                //将识别的视频进行保存
                try {
                    Util.pic2MovByFfmpeg("D:\\CoalImage\\meiliutest.mp4",16,10);
                } catch (FFmpegFrameRecorder.Exception e) {
                    e.printStackTrace();
                }
                //运行完毕，关闭线程池
                executorService.shutdown();
            }

        });
    }

    //关闭第一线程
    public static void closeOne(){
        end1 = false;
    }

    //启动第二线程
    public static void startTwo(){
        //设置启动
        end1 = true;
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //获取数据库连接
                    Connection connection = DruidUtils.getConnection();
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    CoalMine coalMine = new CoalMine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                    System.out.println(coalMine);
                    //将解析值存入数据库
                    coalMineDao.add(connection,coalMine);
                    //关闭数据库连接
                    DruidUtils.close(connection,null,null);
                }
            }
        });
    }

    //关闭第二线程
    public static void closeTwo(){
        end2 = false;
    }

    //启动第三线程
    public static void startThree(){
        //设置启动
        end1 = true;
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //获取数据库连接
                    Connection connection = DruidUtils.getConnection();
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    CoalMine coalMine = new CoalMine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                    System.out.println(coalMine);
                    //将解析值存入数据库
                    coalMineDao.add(connection,coalMine);
                    //关闭数据库连接
                    DruidUtils.close(connection,null,null);
                }
            }
        });
    }

    //关闭第三线程
    public static void closeThree(){
        end3 = false;
    }

    //启动第四线程
    public static void startFour(){
        //设置启动
        //设置启动
        end1 = true;
        //创建接口实现对象
        CoalMineDao coalMineDao = new CoalMineDaoImp();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while(FrameBlocking.frameCompletion == false){
                    //获取数据库连接
                    Connection connection = DruidUtils.getConnection();
                    //接口和本地图片暂代填充
                    String s = EasyDl.doPostFile("http://127.0.0.1:24401/", "D:\\CoalImage\\coal@.jpg");
                    //获取元素对应值
                    Analysis analyzing = Analyzing.analyzing(s);
                    CoalMine coalMine = new CoalMine(1,Util.getCurrentTime(),analyzing.getType(),analyzing.getLength(),analyzing.getWidth());
                    System.out.println(coalMine);
                    //将解析值存入数据库
                    coalMineDao.add(connection,coalMine);
                    //关闭数据库连接
                    DruidUtils.close(connection,null,null);
                }
            }
        });
    }

    //关闭第四线程
    public static void closeFour(){
        end4 = false;
    }

    //开启线程进行视频分帧
    public static void startFrame(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                FrameBlocking frameBlocking = new FrameBlocking();
                frameBlocking.framing("D:\\CoalImage\\meiliu.mp4","coal","D:\\CoalImage");
            }
        });
    }

}
