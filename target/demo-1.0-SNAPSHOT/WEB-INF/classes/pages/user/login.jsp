<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>煤流监测登录页面</title>
	<base href="http://localhost:8080/demo_war_exploded/">
	<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.png" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>检测用户</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
<%--									调用el表达式进行根据返回值进行判断--%>
									${empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="UserServlet" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
										value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"
										value="${requestScope.password}"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
</body>
</html>