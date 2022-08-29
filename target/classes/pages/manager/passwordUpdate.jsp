<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员密码修改页面</title>
    <base href="http://localhost:8080/demo_war_exploded/">
    <style>
        body{
            /*background-color: #1f1c1c;*/
            background-image: url("static/img/lankj2.png");
            background-repeat: no-repeat;
            margin: 0px;
            text-align: center;
        }
        .zhezhao{
            position: fixed;
            left: 0px;
            top: 0px;
            background: #000;
            width: 100%;
            height: 100%;
            opacity: 0.9;
        }
        .zhezhao1{
            position: fixed;
            left: 0px;
            top: 0px;
            background: #000;
            width: 100%;
            height: 100%;
            opacity: 0.9;
        }
        .tankuang{
            position: relative;
            background: #fff;
            width: 40%;
            height: 20%;
            border-radius: 5px;
            margin: 5% auto;
        }
        #header{
            height: 40px;
        }
        .txt{
            font-size: 50px;
        }

        /*.bgimg{*/
        /*    !*width: 100%;*!*/
        /*    width: 100%;*/
        /*    height: calc(100vh);*/
        /*    background-color: #1f1c1c;*/
        /*}*/
        .box1{
            width: 500px;
            height: 550px;
            margin: auto;
            margin-top: 90px;
            border-radius: 30px;
            background-color: rgba(225, 225, 225, 0.7);
        }
        .box1 > span{
            display: inline-block;
            margin-left: 135px;
            font-size:35px;
            font-family: FangSong ;
            font-weight: 1000;
            color: #031331;
            padding-top: 30px;
            padding-bottom: 40px;
        }
        .box2{
            width: 400px;
            height: 100px;
            margin-left: 25px;
            font-size: 20px;
        }
        .box3{
            margin: auto;
        }
        .baoc{
            display: inline-block;
            width: 120px;
            height: 60px;
            float: left;
            margin-left: 70px;
            border-radius: 10px;
            border: none;
            background-color: #031331;
            color: #cccccc;
            font-size: 20px;
        }
        .choz{
            display: inline-block;
            width: 120px;
            height: 60px;
            float: right;
            margin-right: 70px;
            border-radius: 10px;
            border: none;
            background-color: #031331;
            color: #cccccc;
            font-size: 20px;
        }

        .shur{
            display: inline-block;
            margin-left: 30px;
            border-radius: 5px;
            color: #666666;
            font-size: 17px;
            width: 370px;
            height: 40px;
            border: none;
        }

    </style>
</head>
<body>
<!--<div class = "bgimg">-->
<div class = "box1">
    <span>管理员密码修改</span>
    <span class="errorMsg">
    ${requestScope.msg}
  </span>
    <form action="ManagerServlet" method="post">
        <input type="hidden" name="action" value="updateManager">
        <div class = "box2">
            <span>旧的密码</span>
            <input class="itxt" type="password" placeholder="请输入原密码"
                   autocomplete="off" tabindex="1" name="oldPassword" id="oldPassword"
                   value="${requestScope.oldPassword}"/>
        </div>
        <div class = "box2">
            <span>新的密码</span>
            <input class="itxt" type="password" placeholder="请输入密码"
                   autocomplete="off" tabindex="1" name="newPassword" id="newPassword"
                   value="${requestScope.newPassword}"/>
        </div>
        <div class = "box2">
            <span>确认密码</span>
            <input class="itxt" type="password" placeholder="请再次输入新密码"
                   autocomplete="off" tabindex="1" name="pwd" id="pwd"
                   value="${requestScope.pwd}"/>
        </div>
    <div class = "box3">
        <input type="submit" class = "baoc" onclick="dianwo()" value="确认"/>
        <input type="submit" class = "choz" value="重置"/>
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
                    <button onclick="jump('pages/manager/manager.jsp')">确定</button>
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
                    data = null;
                }
                if(data==1){
                    document.getElementById('zhezhao1').style.display="";
                    data = null;
                }
            }
            function hidder(){
                document.getElementById('zhezhao').style.display="none";
            }
            function hidder1(){
                document.getElementById('zhezhao1').style.display="none";
            }
            function jump(url){
                window.location.href=url;
            }
        </script>
</div>

</body>
</html>