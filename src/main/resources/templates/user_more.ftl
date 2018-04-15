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
        <div class="col-xs-12 title" style="margin-top: 20px;">
            <div class="data2" id="main" style="width: 100%;height:265px;"></div>
        </div>
        <div class="col-xs-12 title" style="margin-top: 10px;">
            <div class="data3" id="main2" style="width: 100%;height:265px;"></div>
        </div>
    </div>

</div>
<div class="footer">
    <div class="footer-copyright">
        <div class="container">
            <div class="row">
                <div class="col-xs-4 text-center" id="1" onclick="window.location.href= '/record/${userId}';return false"><p id="p1" class="title pColor2">首页</p></div>
                <div class="col-xs-4 text-center" ><p id="p2" class="title pColor1">分析</p></div>
                <div class="col-xs-4 text-center" id="3" onclick="window.location.href= '/record/home/${userId}';return false"><p id="p3" class="title pColor2">我的</p></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var myChart0 = echarts.init(document.getElementById('main'));
    var option0 = {
        title: {
            text: '最近半个月体重变化'
        },
        grid: {
            top:'15%',
            left: '3%',
            right: '3%',
            bottom: '5%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ${data.date}
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: function (value,index) {
                    return value.toFixed(1);
                }
            },
            min:function (value) {
                return value.min - 0.25;
            },
            max:function (value) {
                return value.max + 0.25;
            }
        },
        series: [{
            data: ${data.weight},
            type: 'line',
            symbol: 'triangle',
            symbolSize: 10,
            lineStyle: {
                normal: {
                    color: 'green',
                    width: 2,
                    type: 'dashed'
                }
            },
            itemStyle: {
                normal: {
                    borderWidth: 1,
                    borderColor: 'yellow',
                    color: 'blue'
                }
            }
        }]
    };
    myChart0.setOption(option0);
    var myChart = echarts.init(document.getElementById('main2'));
    var option = {
        title: {
            text: '最近一个月体重变化'
        },
        grid: {
            top:'15%',
            left: '3%',
            right: '3%',
            bottom: '5%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ${month.date}
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: function (value,index) {
                    return value.toFixed(1);
                }
            },
            min:function (value) {
                return value.min - 0.25;
            },
            max:function (value) {
                return value.max + 0.25;
            }
        },
        series: [{
            data: ${month.weight},
            type: 'line',
            smooth: true
        }]
    };
    myChart.setOption(option);

</script>
</body>
</html>