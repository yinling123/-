<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <base href="http://localhost:8080/demo_war_exploded/">
  <style>
    body{
      background-color: black;
    }
    .div1{
      height: 600px;
      background-color: #b1b2a9;
      border-radius: 30px;
      position: fixed;
      top: 50px;
      right: 400px;
      display: flex;
      justify-content: space-evenly; /* 水平均匀分布 */
      /*align-items: center; !* 垂直居中 *!*/
      flex-direction: column;
    }
    .box4{
      width: 600px;
      margin-left: 70px;
      margin-top: 25px;
      font-size: 20px;
    }
    .box3{
      height: 300px;
      border-radius: 30px;
    }
    .box3>span{
      font-size: 30px;
      margin-left: 50px;
      color: #cccccc;
    }

    .box2{
      float: top;
      height: 300px;
      border-radius: 30px;
    }
    .box1{
      width: 700px;
      height: 50px;
      margin-left: 50px;
      margin-top: 15px;
      font-size: 22px;
      line-height: 50px;
    }
    .shur{
      width: 450px;
      height: 25px;
      display: inline-block;
      margin-left: 20px;
      border: none;
      Border-radius:5px;
      background-color: #cccccc;
    }
    .tj{
      width: 100%;
      height: 100%;
    }
    .tja{
      width: 100px;
      height: 50px;
      border-radius: 5px;
      position: fixed;
      top:550px
    }
  </style>
</head>
<body>

<div class="div1" style="width:700px">
  <div class = "box2">
    <div class = "box1">
      <span>用户名:</span>
      <input type="text" class = "shur"/>
    </div>
    <div class = "box1">
      <span>单位:</span>
      <input type="text" class = "shur"/>
    </div>

    <div class = "box1">
      <span>账号:</span>
      <input type="text" class = "shur"/>
    </div>

    <div class = "box1">
      <span>邮箱:</span>
      <input type="text" class = "shur" />
    </div>
  </div>
  <div class = "box3">
    <span>修改密码</span>
    <div class = "box4">
      <span>新的密码:</span>
      <input type="text" class = "shur" />

    </div>
    <div class = "box4">
      <span>确认密码:</span>
      <input type="text" class = "shur" />
    </div>
    <div class="tja" style="right: 700px;">
      <button class="tj" onclick="jump('UserFunctionServlet?action=accountSet')">提交</button>
    </div>
  </div>


</div>>
<script>
  // var img = document.querySelector('.div1')
  function jump(url){
    window.location.href=url;
  }
</script>

</body>
</html>