<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/jquery-1.8.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/qqEmail.js"></script>
</head>
<body>
<p class="demo-button">
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/xu/emailCom/newEmail.jsp" data-position="top-full-width">发送QQ邮箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/qq/lookQQEmail.do" data-position="top-full-width">查看我的QQ邮箱</a>
</p>
    <div align="center"><h1>发送QQ邮件</h1></div>
    <h3 style="color:green;">${err}</h3>
    <form action="${pageContext.request.contextPath}/qq/addEmail.do" method="post">

        <table class="table table-striped" align="center">
            <tr>
                <td>邮件标题:</td>
                <td><input type="text" name="title" size="50"></td>
            </tr>
            <tr>
                <td>邮件内容:</td>
                <td><textarea name="content" rows="18" cols="100"></textarea></td>
            </tr>
            <tr>
                <td>输入邮箱:</td>
                <td><input type="text" name="email" ></td>
            </tr>
            <tr>
                <td>选择收件人:</td>
                <td>
                    <input type="checkbox" name="person" value="1">开发部
                    <input type="checkbox" name="person" value="2">财务部
                    <input type="checkbox" name="person" value="3">人事部
                    <div id="meetPeople"></div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="btn btn-info" type="submit" name="sub">发送</button>
                    <button class="btn btn-info" name="sub">返回</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
