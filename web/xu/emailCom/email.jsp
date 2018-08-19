<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13
  Time: 20:16
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
<p class="demo-button">
    <a class="btn btn-default btn-toastr"  data-position="top-full-width">新邮件</a>
    <a class="btn btn-default btn-toastr" data-position="bottom-right">收件箱</a>
    <a class="btn btn-default btn-toastr"  data-position="bottom-left">发件箱</a>
    <a class="btn btn-default btn-toastr"  data-position="top-left">草稿箱</a>
    <a class="btn btn-default btn-toastr"  data-position="top-right">垃圾箱</a>
</p>
<div>

    <table>
        <thead>
            <tr>
                <th></th>
            </tr>

        </thead>

    </table>

</div>
</body>
</html>
