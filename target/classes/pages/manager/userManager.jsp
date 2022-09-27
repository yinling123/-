<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <base href="http://localhost:8080/demo_war_exploded/">
    <link type="text/css" rel="stylesheet" href="static/css/style.css">
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">

        $(function () {

            $("a.deleteClass").click(function () {
                return confirm("确认删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");

            });
        });

    </script>
    <style>
        body{
            background-image: url("static/img/landl2.png");
            text-align: center;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <span class="wel_word">用户管理</span>
</div>

<div id="main">
    <table>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>邮箱</td>
            <td></td>
            <td></td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.userList}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td></td>
                <td></td>
                <td><a href="manager/bookServlet?action=getBook">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>-
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/userEdit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加用户</a></td>
        </tr>
    </table>
</div>
</body>
</html>