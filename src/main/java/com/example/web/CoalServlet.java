package com.example.web;

import com.alibaba.fastjson.JSON;
import com.example.Thread.ThreadPool;
import com.example.pojo.CoalMine;
import com.example.service.CoalService;
import com.example.service.impl.CoalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 该类用于进行coal页面操作
 */

public class CoalServlet extends BaseServlet{

    //创建公共对象
    CoalService coalService = new CoalServiceImpl();

    /**
     * 进行数据更新，返回日志数据
     * @param req
     * @param resp
     */
    public void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取对应数据
        List<CoalMine> coalList = coalService.getCoalList();
        String string = JSON.toJSONString(coalList);
//        System.out.println(string);
        //进行数据存储
        req.setAttribute("string",string);
        //进行请求转发
        //页面待填入
        req.getRequestDispatcher("/pages/coalMine/dailyRecord.jsp").forward(req,resp);
    }

    /**
     * 获取检验十分钟的总数目
     * @param req
     * @param resp
     */
    public void getAccount(HttpServletRequest req, HttpServletResponse resp){
        //获取对应数据
        int tenAccount = coalService.getTenAccount();
        //进行数据存储
        req.setAttribute("tenAccount",tenAccount);
        //返回原页面
        req.getRequestDispatcher("/pages/coalMine/coal.jsp");
    }


    /**
     * 进行检测并存入对应视频
     * @param req
     * @param resp
     */
    public void startCheckOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //开启线程进行分帧和检测
//        ThreadPool.startFrame();
//        ThreadPool.startOne();

        //存储生成的视频路径
        req.setAttribute("video","D:\\CoalImage\\meiliutest.mp4");
        req.setAttribute("start",true);

        //进行请求转发
        req.getRequestDispatcher("/pages/coalMine/coal.jsp").forward(req,resp);
    }

    public void toBarChart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行页面跳转
        req.getRequestDispatcher("/pages/coalMine/barChart.jsp").forward(req,resp);
    }



}
