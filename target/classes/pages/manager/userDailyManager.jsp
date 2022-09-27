<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>检测记录</title>
  <base href="http://localhost:8080/demo_war_exploded/">
  <style>
    body{
      background-image: url("static/img/landl2.png");
      text-align: center;
    }
    .div{
      display: inline-block;
      margin-left: 30px;
      width: 200px;
      height: 50px;
      background-color: antiquewhite;
      color: #0a475b;
      border-radius: 10px 0px 0px 0px;
      font-size: 30px;
      font-weight: 600;
    }

    .div1{
      display:inline-block;
      width: 1300px;
      height: 600px;
      background-color: rgba(255, 255, 255, 0.7);
      border-radius: 0px 20px 20px 20px;
      overflow: visible;
      max-height: none;
    }
    .div2{
      /*height: -300px;*/
      display: inline-block;
      width: 200px;
      height: 50px;
      border-radius: 0px 10px 0px 0px ;
      color:  #0a475b;
      background-color: white;
      font-size: 30px;
      font-weight: 600;
    }
    .qieh{
      margin-top: 30px;
      width: 600px;
      height: 50px;
    }
    /*}*/
  </style>
</head>
<body>
<div class = "qieh">
  <div class="div" onclick="tj()"><text>日志</text></div>
<%--  <div class="div2"><text>用户</text></div>--%>
</div>

<div class="div1">
  <style>
    table{
      width: 1200px;
      margin: 100px auto;
      border-collapse: collapse;
      text-align: center;
    }
    td,
    th{
      boder: 1px solid #333;
    }
    thead tr{
      height: 40px;
      background-color: #ccc;
    }
  </style>
  <table cellspacing='0'>
    <thead>
    <tr>
      <th>用户名</th>
      <th>设备数量</th>
      <th>使用时间</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
  <script>
    var datas = [
      {
        name:'12323',
        age:'2',
        date:'2022-08-18 13:28:39'
      },
      {
        name:'333232',
        age:'1',
        date:'2022-08-18 16:21:26'
      },
      {
        name:'ljz',
        age:'2',
        date:'2022-08-18 13:28:39'
      },
      {
        name:'sss',
        age:'1',
        date:'2022-08-18 16:21:26'
      },
      {
        name:'1234567',
        age:'1',
        date:'2022-08-23 10:29:35'
      }
    ];
    var tbody = document.querySelector('tbody');
    for (var i=0; i<datas.length; i++){
      var tr = document.createElement('tr');
      tbody.appendChild(tr)
      for (var k in datas[i]){
        var td = document.createElement('td');
        td.innerHTML = datas[i][k]
        tr.appendChild(td);
      }
    }

  </script>
</div>

<script>
  function changeColor1(color) {
    d1.style.cssText = "background-color:" + color;
    d2.style.cssText = "background-color:" + 'white';
  }
  function changeColor2(color) {
    d2.style.cssText = "background-color:" + color;
    d1.style.cssText = "background-color:" + 'white';
  }
  var d1 = document.querySelector('.div')
  var d2 = document.querySelector('.div2')
  d1.onclick = function(){
    changeColor1("antiquewhite");
    div1.innerHTML = `
			<style>
				table{
					width: 1200px;
					margin: 100px auto;
					border-collapse: collapse;
					text-align: center;
				}
				td,
				th{
					boder: 1px solid #333;
				}
				thead tr{
					height: 40px;
					background-color: #ccc;
				}
			</style>
			<table cellspacing='0'>
				<thead>
					<tr>
						<th>用户名</th>
						<th>设备数量</th>
						<th>使用时间</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>`
    var datas = [
      {
        name:'ljz',
        age:'11'
      },
      {
        name:'wlh',
        age:'12'
      },
      {
        name:'sss',
        age:'55'
      }
    ];
    var tbody = document.querySelector('tbody');
    for (var i=0; i<datas.length; i++){
      var tr = document.createElement('tr');
      tbody.appendChild(tr)
      for (var k in datas[i]){
        var td = document.createElement('td');
        td.innerHTML = datas[i][k]
        tr.appendChild(td);
      }
    }
  }
  d2.onclick = function(){
    changeColor2("antiquewhite");
  }
  var div1 = document.querySelector('.div1')

</script>
</body>
</html>