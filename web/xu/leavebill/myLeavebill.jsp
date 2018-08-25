<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/24
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>


    <style>
        tr,th{
            text-align: center;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/xu/leavebill/addLeave.jsp">添加请假申请</a>
<c:if test="${empty list}">
    <h1>您没有任何请假信息</h1>
</c:if>
<c:if test="${not empty list}">
    <table class="table table-responsive">
        <tr>
            <th>编号</th>
            <th>请假人</th>
            <th>请假天数</th>
            <th>请假事由</th>
            <th>请假备注</th>
            <th>请假时间</th>
            <th>请假状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list }" var="l" varStatus="i">
            <tr align="center">
                <td>${i.count}</td>
                <td>${worker.woName }</td>
                <td>${l.lbDays }</td>
                <td>${l.lbContent }</td>
                <td>${l.lbRemark }</td>
                <td><fmt:formatDate value="${l.lbTime }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                <td>
                    <c:if test="${l.lbStatus ==0 }">
                        初始录入
                    </c:if>
                    <c:if test="${l.lbStatus ==1}">
                        审核中
                    </c:if>
                    <c:if test="${l.lbStatus ==2 }">
                        审核完成
                    </c:if>
                </td>
                <td>
                    <c:if test="${l.lbStatus ==0 }">
                        <a href="${pageContext.request.contextPath }/leave/delLeave.do?id=${l.lbId  }">删除</a>
                        <!-- 	<a>修改</a> -->
                        <a href="${pageContext.request.contextPath }/leave/startProcess.do?lbId=${l.lbId  }">申请请假</a>
                    </c:if>
                    <c:if test="${l.lbStatus ==1 }">
                        <a href="${pageContext.request.contextPath }/report/hisComment.do?id=${l.lbId }">查看审核记录</a>
                    </c:if>
                    <c:if test="${l.lbStatus ==2 }">
                        <a href="${pageContext.request.contextPath }/report/hisComment.do?id=${l.lbId }">审核完成</a>
                    </c:if>

                </td>
            </tr>
        </c:forEach>

    </table>

</c:if>
</body>
</html>
