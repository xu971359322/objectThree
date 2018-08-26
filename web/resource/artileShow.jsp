
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

</head>
<body>
<!-- MAIN CONTENT -->
<div class="col-md-6" style="width: 100%">
    <!-- BASIC TABLE -->
    <div class="panel" style="width: 99%">
        <div class="panel-heading">
            <h3 class="panel-title">公司论坛主页</h3>
        </div>
        <div class="panel-body">
                <div class="row clearfix">
                        <table class="table">
                            <thead>
                            <tr class="warning">
                                <th> 帖子类型 </th>
                                <th>帖子类型</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.articleList}" var="li">
                                <tr>
                                    <td>
                                        <a href="${pageContext.request.contextPath }/resou/postType.do?tid=${li.id}"> ${li.typeName}</a>
                                    </td>
                                    <td>
                                        ${li.count}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
            </div>
        </div>



        <!-- END BASIC TABLE -->
    </div>

</div>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables/dataTables.bootstrap.js"></script>
</body>
</html>
