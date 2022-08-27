<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>基于easydl的煤流异常检测</title>
  <base href="http://localhost:8080/demo_war_exploded/">
  <style>
    .text{
      text-anchor: middle;
      dominant-baseline: middle;
    }
    .body1{
      text-align: center;
    }
    .axis{
      stroke: black;
      stroke-width: 1px;
    }
    body{
      background-color: mediumspringgreen;
    }
    .yinshen1 {
      width: 100%;
      height: 100%;
      position: absolute;
      left: 0;
      top: 0;
      opacity: 0;

    }
    #pace1{
      top: -40px;
      left: 75px;
    }
    #pace2{
      top: -10px;
      left: 75px;
    }
    #pace3{
      top: 20px;
      left: 75px;
    }
    .tijiao{

      position: relative;
      width: 100px;
      height: 50px;
      top: 50px;
      left: 125px;
      position: relative;
      line-height: 50px;
      text-align: center;
    }
    #jiance{
      position: relative;
      width: 100px;
      height: 30px;
      top: 10px;
      left: 40px;
      position: relative;
      line-height: 25px;
      text-align: center;
    }
    #bofang{
      position: relative;
      width: 100px;
      height: 30px;
      top: 10px;
      left: 50px;
      position: relative;
      line-height: 25px;
      text-align: center;
    }
    .div {
      position: relative;
      width: 200px;
      height: 50px;
      position: relative;
      line-height: 60px;
      background-color: #ccc;
      text-align: center;
      position: relative;
    }

    div {
      position: relative;
      width: 300px;
      height: 250px;
      position: relative;
      line-height: 60px;
      text-align: center;
      position: relative;
    }

    #hou{
      height: 50px;
      width: 50px;
      /*background-image: url(hou.png);*/
      background-size: cover;
      position: relative;
      top: 10px;
      left: 650px;
    }
    #qian{
      height: 50px;
      width: 50px;
      /*background-image: url(qian.png);*/
      background-size: cover;
      position: relative;
      top: 10px;
      left: 690px;
    }
    .td{
      width: 375px;
      height: 150px;
    }
    #up{
      height: 20px;
      width: 100px;
      position: relative;
      top: 125px;
      left: 125px;
    }
    #select{
      position: relative;
      top: 175px;
      left: 150px;
    }
    #yinshen{
      width: 100%;
      height: 100%;
      position: absolute;
      left: 0;
      top: 0;
      opacity: 0;
    }
    #chaxun{
      height: 50px;
      width: 200px;
      position: relative;
      top: -60px;
      left: 75px;
    }
  </style>
</head>
<script>
  function jump(){
    window.location.href='/demo_war_exploded/CoalServlet?action=getList';
  }
</script>
<body>
<table border="1" width=1500px height=730px valign="right">
  <tr>
    <td class="td" rowspan="2"><button id="chaxun" onclick="jump()">日志查詢</button>
      <form id="form1">
        <div class="div" id="pace1">
          <input class="yinshen1" type="file"/>
          <text >区域1</text>
        </div>
        <div class="div" id="pace2">
          <input class="yinshen1" type="file"/>
          <text >区域2</text>
        </div>
        <div class="div" id="pace3">
          <input class="yinshen1" type="file"/>
          <text >区域3</text>
        </div>
        <input class="tijiao" value="提交" onclick="upload()" type="submit"/>
      </form>
    </td>
    <td class="td" id='bigvideo' colspan="2" rowspan="2" bgcolor="black"></td>
    <script>
      var bigvideo = document.querySelector('#bigvideo')
      bigvideo.innerHTML=bigvideo.innerHTML+`<video id="bigvideo1" width="800px" height="350" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls"></video>`
    </script>
    <td class="td" bgcolor="black"><video id="video1" width="300px" height="150" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls"></video></td>
    <script>
      var video1 = document.querySelector('#video1')
      var bigvideo = document.querySelector('#bigvideo')
      var zhutu = document.querySelector('#zhutu')
      video1.onclick = function(){
        bigvideo.innerHTML=`<video width="800px" height="350" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls">
					<source src="mov/meiliutest.mp4" type="video/mp4">`}

    </script>
  </tr>
  <tr>
    <td class="td" bgcolor="black"><video id="video2" width="300px" height="150" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls"></video></td>
    <script>
      var video2 = document.querySelector('#video2')
      var bigvideo = document.querySelector('#bigvideo')
      video2.onclick = function(){
        bigvideo.innerHTML=`<video width="800px" height="350" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls">
					<source src="mov/test.mp4" type="video/mp4">`}
    </script>
  </tr>
  <tr>
    <td class="td"><div id="jindu" width='300' height='225'>
      <svg id="tu" height='250' width='250'>
        <circle cx='125' cy='125' r='90' fill='none' stroke='grey' stroke-width='40' stroke-linecap='round'/>
        <circle class='progress' transform='rotate(-90, 125, 125)' cx='125' cy='125' r='90' fill='none' stroke='red' stroke-width='40' stroke-linecap='round' stroke-dasharray='0, 10000' />
        <text class='text' x='125' y='125' font-size='60' fill='red'>0%</text>
      </svg>
    </div>
      <button id="jiance" onclick="upload()" >检测</button>
      <button id="bofang" onclick="bofang()" >查看</button>
      <script>
        function bofang(){
          // var video1 = document.querySelector('#video1')
          // video1.innerHTML = video1.innerHTML + `<source src="mov/meiliutest.mp4" type="video/mp4">`
          // var video2 = document.querySelector('#video2')
          // video2.innerHTML = video2.innerHTML + `<source src="mov/test.mp4" type="video/mp4">`
          // var video3 = document.querySelector('#video3')
          // video3.innerHTML = video3.innerHTML + `<source src="mov/test.mp4" type="video/mp4">`
          var bigvideo1 = document.querySelector('#bigvideo1')
          bigvideo1.innerHTML = bigvideo1.innerHTML + `<source src="mov/meiliutest.mp4" type="video/mp4">`
        }
      </script>
      <script>
        var data=[
          {
            data:'1',
            number:'1000'
          },
          {
            data:'2',
            number:'500'
          },
          {
            data:'3',
            number:'600'
          },
          {
            data:'4',
            number:'700'
          },
          {
            data:'5',
            number:'800'
          },
          {
            data:'6',
            number:'900'
          }
        ]
        var xkedu = document.querySelector("#xkedu");
        var xkedu = document.querySelector("#ykedu");
        var barlistDom = document.querySelector('#barlist')
        var xlength = 240/data.length;
        var ylength = 205/15
      </script>
      <script>
        var textdom = document.querySelector('.text');
        var progressdom = document.querySelector('.progress');
        function rotateCircle(present){
          var circlelength = Math.floor(2*Math.PI*parseFloat(progressdom.getAttribute('r')));
          var value = present*circlelength/100;
          var red = 255+parseInt((0-255)/100*present);
          var green = 0+parseInt((191-0)/100*present);
          var blue = 0+parseInt((255-0)/100*present);
          progressdom.setAttribute('stroke-dasharray', value+',10000');
          progressdom.setAttribute('stroke', `rgb(${red},${green}, ${blue})`);
          textdom.innerHTML = present-1+'%';
          textdom.setAttribute('fill', `rgb(${red},${green}, ${blue})`)
        }
        function upload(){
          var num=0;
          setInterval(()=>{
            if (num<100){
              num++;
              rotateCircle(num+1)
            }

          },30)
        }
      </script></td>
    <td class="td" id="zhutu">
      <a href="CoalServlet?action=toBarChart"><button>查看</button></a>
      </script>
      <svg width='400' height='225' >
        <g id='zuobiao'>
          <line class='axis' x1=30 y1=180 x2=350 y2=180></line>
          <path d='M  325,170 L 350,180 L 325,190'></path>
          <text x='320' y=170>时间</text>
          <line class='axis' x1=30 y1=0 x2=30 y2=180></line>
          <path d='M  20,20 L 30,0 L 40,20'></path>
          <text x='40' y=15>stone</text>
          <g id="xkedu">
          </g>
          <g id="ykedu">
          </g>
          <g id='barlist'>
          </g>
        </g>
      </svg>
      <script>
        var xkedu = document.querySelector("#xkedu");
        var xkedu = document.querySelector("#ykedu");
        var barlistDom = document.querySelector('#barlist')
        var xlength = 240/data.length;
        var ylength = 205/15
        for(var j=1;j<=9;j++){
          ykedu.innerHTML = ykedu.innerHTML + `<line class='axis' x1='30' y1='${175-ylength*j}' x2='35' y2='${175-ylength*j}'></line>` +
                  `<text  x="5"  y="${180-ylength*j}">${10*j}</text>`
        }
      </script>
    </td>
    <td class="td">扇形圖</td>
    <td class="td" bgcolor="black"><video id="video3" width="300px" height="150" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls"></video></td>
    <script>
      var video3 = document.querySelector('#video3')
      var bigvideo = document.querySelector('#bigvideo')
      video3.onclick = function(){
        bigvideo.innerHTML=`<video width="800px" height="350" ishivideo="true" autoplay="true" isrotate="true" autoHide="true" controls="controls">
						<source src="test.mp4" type="video/mp4">`}
    </script>
  </tr>
</table>
</body>
</html>