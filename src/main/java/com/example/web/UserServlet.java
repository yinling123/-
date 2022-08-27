package com.example.web;

import com.example.pojo.Manager;
import com.example.pojo.User;
import com.example.service.ManagerService;
import com.example.service.UserService;
import com.example.service.impl.ManagerServiceImpl;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 该类为实现关于User对象的servlet程序
 */

@SuppressWarnings("all")
public class UserServlet extends BaseServlet {

    //创建UserService共有对象
    public UserService userService = new UserServiceImpl();
    public ManagerService managerService = new ManagerServiceImpl();


    /**
     * 用户注销
     * @param req
     * @param resp
     */
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 进行用户登录判断
     * @param req
     * @param resp
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取对应对象
        Manager login = managerService.login(new Manager(username, password, null));

        System.out.println(login);

        //先进行管理员登录判断
        if(login == null){
            System.out.println(1111);
            //设置对应值，进行请求转发
//            req.setAttribute("msg","用户名或者密码错误");
//            req.setAttribute("username",username);
//            req.setAttribute("passsword",password);
//            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //管理员密码账号不进行保存
//            req.getSession().setAttribute("user",login.getUsername());
            req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
            return;
        }

        //进行普通用户判断
        User loginUser = userService.login(new User(username,password,null));

        if(loginUser == null){
            System.out.println(1111);
            //设置对应值，进行请求转发
            req.setAttribute("msg","用户名或者密码错误");
            req.setAttribute("username",username);
            req.setAttribute("passsword",password);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.getSession().setAttribute("user",loginUser.getUsername());
            req.getRequestDispatcher("/pages/user/userControl.jsp").forward(req,resp);
        }
    }

    /**
     * 进行注册验证
     * @param req
     * @param resp
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //获取请求参数形成的对象
        User user = WebUtil.copyParamToBean(req.getParameterMap(),new User());

        //获取验证码值
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //移除验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //检测验证码是否正确
        if(token != null && token.equalsIgnoreCase(code)){
            if(userService.existsUsername(username)){
                //设置对应的值
                req.setAttribute("msg","用户名不可用");
                req.setAttribute("username",username);
                req.setAttribute("email", email);
                req.setAttribute("password", password);
                req.setAttribute("repwd", repwd);
                req.setAttribute("code", code);

                //注册失败重新返回到注册界面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                //注册user对象
                userService.registerUser(user);
                //写入对应信息
                req.setAttribute("msg","注册成功，请重新登录");
                //跳转到登录页面
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }
        }else{
            //设置对应的值
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("repwd", repwd);
            req.setAttribute("code", code);

            //进行请求转发
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
    }


}
