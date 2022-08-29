package com.example.web;

import com.example.dao.UserDao;
import com.example.daoImpl.UserDaoImp;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.RealDetect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户界面对应功能的实现类
 */

@SuppressWarnings("all")
public class UserFunctionServlet extends BaseServlet{

    //创建共有对象
    UserService userService = new UserServiceImpl();
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
        //获取对应参数值
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String pwd = req.getParameter("pwd");

        //进行存储
        req.setAttribute("oldPassword",oldPassword);
        req.setAttribute("newPassword",newPassword);
        req.setAttribute("pwd",pwd);

        //进行判断
        if(oldPassword.equals(UserServlet.nowPassword) == false){
            req.setAttribute("msg","原密码输入错误");
            req.getRequestDispatcher("/pages/user/account.jsp").forward(req,resp);
            return;
        }else if(newPassword.equals(pwd) == false){
            req.setAttribute("msg","新密码与确认密码不符合");
            req.getRequestDispatcher("/pages/user/account.jsp").forward(req,resp);
            return;
        }

        //进行数据更新
        User user = new User(UserServlet.nowUername,newPassword,null);
        int update = userService.Update(user);

        //弹窗修改密码成功，请重新登录
        if(update > 0){
            req.setAttribute("data",0);
            req.getRequestDispatcher("pages/user/account.jsp").forward(req,resp);
        }else{
            req.setAttribute("data",1);
            req.getRequestDispatcher("pages/user/account.jsp").forward(req,resp);
        }

        //返回页面
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
