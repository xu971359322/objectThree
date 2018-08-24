<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/22
  Time: 10:06
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
    <style>
        th,td{
            text-align: center;
        }
    </style>
</head>
<body>
<c:if test="${empty list}">
    <h3>无可办理任务列表</h3>
</c:if>
<c:if test="${not empty list}">
<h1>可办理任务列表</h1>
<table class="table table-striped" align="center">
    <tr>
        <th align="center">任务id</th>
        <th>任务阶段</th>
        <th>创建时间</th>
        <th>文案标题内容</th>
        <th>文案提交人</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list }" var="l">
        <tr align=center>
            <td>${l.taskId }</td>
            <td>${l.taskName }</td>
            <td><fmt:formatDate value="${l.createTime }" pattern="yyyy-MM-dd"/></td>
            <td>${l.report.reTitle }</td>
            <td>${l.name }</td>
            <td>
                <a href="${pageContext.request.contextPath}/report/claimTask.do?taskId=${l.taskId }">添加个人办理</a>
            </td>
        </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>
