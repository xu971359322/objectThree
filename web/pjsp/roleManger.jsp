<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="common.jsp"%>
    <style type="text/css">
        .fontInfo{
            font-weight: bold;
        }
        a:hover{
            color:orangered;
        }
    </style>
</head>
<body>
<div class="col-md-12">
    <div class="panel">
        <div class="panel-heading">
            <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;角色管理</strong></h3>
            <div class="right">
                <input type="button" class="btn btn-info" value="增加角色信息"  onclick="location.href='${pageContext.request.contextPath}/pjsp/addRoleInfo.jsp'"/>
                <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
            </div>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>角色名称</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.roleList}" var="info" varStatus="t">
                    <tr>
                        <td>${info.roName}</td>
                        <td>${info.roAvailable}</td>
                        <td>
                            <pre><a href="${pageContext.request.contextPath}/role/delRole.do?roId=${info.roId}"><span class="fontInfo">删除</span></a>      <a href="${pageContext.request.contextPath}/role/changeRole.do?roId=${info.roId}"> <span class="fontInfo">修改</span></a></pre>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
