<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/21
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<form action="${pageContext.request.contextPath }/report/taskOver.do" method="post">
    <input type="hidden" value="${taskId }" name="taskId">
    <input type="hidden" value="0" name="money">
    <table align="center">
        <tr >
            <td>文案标题：</td>
            <td>${report.reTitle}</td>
        </tr>
        <tr>
            <td>文案内容：</td>
            <td>${report.reContent }</td>
        </tr>
        <tr>
            <td>文案费用：</td>
            <td>${report.money }</td>
        </tr>
        <tr>
            <td>文案附件：</td>
            <td>
                <c:if test="${empty report.reFile}">
                    暂无附件
                </c:if>
                <c:if test="${not empty report.reFile}">
                   <a href="${pageContext.request.contextPath}/email/downFile.do?fileName=${report.reFile}">${report.reFile}</a>  (点击下载附件)
                </c:if>
            </td>
        </tr>
        <tr>
            <td>添加文案意见：</td>
            <td><textarea name="comment" cols="80" rows="10"></textarea></td>
        </tr>
        <c:if test="${report.woId == sessionScope.worker.woId}">
            <tr align="center">
                <td colspan="2">
                    <button class="btn btn-info" type="submit" name="outcome" value="yes">提交申请</button>
                    <button class="btn btn-info" type="submit" name="outcome" value="no">取消提交</button>
                </td>
            </tr>
        </c:if>
        <c:if test="${report.woId != sessionScope.worker.woId}">
            <tr align="center">
                <td colspan="2">
                    <button class="btn btn-info" type="submit" name="outcome" value="yes">同意</button>
                    <button class="btn btn-info" type="submit" name="outcome" value="no">驳回</button>
                </td>
            </tr>

        </c:if>
    </table>

    <%--<c:if test="${empty list}">--%>
        <%--<h1>暂无审批意见</h1>--%>
    <%--</c:if>--%>
    <br>
    <br>
    <div align="center">
        <h1>历史批注信息</h1>
    </div>
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
