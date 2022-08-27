<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理页面</title>
    <link type="text/css" rel="stylesheet" href="../../static/css/style.css">
    <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.png">
    <span class="wel_word">编辑图书</span>
    <%@include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <form action="manager/bookServlet" method="post">

        <input type="hidden" name="action" value="${param.method}"/>
<!--        <input type="hidden" name="pageNo" value="${param.pageNo}"/>-->
<!--        <input type="hidden" name="id" value="${requestScope.book.id}"/>-->
        <table>
            <tr>
                <td>用户名</td>
                <td>密码</td>
                <td>邮箱地址</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="username" type="text" value="${requestScope.book.name}"/></td>
                <td><input name="password" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="email" type="text" value="${requestScope.book.author}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

</body>
</html>