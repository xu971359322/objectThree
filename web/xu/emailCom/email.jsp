<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/xu/emailCom/newEmail.jsp" data-position="top-full-width">新邮件</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/newEmail.do" data-position="top-full-width">未读邮件</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/shouEmail.do" data-position="bottom-right">收件箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/myEmail.do?status=1" data-position="bottom-left">发件箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/myEmail.do?status=0" data-position="top-left">草稿箱</a>
    <a class="btn btn-default btn-toastr" href="${pageContext.request.contextPath}/email/myEmail.do?status=2" data-position="top-right">垃圾箱</a>
</p>
<div>

    <table class="table table-striped" align="center">
        <thead>
            <tr>
                <th>邮件编号</th>
                <th>邮件名</th>
                <th>发件人</th>
                <th>发件时间</th>
                <th>邮件等级</th>
                <th>是否已读</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="l" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>
                        <c:if test="${l.em_level==2}">
                            <span style="color: red;">${l.em_title}</span>
                        </c:if>
                        <c:if test="${l.em_level==1}">
                            <span>${l.em_title}</span>
                        </c:if>
                    </td>
                    <td>${l.worker}</td>
                    <td>${l.em_time}</td>
                    <td>
                        <c:if test="${l.em_level==2}">
                            重要邮件
                        </c:if>
                        <c:if test="${l.em_level==1}">
                            普通邮件
                        </c:if>
                    </td>
                    <c:if test="${l.se_status==0}">
                            <td><span style="color:#2ebd59">未读</span></td>
                    </c:if>
                    <c:if test="${l.se_status==1}">
                            <td><span style="color:gray ">已读</span></td>
                    </c:if>
                    <td><a href="${pageContext.request.contextPath}/email/lookEmail.do?emId=${l.em_id}&seId=${l.se_id}">查看</a></td>
                </tr>

            </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
