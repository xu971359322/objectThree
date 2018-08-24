<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 11:35
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
    <style>
        th,td{
            text-align: center;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/xu/report/addReport.jsp">新增文案</a>
<c:if test="${empty list}">
    <h1>您还没有创建任何文案</h1>
</c:if>
<c:if test="${not empty list}">
    <table class="table table-striped" align="center">
        <thead>
            <tr>
                <th>编号</th>
                <th>标题</th>
                <th>创建人</th>
                <th>创建时间</th>
                <th>文案状态</th>
                <th>操作</th>
            </tr>
        </thead>
    <c:forEach items="${list}" var="l" varStatus="i">
        <tbody>
            <tr>
                <td>${i.count}</td>
                <td>${l.reTitle}</td>
                <td>${worker.woName}</td>
                <td><fmt:formatDate value="${l.reTime }" pattern="yyyy-MM-dd"/></td>
                <td>
                    <c:if test="${l.reStatus ==0 }">
                        初始录入
                    </c:if>
                    <c:if test="${l.reStatus ==1}">
                        审核中
                    </c:if>
                    <c:if test="${l.reStatus ==2 }">
                        审核完成
                    </c:if>
                </td>
                <td>
                    <c:if test="${l.reStatus ==0 }">
                        <a href="${pageContext.request.contextPath }/report/delLeave.do?id=${l.reId }">删除</a>
                        <!-- 	<a>修改</a> -->
                        <a href="${pageContext.request.contextPath }/report/startProcess.do?reId=${l.reId }">提交文案</a>
                    </c:if>
                    <c:if test="${l.reStatus ==1 }">
                        <a href="${pageContext.request.contextPath }/report/hisComment.do?id=${l.reId }">查看审核记录</a>
                    </c:if>
                    <c:if test="${l.reStatus ==2 }">
                        <a href="${pageContext.request.contextPath }/report/hisComment.do?id=${l.reId }">审核完成</a>
                    </c:if>


                </td>
            </tr>

        </tbody>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
