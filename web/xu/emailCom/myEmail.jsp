<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 15:30
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
    <table class="table table-striped" align="center">
        <thead>
            <tr>
                <th>邮件编号</th>
                <th>邮件标题</th>
                <th>邮件时间</th>
                <th>邮件状态</th>
                <th>操作</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${list}" var="l" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${l.emTitle}</td>
                    <td><fmt:formatDate value="${l.emTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                    <td>
                        <c:if test="${l.emLevel ==1}">
                            普通邮件

                        </c:if>
                        <c:if test="${l.emLevel ==2}">
                            <span style="color:red">重要邮件</span>
                        </c:if>
                    </td>
                    <td>
                        <%--草稿箱--%>
                        <c:if test="${l.emStauts==0}">
                            <a href="${pageContext.request.contextPath}/email/dateilEmail.do?emId=${l.emId}">查看</a>
                            <a onclick="return confirm('你确定要加入草稿箱?')"  href="${pageContext.request.contextPath}/email/updateEmail.do?status=2&emId=${l.emId}&type=${l.emStauts}">加入垃圾箱</a>
                        </c:if>
                         <%--发件箱--%>
                        <c:if test="${l.emStauts==1}">
                            <a href="${pageContext.request.contextPath}/email/dateilEmail.do?emId=${l.emId}">查看</a>
                        </c:if>
                        <%--垃圾箱--%>
                         <c:if test="${l.emStauts==2}">
                             <a href="${pageContext.request.contextPath}/email/dateilEmail.do?emId=${l.emId}">查看</a>
                             <a onclick="return confirm('你确定将该邮件加入草稿箱？')" href="${pageContext.request.contextPath}/email/updateEmail.do?status=0&emId=${l.emId}&type=${l.emStauts}">加入草稿箱</a>
                             <a onclick="return confirm('你确定要删除该邮箱?')" href="${pageContext.request.contextPath}/email/updateEmail.do?status=3&emId=${l.emId}&type=${l.emStauts}">删除</a>
                         </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
