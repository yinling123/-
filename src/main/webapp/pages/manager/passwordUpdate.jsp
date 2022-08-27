<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <base href="http://localhost:8080/demo_war_exploded/">
  <style>
    body{
      background-color: #1f1c1c;
      background-image: url("static/img/heikj.jpg");
    }
    .box1{
      width: 400px;
      height: 500px;
      margin: auto;
      margin-top: 100px;
      border-radius: 30px;
      background-color: rgba(225, 225, 225, 0.7);
    }
    .box1 > span{
      display: inline-block;
      margin-left: 100px;
      font-size:30px;
      padding-top: 30px;
      padding-bottom: 40px;
    }
    .box2{
      width: 400px;
      height: 100px;
      margin-left: 25px;
      font-size: 20px;
    }
    .box3{
      margin: auto;
    }
    .baoc{
      display: inline-block;
      width: 100px;
      height: 50px;
      float: left;
      margin-left: 55px;
      border-radius: 10px;
      border: none;
      background-color: #1f1c1c;
      color: #cccccc;
      font-size: 20px;
    }
    .choz{
      display: inline-block;
      width: 100px;
      height: 50px;
      float: right;
      margin-right: 55px;
      border-radius: 10px;
      border: none;
      background-color: #1f1c1c;
      color: #cccccc;
      font-size: 20px;
    }

    .shur{
      display: inline-block;
      margin-left: 20px;
      border-radius: 5px;
      width: 240px;
      height: 30px;
      border: none;
    }
  </style>
</head>
<body>
<div class = "box1">
  <span>管理员密码修改</span>
  <form action="ManagerServlet" method="post">
    <input type="hidden" name="action" value="updateUser">
    <div class = "box2">
      <span>新的密码</span>
      <input type="text" class = "shur" name="password"/>
    </div>
    <div class = "box2">
      <span>确认密码</span>
      <input type="text" class = "shur" name="password"/>
    </div>
    <div class = "box2">
      <span>邮箱确认</span>
      <input type="text" class = "shur"/>
    </div>
    <div class = "box3">
      <input type="submit" class = "baoc" value="确认"/>
      <input type="submit" class = "choz" value="重置"/>
    </div>
  </form>

</div>
</body>
</html>