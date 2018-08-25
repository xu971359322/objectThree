<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <%@ include file="common.jsp"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/dataTables/dataTables.bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"  type="text/css" >
</head>
<body>
<div class="col-md-12">
    <div class="panel">
        <div class="panel-heading">
            <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;分配角色</strong>
               <%-- <input type="text" >    <input type="text" >--%>
            </h3>
            <div class="right">
               <%-- <input type="button" class="btn btn-info" value="增加">--%>
                <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
            </div>
        </div>


        <div class="panel-body">
                <table class="table table-striped table-bordered table-hover" id="myTable" >
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>部门</th>
                    <th>当前角色</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.workerList}" var="info">
                    <tr>
                        <%-- wo_id,wo_role,wo_name,de_name,`or`.ro_name --%>
                        <td>${info.wo_name}</td>
                        <td>${info.de_name}</td>
                        <td>${info.ro_name}</td>
                        <td>👤<a href="${pageContext.request.contextPath}/pjsp/assignMangerInfo.jsp">设置</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables/dataTables.bootstrap.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        $('#myTable').DataTable({
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
            "lengthMenu": [4,20,30,50,100],
            "autoWidth":true
        });
    });
</script>
</body>
</html>
