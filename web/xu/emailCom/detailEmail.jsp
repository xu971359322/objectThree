<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a onclick="history.go(-1)">返回上一级</a>
<div align="center">
    <h1>${email.emTitle}</h1>
</div>
    邮件正文：<br>
    <h3 style="background-color:gainsboro">&nbsp;&nbsp;${email.emInfomation}</h3><br><br>
    <c:if test="${empty email.emFile}">
        暂无附件
    </c:if>
    <c:if test="${not empty email.emFile}">
        下载附件: <a href="${pageContext.request.contextPath}/email/downFile.do?fileName=${email.emFile}">${email.emFile}</a>
    </c:if>
    <br>
    <br>
<div align="right">
    <h4 >发件人:${worker.woName}</h4>
    <h5>发件时间:<fmt:formatDate value="${email.emTime}" pattern="yyyy-MM-dd hh:mm:ss"/></h5>
</div>
</body>
</html>
