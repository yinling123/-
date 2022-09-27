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
            background-image: url("static/img/lankj2.png");
            /*background-color: black;*/
        }
        .div1{
            height: 600px;
            background-color: #888d9a;
            border-radius: 30px;
            position: fixed;
            top: 50px;
            right: 400px;
            display: flex;
            justify-content: space-evenly; /* 水平均匀分布 */
            /*align-items: center; !* 垂直居中 *!*/
            flex-direction: column;
        }
        .box1{
            width: 700px;
            height: 50px;
            margin-left: 50px;
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
    </style>
</head>
<body>
<div class="div1" style="width:700px">
    <div class = "box1">
        <span>主界面大小:</span>
        <input type="text" class = "shur"/>
    </div>
    <div class = "box1">
        <span>副界面大小:</span>
        <input type="text" class = "shur"/>
    </div>

    <div class = "box1">
        <span>检测框颜色:</span>
        <input type="text" class = "shur"/>
    </div>

    <div class = "box1">
        <span>图表及样式:</span>
        <input type="text" class = "shur" />
    </div>
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
            }
            .div1{
                height: 600px;
                background-color: #888d9a;
                border-radius: 30px;
                position: fixed;
                top: 50px;
                right: 400px;
                display: flex;
                justify-content: space-evenly; /* 水平均匀分布 */
                /*align-items: center; !* 垂直居中 *!*/
                flex-direction: column;
            }
            .box1{
                width: 700px;
                height: 50px;
                margin-left: 50px;
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
                top:580px
            }
        </style>
    </head>
    <body>
    <div class="div1" style="width:700px">
        <div class = "box1">
            <span>主界面大小:</span>
            <input type="text" class = "shur"/>
        </div>
        <div class = "box1">
            <span>副界面大小:</span>
            <input type="text" class = "shur"/>
        </div>

        <div class = "box1">
            <span>检测框颜色:</span>
            <input type="text" class = "shur"/>
        </div>

        <div class = "box1">
            <span>图表及样式:</span>
            <input type="text" class = "shur" />
        </div>
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
                }
                .div1{
                    height: 600px;
                    background-color: #888d9a;
                    border-radius: 30px;
                    position: fixed;
                    top: 50px;
                    right: 400px;
                    display: flex;
                    justify-content: space-evenly; /* 水平均匀分布 */
                    /*align-items: center; !* 垂直居中 *!*/
                    flex-direction: column;
                }
                .box1{
                    width: 700px;
                    height: 50px;
                    margin-left: 50px;
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
            </style>
        </head>
        <body>
        <div class="div1" style="width:700px">
            <div class = "box1">
                <span>主界面大小:</span>
                <input type="text" class = "shur"/>
            </div>
            <div class = "box1">
                <span>副界面大小:</span>
                <input type="text" class = "shur"/>
            </div>

            <div class = "box1">
                <span>检测框颜色:</span>
                <input type="text" class = "shur"/>
            </div>

            <div class = "box1">
                <span>图表及样式:</span>
                <input type="text" class = "shur" />
            </div>
            <div class="tja" style="right: 700px;">
                <button class="tj" onclick="jump('UserFunctionServlet?action=colorSet')">提交</button>
            </div>
        </div>>

        </body>
        </html>
    </div>>

    </body>
    </html>
</div>>

<script>
    // var img = document.querySelector('.div1')
    function jump(url){
        window.location.href=url;
    }
</script>

</body>
</html>