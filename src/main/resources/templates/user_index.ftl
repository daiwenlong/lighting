<!DOCTYPE html>
<html lang="zh" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="/js/echarts.common.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/lighting.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-12" style="margin-top: 20px;">
                <div class="panel panel-primary">
                    <div class="panel-heading">记录今日体重</div>
                    <div class="panel-body">
                        <div class="col-xs-12 text-center"><span style="font-size: 20px;">4月14日   周六</span></div>
                        <div class="col-xs-12 text-center">

                            <div class="input-group" style="margin-top: 20px;">
                                <span class="input-group-addon" id="sizing-addon2">今日体重</span>
                                <input type="number" id="weight" class="form-control" placeholder="单位：kg" aria-describedby="sizing-addon2">
                            </div>
                        </div>
                        <div class="col-xs-12 text-center" style="margin-top: 20px;">
                            <button type="button" class="btn btn-primary" style="width: 100%" onclick="toSubmit2()">提交</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12" style="margin-top: 20px;">
            <div id="main" style="width: 100%;height:300px;"></div>
        </div>
    </div>
    <div class="footer">
        <div class="footer-copyright">
            <div class="container">
                <div class="row">
                    <div class="col-xs-4 text-center" id="1"><p id="p1" class="title pColor1">首页</p></div>
                    <div class="col-xs-4 text-center" id="2"><p id="p2" class="title pColor2">分析</p></div>
                    <div class="col-xs-4 text-center" id="3"><p id="p3" class="title pColor2">我的</p></div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            title: {
                text: '最近一周体重变化'
            },
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                  formatter: function (value,index) {
                      return value.toFixed(1);
                  }
                },
                min:function (value) {
                    return value.min - 0.5;
                },
                max:function (value) {
                    return value.max + 0.5;
                }
            },
            series: [{
                data: [69.80, 69.50, 69.60, 69.30, 69.10, 68.70, 68.50],
                type: 'line'
            }]
        };
        myChart.setOption(option);
        
        function  toSubmit2() {
            var weight = $("#weight").val();
            $.ajax({
                type:"post",
                url:"/user/addWeight",
                data:{weight:weight},
                dataType:"json",
                success:function (data) {
                    if("1"==data) {
                        window.location.reload();
                    }
                }
            })
        }
    </script>
</body>
</html>