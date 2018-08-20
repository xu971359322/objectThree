<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 17:15
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
    <script src="${pageContext.request.contextPath}/xu/js/email.js"></script>

    <style>
        tr{
            align: center;
        }
    </style>
</head>
<body>
    <a onclick="history.go(-1)">返回上一级</a>
    <h1>发送邮件</h1>
    <form action="${pageContext.request.contextPath}/email/addEmail.do" method="post" enctype="multipart/form-data">
        <table class="table table-striped" align="center">
            <tr>
                <td>邮件标题:</td>
                <td><input type="text" name="title" value="${email.emTitle}" size="50"></td>
            </tr>
            <tr>
                <td>邮件内容:</td>
                <td><textarea name="content" rows="15" cols="80" >${email.emInfomation}</textarea></td>
            </tr>
            <tr>
                <td>附件:</td>
                <td><input type="file" name="file" value="${email.emFile}"></td>
            </tr>
            <tr>
                <td>邮件等级:</td>
                <td>
                    <input type="radio" name="level" value="1" checked>普通
                    <input type="radio" name="level" value="2">重要
                </td>
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
                    <button class="btn btn-info" type="submit" name="sub" value="1">发送</button>
                    <button class="btn btn-info" type="submit" name="sub" value="2">添加草稿箱</button></td>
            </tr>



        </table>
    </form>
</body>
</html>
