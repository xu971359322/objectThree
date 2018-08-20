<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13
  Time: 19:08
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

    <script src="${pageContext.request.contextPath }/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath }/js/dataTables/dataTables.bootstrap.js"></script>

</head>
<body>
<p class="demo-button">
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/xu/emailCom/newEmail.jsp" data-position="top-full-width">新邮件</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/newEmail.do" data-position="top-full-width">未读邮件</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/shouEmail.do" data-position="bottom-right">收件箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/myEmail.do?status=1" data-position="bottom-left">发件箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/myEmail.do?status=0" data-position="top-left">草稿箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/myEmail.do?status=2" data-position="top-right">垃圾箱</a>
</p>
    <table class="table table-striped" align="center">
        <thead>
            <tr>
                <th>文件夹名称</th>
                <th>邮件数量</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <tr>
            <td>收件箱</td>
            <td>${shou}</td>
            <td><a href="${pageContext.request.contextPath}/email/shouEmail.do">打开</a></td>
        </tr>
        <c:forEach items="${list}" var="l">
            <c:if test="${l.em_stauts == 0}">
                <tr>
                    <td>草稿箱</td>
                    <td>${l.eunm}</td>
                    <td><a href="${pageContext.request.contextPath}/email/myEmail.do?status=0">打开</a></td>
                </tr>
            </c:if>
            <c:if test="${l.em_stauts == 1}">
                <tr>
                    <td>发件箱</td>
                    <td>${l.eunm}</td>
                    <td><a href="${pageContext.request.contextPath}/email/myEmail.do?status=1">打开</a></td>
                </tr>
            </c:if>
            <c:if test="${l.em_stauts == 2}">
                <tr>
                    <td>垃圾箱</td>
                    <td>${l.eunm}</td>
                    <td><a href="${pageContext.request.contextPath}/email/myEmail.do?status=2">打开</a></td>
                </tr>
            </c:if>
        </c:forEach>

        </tbody>

    </table>
</body>
</html>
