<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/21
  Time: 10:32
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
    <table class="table table-striped" align="center">
        <thead>
            <tr align="center">
                <th>任务id</th>
                <th>任务名称</th>
                <th>创建时间</th>
                <th>经办人</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${list }" var="l">
            <tr >
                <td>${l.id }</td>
                <td>${l.name }</td>
                <td><fmt:formatDate value="${l.createTime }" pattern="yyyy-MM-dd"/></td>
                <td>${l.assignee }</td>
                <td>
                    <a href="${pageContext.request.contextPath }/report/taskProcess.do?taskId=${l.id }">办理任务</a>
                    <a href="${pageContext.request.contextPath }/process/queryActiveMap.do?taskId=${l.id }">查看当前流程图</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
