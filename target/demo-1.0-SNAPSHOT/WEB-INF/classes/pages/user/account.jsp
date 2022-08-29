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
        }
        .div1{
            height: 600px;
            background-color: rgba(119, 118, 118, 0.8);
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
            margin-top: 50px;
            height: 300px;
            border-radius: 30px;
        }
        .box3>span{
            font-size: 30px;
            margin-left: 50px;
            color: #cccccc;
        }
        .box2>span{
            font-size: 30px;
            margin-left: 50px;
            color: #cccccc;
        }
        .box2{
            margin-top: 10px;
            float: top;
            height: 300px;
            border-radius: 30px;
        }
        .box1{
            width: 700px;
            height: 50px;
            margin-left: 70px;
            margin-top: 7px;
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
        .shur1{
            width: 450px;
            height: 25px;
            display: inline-block;
            margin-left: 30px;
            border: none;
            Border-radius:5px;
            background-color: #cccccc;
        }
        .shur2{
            width: 450px;
            height: 25px;
            display: inline-block;
            margin-left: 50px;
            border: none;
            Border-radius:5px;
            background-color: #cccccc;
        }
        button{
            border-radius: 5px;
            border: none;
            font-size: 20px;
        }
        button:hover{
            background-color: #031331;
            color: #cccccc;
        }
        .tj{
            width: 100%;
            height: 100%;

        }
        .tb{
            margin-top: 12px;
            margin-left: 300px;
            width: 100px;
            height: 50px;
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
<input type="hidden" name="action" value="accountSet">
<div class="div1" style="width:700px">
    <form action="UserServlet" method="post">

        <div class = "box2">
            <span>修改信息</span>
            <div class = "box1">
                <span>用户名:</span>
                <input type="text" class = "shur1" value="Hyb"/>
            </div>
            <div class = "box1">
                <span>单位:</span>
                <input type="text" class = "shur2" value="煤流监控科"/>
            </div>

            <%--      <div class = "box1">--%>
            <%--        <span>账号:</span>--%>
            <%--        <input type="text" class = "shur2" value=""/>--%>
            <%--      </div>--%>

            <div class = "box1">
                <span>邮箱:</span>
                <input type="text" class = "shur2" value="2048009927@qq.com"/>
            </div>

            <div class = "box1">
                <span>地址</span>
                <input type="text" class = "shur2" value="永平路220号"/>
            </div>

            <button class = "tb">保存</button>
        </div>
    </form>

    <span>修改密码</span>
    <span class="errorMsg">
        ${requestScope.msg}
    </span>
    <form action="UserFunctionServlet" method="post">
        <input type="hidden" name="action" value="accountSet">
        <div class = "box3">
            <div class = "box4">
                <span>旧密码:</span>
                <span>旧的密码</span>
                <input class="text" type="password" placeholder="请输入原密码"
                       autocomplete="off" tabindex="1" name="oldPassword" id="oldPassword"
                       value="${requestScope.oldPassword}"/>
                <div class = "box4">
                    <span>新密码:</span>
                    <input class="text" type="password" placeholder="请输入原密码"
                           autocomplete="off" tabindex="1" name="newPassword" id="newPassword"
                           value="${requestScope.newPassword}"/>
                </div>
                <div class = "box4">
                    <span>确认密码:</span>
                    <input class="text" type="password" placeholder="请输入原密码"
                           autocomplete="off" tabindex="1" name="pwd" id="pwd"
                           value="${requestScope.pwd}"/>
                </div>
                <div class="tja" style="right: 700px;">
                    <input type="submit" value="提交" class="tj">
                </div>
            </div>
        </div>
    </form>

    <div class="zhezhao" id='zhezhao'>
        <div class="tankuang">
            <div id="header">
                <div id="header-right">
                    <div><text class="txt">修改成功,请重新登录</text></div>
                    <button onclick="jump('pages/user/login.jsp')">确定</button>
                </div>
            </div>
        </div>
    </div>
    <div class="zhezhao1" id='zhezhao1'>
        <div class="tankuang">
            <div id="header">
                <div id="header-right">
                    <div><text class="txt">修改失败</text></div>
                    <button onclick="jump('pages/user/userControl.jsp')">确定</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        document.getElementById('zhezhao').style.display="none";
        document.getElementById('zhezhao1').style.display="none";
        {
            data="${requestScope.data}";
            if(data==0){
                document.getElementById('zhezhao').style.display="";
                ${requestScope.data = null};
            }
            if(data==1){
                document.getElementById('zhezhao1').style.display="";
                ${requestScope.data = null};
            }
        }
        function hidder(){
            document.getElementById('zhezhao').style.display="none";
        }
        function hidder1(){
            document.getElementById('zhezhao1').style.display="none";
        }
    </script>
</div>

<script>
    // var img = document.querySelector('.div1')
    function jump(url){
        window.location.href=url;
    }
</script>

</body>
</html>