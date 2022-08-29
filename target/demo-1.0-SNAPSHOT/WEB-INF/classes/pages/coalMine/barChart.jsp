<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>柱状图</title>
    <base href="http://localhost:8080/demo_war_exploded/">
    <style>
        .axis{
            stroke: black;
            stroke-width: 2px;
        }
    </style>
</head>
<body>
<svg width='1000' height='700'>
    <g id='zuobiao'>
        <line class='axis' x1='50' y1='600' x2='950' y2='600' ></line>
        <path d='M 925, 590 L 950, 600 L 925, 610'></path>
        <text x='900' y=630>時間</text>
        <line class='axis' x1='100' y1='650' x2='100' y2='50' ></line>
        <path d='M 90, 75 L 100, 50 L 110, 75'></path>
        <text  x='50' y=70>stone</text>
        <g id="xkedu">
        </g>
        <g id="ykedu">
        </g>
        <g id='barlist'>
        </g>
    </g>
</svg>
<script type="text/javascript">
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
    var jgLength = 700/data.length;
    var ylength = 450/15
    for(var i= 1;i<=data.length;i++){
        renderkedu(i)
    }
    for(var j=1;j<=15;j++){
        ykedu.innerHTML = ykedu.innerHTML + `<line class='axis' x1='100' y1='${600-ylength*j}' x2='120' y2='${600-ylength*j}'></line>` +
            `<text x="50"  y="${600-ylength*j}">${10*j}</text>`
    }
    function renderkedu(index){
        var lineDom = document.createElement('line')
        lineDom.className = 'axis';
        lineDom.setAttribute('x1', 100+jgLength*index);
        lineDom.setAttribute('y1', 600);
        lineDom.setAttribute('x2', 100+jgLength*index);
        lineDom.setAttribute('y2', 580);
        xkedu.innerHTML = xkedu.innerHTML + lineDom.outerHTML+`<text x="${95+jgLength*index}"  y="620">${data[i-1].data}</text>`
        barlistDom.innerHTML = barlist.innerHTML +
            `<rect x='${75+jgLength*index}' y='${600-(ylength*(data[index-1].number/100))}' width='40' height='${ylength*(data[index-1].number/100)}'></rect>`
    }
</script>
</body>
</html>