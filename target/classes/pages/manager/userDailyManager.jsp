<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    body{
      background-color: black;
      text-align: center;
    }
    .div{
      float: right;
      width: 200px;
      height: 50px;
      background-color: antiquewhite;
      font-size: 30px;
      font-weight: 600;
    }

    .div1{
      float: right;
      width: 1300px;
      height: 700px;
      background-color: white;
      overflow: visible;
      max-height: none;
    }
    .div2{
      /*height: -300px;*/
      float: right;
      width: 200px;
      height: 50px;
      background-color: white;
      font-size: 30px;
      font-weight: 600;
    }
    /*}*/
  </style>
</head>
<body>
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
      <th>属性四</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
  <script>
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

  </script>
</div>
<div class="div" onclick="tj()"><text>日志</text></div>
<div class="div2"><text>用户</text></div>
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
						<th>属性四</th>
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