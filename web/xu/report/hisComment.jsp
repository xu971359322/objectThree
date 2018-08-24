<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/22
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/jquery-1.8.3.min.js"></script>
    <style>
        th,td{
            text-align: center;
        }
    </style>
</head>
<body>
<a onclick="history.go(-1)">返回上一级</a>
<c:if test="${not empty list}">
    <table  class="table table-hover" align="center">
        <thead>
        <tr>
            <th>时间</th>
            <th>批注人</th>
            <th>批注信息</th>
        </tr>
        </thead>
        <c:forEach items="${list }" var="l">
            <tbody>
            <tr>
                <td><fmt:formatDate value="${l.time }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td>${l.userId }</td>
                <td>${l.fullMessage }</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</c:if>
</form>
</body>
</html>
