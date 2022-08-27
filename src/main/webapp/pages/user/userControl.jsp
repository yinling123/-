<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户页面</title>
  <base href="http://localhost:8080/demo_war_exploded/">
  <style>
    body{
      background-color: black;
    }
    .div1{
      float: left;

    }
    .div2{
      float: left;
    }
    .but{
      border-radius: 30px;
      background: wheat;
      border: none;
      color: white;
      margin: 6px 10px;
    }
    .but1{
      top: 10px;
      right: 500px;
      width: 800px;
      height: 150px;
    }
    .but2{
      top: 30px;
      right: 500px;
      width: 480px;
      height: 125px;
    }
    .but3{
      top: 30px;
      right: 500px;
      width: 320px;
      height: 125px;
    }
    .but4{
      top: 30px;
      right: 500px;
      width: 266px;
      height: 125px;
    }
    .but5{
      top: 0px;
      right: 500px;
      width: 266px;
      height: 125px;
    }
    .but6{
      top: 0px;
      right: 500px;
      width: 266px;
      height: 125px;
    }
    .but7{
      top: 0px;
      right: 500px;
      width: 800px;
      height: 125px;
    }
    .tt{
      font-size: 50px;
    }
    .tt1{
      font-size: 25px;
    }
  </style>
</head>
<body>
<div class="div" align="center" style="position:relative;top:5px;right:-10px;">
  <button class="but but1"><text class="tt">开始检测</text></button>
</div>
<div class="div1" style="position:relative;top:0px;right:-350px;">
  <button class="but but2" onclick="jump('pages/coalMine/photoCheck.jsp')"><text class="tt1">图片检测</text></button>
</div>
<div class="div2" style="position:relative;top:0px;right:-330px;">
  <button class="but but3" onclick="jump('pages/coalMine/coal.jsp')"><text class="tt1">视频检测</text></button>
</div>
<div style="position:relative;top:135px;right:490px;">
  <button class="but but4" onclick="jump('pages/user/colorSet.jsp')"><text class="tt1">画面设置</text></button>
</div>
<div style="position:relative;top:-3px;right:-620px;">
  <button class="but but5" onclick="jump('pages/user/account.jsp')"><text class="tt1">账号信息</text></button>
</div>
<div style="position:relative;top:-140px;right:-880px;">
  <button class="but but6"></button>
</div>
<div style="position:relative;top:-140px;right: -350px;">
  <button class="but but7" onclick="jump('' +
   'pages/user/check.jsp')"><text class="tt1">添加设备</text></button>
</div>
<script>
  // var img = document.querySelector('.div1')
  function jump(url){
    window.location.href=url;
  }
</script>
</body>
</html>