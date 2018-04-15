<!DOCTYPE html>
<html lang="zh" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/lighting.css">
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-xs-12 title" style="margin-top: 20px;">
            <div class="panel panel-primary">
                <div class="panel-heading">更多记录</div>
                <div class="panel-body">
                 <#list list as info>
                     <div class="col-xs-6 text-center" style="margin-top:10px;font-size: 16px">
                         ${(info.date?string("yyyy-MM-dd"))!}
                     </div><div class="col-xs-6 text-center"  style="margin-top:10px;font-size: 16px">
                     ${info.weight}  kg
                 </div>
                 </#list>
                </div>
            </div>

        </div>

    </div>

</div>
<div class="footer">
    <div class="footer-copyright">
        <div class="container">
            <div class="row">
                <div class="col-xs-4 text-center" id="1" onclick="window.location.href= '/record/${userId}';return false"><p id="p1" class="title pColor2">首页</p></div>
                <div class="col-xs-4 text-center" onclick="window.location.href= '/record/more/${userId}';return false"><p id="p2" class="title pColor2">分析</p></div>
                <div class="col-xs-4 text-center" id="3"><p id="p3" class="title pColor1">我的</p></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
</script>
</body>
</html>