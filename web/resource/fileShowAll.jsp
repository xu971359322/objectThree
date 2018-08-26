
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>客户销售管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath }/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath }/assets/img/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/js/dataTables/dataTables.bootstrap.css">

    <style type="text/css">
        table{
            text-align: center;
        }
    </style>
</head>
<body>
<!-- MAIN CONTENT -->
        <div class="col-md-6" style="width: 100%">
            <!-- BASIC TABLE -->
            <div class="panel" style="width: 99%">
                <div class="panel-heading">
                    <h3 class="panel-title">公司所有文档（不包括私密文档）</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive" scroll="no">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>文件名称</th>
                                <th>文件类型</th>
                                <th>文件大小</th>
                                <th>文件上传者</th>
                                <th>上传时间</th>
                                <th>文件下载次数</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.resouShowAllList}" var="li" varStatus="k">
                                <tr>
                                    <td>${li.fid+1}</td>
                                    <td>${li.fname}</td>
                                    <td>${li.type}</td>
                                    <td>${li.lenth}</td>
                                    <td>${li.woname}</td>
                                    <td><fmt:formatDate
                                            type="date"
                                            value="${li.ftime}"
                                            dateStyle="default"
                                    /></td>
                                    <td>${li.count}</td>
                                    <td><a href="${pageContext.request.contextPath }/resou/downFile.do?fileId=${li.fileId}"><i class="glyphicon glyphicon-save"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/resou/deleteFile.do?fileId=${li.fileId}" ><i class="glyphicon glyphicon-trash"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                        <div class="panel-heading" style="float: right;">

                            <a href="${pageContext.request.contextPath}/resou/Load.do"><button type="button" class="btn btn-default">上传新文件</button></a>

                        </div>
                    </div>
                </div>



                <!-- END BASIC TABLE -->
            </div>

</div>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables/dataTables.bootstrap.js"></script>
<script type="text/javascript">
    /*JavaScript
    var now = new Date();
    myDate.value=now.getFullYear() + "-"+ (now.getMonth()+1)+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();*/
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
                "sSearch": "全局:",
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
