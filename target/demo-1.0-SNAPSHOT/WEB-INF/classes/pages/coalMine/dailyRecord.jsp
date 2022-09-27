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
      background-image: url("static/img/landl2.png");
      /*background-color: black;*/
    }
    table{
      width: 800px;
      margin: 100px auto;
      font-size: 20px;
      border-collapse: collapse;
      text-align: center;
    }
    thead tr{
      height: 40px;
      width: 800px;
      background-color: #9b9b9b;
    }
    thead{
      background-color: #cccccc;
    }
    .box1{
      width: 800px;
      height: 600px;
      margin: auto;
      border-radius: 10px;
      background-color: rgba(204, 204, 204, 0.8);
    }
    #lef{
      border-radius: 10px 0px 0px 0px;
    }
    #rig{
      border-radius: 0px 10px 0px 0px;
    }
  </style>
</head>
<body>
<div class = "box1">
  <table cellspacing='0'>
    <thead>
    <tr>
      <th id = "lef">区域</th>
      <th>时间</th>
      <th>次序</th>
      <th>宽度</th>
      <th>类型</th>
      <th id = "rig">长度</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
  </table>
</div>

<script>

  Date.prototype.format =function(format)

  {

    var o = {

      "M+" : this.getMonth()+1, //month

      "d+" : this.getDate(), //day

      "h+" : this.getHours(), //hour

      "m+" : this.getMinutes(), //minute

      "s+" : this.getSeconds(), //second

      "q+" : Math.floor((this.getMonth()+3)/3), //quarter

      "S" : this.getMilliseconds() //millisecond

    }

    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,

            (this.getFullYear()+"").substr(4- RegExp.$1.length));

    for(var k in o)if(new RegExp("("+ k +")").test(format))

      format = format.replace(RegExp.$1,

              RegExp.$1.length==1? o[k] :

                      ("00"+ o[k]).substr((""+ o[k]).length));

    return format;

  }


  var datas = null;
  datas = ${requestScope.string};
  // console.log(datas)
  // [
  //   {
  //     name:'ljz',
  //     age:'11'
  //   },
  //   {
  //     name:'wlh',
  //     age:'12'
  //   },
  //   {
  //     name:'sss',
  //     age:'55'
  //   }
  // ];
  var tbody = document.querySelector('tbody');
  for (var i = 0; i<datas.length; i++){
    var temp = datas[i];
    var tr = document.createElement('tr');
    for (var k in temp){
      if(k != 'datetime') {
        var td = document.createElement('td');
        td.innerHTML = datas[i][k];
        tr.appendChild(td);
      }else{
        var td = document.createElement('td');
        td.innerHTML = new Date(datas[i][k]).format('yyyy-MM-dd');
        tr.appendChild(td);
      }
      // var td = document.createElement('td');
      // td.innerHTML = datas[i][k];
      // tr.appendChild(td);
    }
    tbody.appendChild(tr);
  }
  // var table="<table border='1' cellspacing='0'>";//这个字符串第一位为# 颜色的格式
  // for(var i = 0; i < datas.length; i++) {
  //   table += "<tr>";
  //   for (var key in data[i]){
  //     table = table+"<td>"+data[i][key]+"</td>";
  //   }
  //   table+="</tr>";
  // }
  // table+="</table>";
  // tbody.innerHTML = table;

</script>
</body>
</html>