<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>html5原生自带的日期控件和时间控件</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
        $(function () {
            NOW();
        });
        //初始化时间控件
        function NOW() {
            var now = new Date();
            var nowYear = now.getFullYear(); //年
            var nowMonth = now.getMonth() + 1 < 10 ? "0" + (now.getMonth() + 1) : now.getMonth(); //月
            var nowDay = now.getDate() < 10 ? "0" + now.getDate() : now.getDate(); //日期
            var nowHour = now.getHours() < 10 ? "0" + now.getHours() : now.getHours(); //时
            var nowMinute = now.getMinutes() < 10 ? "0" + now.getMinutes() : now.getMinutes(); //分
            var nowDate = nowYear + "-" + nowMonth + "-" + nowDay;
            var nowTime = nowHour + ":" + nowMinute;
            $("#nowDate").val(nowDate);
            $("#nowTime").val(nowTime);
        }
        $(function () {
            $("#btnNow").click(function () {
                NOW();
            });
        });
    </script>
</head>
<body>
<div>
    <input type="date" id="nowDate" />
    <input type="time" id="nowTime" />
    <input type="button" id="btn" value="获取时间" />
    <input type="button" id="btnNow" value="当前时间" />
</div>
</body>
</html>
