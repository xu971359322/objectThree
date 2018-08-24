<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 14:58
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


    <script src="${pageContext.request.contextPath }/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath }/js/dataTables/dataTables.bootstrap.js"></script>
</head>
<body>
<span onclick="history.go(-1)">返回上一级</span><br>
<table  class="table table-striped"  align="center" n  好;>
    <thead>
        <tr align="center">
            <th>标题</th>
            <th>发件人</th>
            <th>发送时间</th>
            <th>文件详情</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="l">
        <tr align="center">
            <td>${l.title}</td>
            <td>${l.sendName}</td>
            <td>${l.time}<%--<fmt:formatDate value="${l.time}" pattern="yyyy-MM-dd hh:mm:ss"/>--%></td>
         </tr>

    </c:forEach>
    </tbody>
</table>


<script language="JavaScript">
    $(document).ready(function () {

        $('#dataTables-example').dataTable({
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "lengthMenu": [5,10,20,50,100],
            "autoWidth":true

        });




    });
</script>
</body>
</html>
