<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <base href="http://localhost:8080/demo_war_exploded/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <span class="wel_word">后台管理系统</span>
    <div>
        <a href="ManagerServlet?action=getUsersList">用户管理</a>
        <a href="pages/manager/userDailyManager.jsp">监控管理</a>
        <a href="pages/manager/passwordUpdate.jsp">修改密码</a>
        <a href="index.jsp">返回登录页面</a>
    </div>
</div>

<div id="main">
    <h1>欢迎管理员进入后台管理系统</h1>
</div>

</body>
</html>