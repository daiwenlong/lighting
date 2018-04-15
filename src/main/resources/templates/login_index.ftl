<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>
<div class="form-bg" style="padding: 20px 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" action="/user" method="post">
                    <span class="heading">用户登录</span>
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputEmail3" name="userName" placeholder="用户名或电子邮件">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" id="inputPassword3" name="userPwd" placeholder="密　码">
                        <i class="fa fa-lock"></i>
                        <span class="message">${result}</span>
                    </div>

                    <div class="form-group">
                        <div class="main-checkbox">
                            <input type="checkbox" value="None" id="checkbox1" name="check"/>
                            <label for="checkbox1"></label>
                        </div>
                        <span class="text">Remember me</span>
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>