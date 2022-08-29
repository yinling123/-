<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <base href="http://localhost:8080/demo_war_exploded/">
  <title></title>
</head>
<style>
  #result {
    top: 20px;
    right: -560px;
    position: relative;
    width: 400px;
    height: 500px;
    position: relative;
    line-height: 50px;
    background-color: black;
    text-align: center;
    position: relative;
  }
  .div {
    right: -650px;
    position: relative;
    width: 200px;
    height: 50px;
    position: relative;
    line-height: 50px;
    background-color: #ccc;
    text-align: center;
    position: relative;
  }
  .div1 {
    float: left;
    top: 540px;
    right: -600px;
    position: relative;
    width: 100px;
    height: 50px;
    position: relative;
    line-height: 50px;
    background-color: #ccc;
    text-align: center;
    position: relative;
  }
  .div2 {
    float: left;
    top: 40px;
    right: -800px;
    position: relative;
    width: 100px;
    height: 50px;
    position: relative;
    line-height: 50px;
    background-color: #ccc;
    text-align: center;
    position: relative;
  }
  .tj {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    top: 0;
    opacity: 0;
  }
  #ck {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    top: 0;
    opacity: 0;
  }
</style>
<body>
<div>
  <form action="UserFunctionServlet" method="get">
    <input type="hidden" name="action" value="photoChecked">
    <div class="div">
      <input class="tj" type="file"/>
      <text>选择照片</text>
    </div>

    <div class="div1">
      <input class="tj" type="submit"/>
      <text>确认</text>
    </div>
  </form>
</div>
<div id="result"></div>
<div class="div2">
  <button id="ck" onclick="xianshi()"></button>
  <text>查看</text>
</div>
<script>
    var result = document.querySelector('#result');
    function xianshi(){
      result.innerHTML = `<img src='static/img/coal@1.jpg' style="width: 400px; height:400px">`;
    }
</script>
</body>
</html>