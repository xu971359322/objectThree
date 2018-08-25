<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/24
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <style>
        th,td{
            text-align: center;}

    </style>
</head>
<body>
<form action="${pageContext.request.contextPath }/leave/taskOver.do" method="post">
    <input type="hidden" value="${taskId }" name="taskId">
    <table align="center">
        <tr >
            <td>请假天数:</td>
            <td>${leave.lbDays }</td>
        </tr>
        <tr>
            <td>请假原因:</td>
            <td>${leave.lbContent }</td>
        </tr>
        <tr>
            <td>请假备注:</td>
            <td>${leave.lbRemark }</td>
        </tr>
        <tr>
            <td>批注:</td>
            <td><textarea name="comment" cols="80" rows="10"></textarea></td>
        </tr>
        <c:if test="${leave.woId == sessionScope.worker.woId}">
            <tr align="center">
                <td colspan="2">
                    <button class="btn btn-info" type="submit" name="outcome" value="yes">提交申请</button>
                    <button class="btn btn-info" type="submit" name="outcome" value="no">取消提交</button>
                </td>
            </tr>
        </c:if>
        <c:if test="${leave.woId != sessionScope.worker.woId}">
            <tr align="center">
                <td colspan="2">
                    <button class="btn btn-info" type="submit" name="outcome" value="yes">同意</button>
                    <button class="btn btn-info" type="submit" name="outcome" value="no">驳回</button>
                </td>
            </tr>
        </c:if>


    </table>
</form>

<c:if test="${not empty list }">
    <table class="table table-hover" align="center">
        <tr>
            <th>时间</th>
            <th>批注人</th>
            <th>批注信息</th>
        </tr>
        <c:forEach items="${list }" var="l">
            <tr>
                <td><fmt:formatDate value="${l.time }" pattern="yyyy-MM-dd"/></td>
                <td>${l.userId }</td>
                <td>${l.fullMessage }</td>
            </tr>

        </c:forEach>
    </table>

</c:if>
</body>
</html>
