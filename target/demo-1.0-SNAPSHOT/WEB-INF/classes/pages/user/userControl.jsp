<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <base href="http://localhost:8080/demo_war_exploded/">
  <style>
    body{
      background-image: url("static/img/lankj2.png");
    }
    .box1{
      margin: auto;
      margin-top: 35px;
      width: 1000px;
      height: 700px;
      background-color: rgba(10, 10, 10, 0.6);
    }
    .div1{
      height: 125px;
      width: 900px;
      margin-top: 15px;
      margin-left: 50px;
    }

    .but{
      border-radius: 30px;
      background: rgba(148, 147, 147, 0.7);
      border: none;
      color: white;
      margin: 0px;
      padding: 0px;
    }
    button {
      border: 0;
      margin: 20px;
      text-transform: uppercase;
      font-size: 20px;
      font-weight: bold;
      padding: 15px 50px;
      border-radius: 30px;
      color: white;
      outline: none;
      position: relative;
    }

    button:before{
      content: '';
      display: block;
      background: linear-gradient(to left, rgba(255, 255, 255, 0) 50%, rgba(255, 255, 255, 0.4) 50%);
      background-size: 210% 100%;
      background-position: right bottom;
      height: 100%;
      width: 100%;
      position: absolute;
      top: 0;
      bottom:0;
      right:0;
      left: 0;
      border-radius: 30px;
      transition: all 1s;
      -webkit-transition: all 1s;
    }

    button:hover:before {
      background-position: left bottom;
    }
    button:hover{
      color: rgba(2, 19, 54, 0.9);
    }
    .but1{
      margin-top: 40px;
      width: 800px;
      height: 150px;
    }
    .but2{
      vertical-align:middle;
      margin-left: 60px;
      width: 460px;
      height: 125px;
    }
    .but3{
      vertical-align:middle;
      /*right: 400px;*/
      margin-left: 7px;
      width: 325px;
      height: 125px;
    }
    .but4{
      margin-left: 60px;
      vertical-align:middle;
      display: inline-block;
      width: 258px;
      height: 125px;
    }
    .but5{
      vertical-align:middle;
      display: inline-block;
      margin-left: 5px;
      width: 258px;
      height: 125px;
    }
    .but6{
      vertical-align:middle;
      display: inline-block;
      margin-left: 5px;
      width: 258px;
      height: 125px;
    }
    .but7{
      margin-left: 55px;
      width: 800px;
      height: 125px;
    }
    .tt{
      font-size: 55px;
    }
    .tt1{
      font-size: 25px;
    }
    .tt0{
      font-size: 30px;
    }
  </style>
</head>
<body>
<div class = "box1">
  <div class="div" align="center" style="position:relative;top:5px;right:-10px;">
    <button class="but but1"><text class="tt">开始检测</text></button>
  </div>
  <div class="div1" >
    <button class="but but2" onclick="jump('pages/coalMine/photoCheck.jsp')"><text class="tt0">图片检测</text></button>
    <button class="but but3" onclick="jump('pages/coalMine/coal.jsp')"><text class="tt0">视频检测</text></button>
  </div>
  <div class = "div1">
    <button class="but but4" onclick="jump('pages/user/colorSet.jsp')"><text class="tt1">画面设置</text></button>
    <button class="but but5" onclick="jump('pages/user/account.jsp')"><text class="tt1">账号信息</text></button>
    <button class="but but6" onclick="jump('pages/user/login.jsp')"><text class="tt1">退出登录</text></button>
  </div>

  <div class = "div1">
    <button class="but but7" onclick="jump('pages/user/check.jsp')"><text class="tt0">添加设备...</text></button>
  </div>
</div>

<script>
  var img = document.querySelector('.div1')
  function jump(url){
    window.location.href=url
  }
</script>
</body>
</html>