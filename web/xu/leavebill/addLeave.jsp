<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/10
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body>
<a onclick="history.go(-1)">返回上一级</a>
    <form action="${pageContext.request.contextPath }/leave/addLeaver.do" method="post">
        <table>
            <tr>
                <td>请假天数：</td>
                <td><input type="text" name="lbDays"></td>
            </tr>
            <tr>
                <td> 请假原因：</td>
                <td> <input type="text" name="lbContent"></td>
            </tr>
            <tr>
                <td> 请假描述：</td>
                <td> <textarea rows="8" cols="25" name="lbRemark"></textarea></td>
            </tr>

        </table>

        <button type="submit" class="btn btn-info">提交</button>
    </form>
</body>
</html>
