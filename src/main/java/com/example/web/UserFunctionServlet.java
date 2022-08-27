package com.example.web;

import com.example.utils.RealDetect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户界面对应功能的实现类
 */

public class UserFunctionServlet extends BaseServlet{

    /**
     * 进行上传的图片检测
     * @param req
     * @param resp
     */
    public void photoChecked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行图片检测
        RealDetect.detectPhoto();
        //将解析完图片位置存入
        req.setAttribute("url","D:\\CoalImage\\coal@1.jpg");
        //进行页面跳转
        req.getRequestDispatcher("/pages/coalMine/photoCheck.jsp").forward(req,resp);
    }


    /**
     * 进行视频检测
     * @param req
     * @param resp
     */
    public void videoChecked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转到视频检测页面
        req.getRequestDispatcher("/pages/coalMine/coal.jsp").forward(req,resp);
    }

    /**
     * 进行颜色修改后跳转回原页面
     * @param req
     * @param resp
     */
    public void colorSet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转回原页面
        req.getRequestDispatcher("/pages/user/userControl.jsp").forward(req,resp);
    }

    /**
     * 用于进行账号设置
     * @param req
     * @param resp
     */
    public void accountSet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //跳转回页面
        req.getRequestDispatcher("/pages/user/userControl.jsp").forward(req,resp);
    }

    /**
     * 进行检测视频页面跳转回
     * @param req
     * @param resp
     */
    public void checkSet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/coalMine/coal.jsp").forward(req,resp);
    }


}
