package com.example.web;

import com.example.pojo.Manager;
import com.example.pojo.User;
import com.example.service.ManagerService;
import com.example.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 针对管理员页面的servlet程序
 */
public class ManagerServlet extends BaseServlet {

    //创建共有对象
    ManagerService managerService = new ManagerServiceImpl();

    /**
     * 进行数据更新，并且返回数据页面
     * @param req
     * @param resp
     */
    public void getUsersList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取对应的数据表
        List<User> list = managerService.listUsers();
        //进行存储
        req.setAttribute("userList",list);
        //进行请求转发
        req.getRequestDispatcher("/pages/manager/userManager.jsp").forward(req,resp);
    }

    /**
     * 返回登录页面
     * @param req
     * @param resp
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行请求转发
        req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
    }

    /**
     * 更新用户密码
     * @param req
     * @param resp
     */
    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //修改用户名及其修正后的密码
        String password = req.getParameter("password");

        //生成对应对象
        User user = new User("houyinbo",password,null);

        //进行数据更换
        int update = managerService.Update(user);

        if(update > 0){

        }else{

        }
        //跳转回原页面
        req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
    }

    /**
     * 更新管理员密码
     * @param req
     * @param resp
     */
    public void updateManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //生成对应的对象
        Manager manager = new Manager(username, password, null);

        //进行数据更新
        int update = managerService.update(manager);

        //进行判断
        if(update > 0){

        }else{

        }
        req.getRequestDispatcher("").forward(req,resp);
    }

    /**
     * 增加用户
     * @param req
     * @param resp
     */
    public void addUser(HttpServletRequest req, HttpServletResponse resp){

    }





}
