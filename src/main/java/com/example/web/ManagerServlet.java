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
@SuppressWarnings("all")
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
        String password = req.getParameter("newPassword");
        System.out.println(password + "dsds");

        //生成对应对象
        User user = new User("houyinbo",password,null);

        //进行数据更换
        int update = managerService.Update(user);

        if(update > 0){
            System.out.println("修改成功");
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
        //获取密码
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String pwd = req.getParameter("pwd");

        System.out.println(pwd);

        //进行存储
        req.setAttribute("oldPassword",oldPassword);
        req.setAttribute("newPassword",newPassword);
        req.setAttribute("pwd",pwd);

        //判断原密码错误
        if(oldPassword == null || newPassword == null){
            req.setAttribute("msg",null);
            req.getRequestDispatcher("/pages/manager/passwordUpdate.jsp").forward(req,resp);
            return;
        }
        else if(oldPassword.equals("houyinbo") == false){
            req.setAttribute("msg","原密码错误");
            req.getRequestDispatcher("/pages/manager/passwordUpdate.jsp").forward(req,resp);
            return;
        }else if(newPassword.equals(pwd) == false){
            //判断新密码是否相等
            req.setAttribute("msg","新密码与确认密码不相同");
            req.getRequestDispatcher("/pages/manager/passwordUpdate.jsp").forward(req,resp);
            return;
        }
        //生成对应的对象
        Manager manager = new Manager("houyinbo",newPassword,null);

        //进行数据更新
        int update = managerService.update(manager);

        //进行判断
        if(update > 0){
            System.out.println("修改成功");
            req.setAttribute("data",0);
            req.getRequestDispatcher("/pages/manager/passwordUpdate.jsp").forward(req,resp);
            return;
        }else{
            req.setAttribute("data",1);
            req.getRequestDispatcher("/pages/manager/passwordUpdate.jsp").forward(req,resp);
        }
//        req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
    }

    /**
     * 增加用户
     * @param req
     * @param resp
     */
    public void addUser(HttpServletRequest req, HttpServletResponse resp){

    }





}
