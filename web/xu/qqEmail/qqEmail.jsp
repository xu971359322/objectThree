<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 14:58
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
</head>
<body>
<span onclick="history.go(-1)">返回上一级</span><br>
<table  class="table table-striped"  align="center">
    <thead>
        <tr align="center">
            <th>标题</th>
            <th>发件人</th>
            <th>发送时间</th>
            <th>文件详情</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="l">
        <tr align="center">
            <td>${l.title}</td>
            <td>${l.sendName}</td>
            <td>${l.time}<%--<fmt:formatDate value="${l.time}" pattern="yyyy-MM-dd hh:mm:ss"/>--%></td>
            <td><a href="${pageContext.request.contextPath}/qq/detailEmail.do?id=${l.id}">详情</a></td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
