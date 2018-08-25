
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
            <h3 class="panel-title">公司论坛主页</h3>
        </div>
        <div class="panel-body">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>
                                    编号
                                </th>
                                <th>
                                    产品
                                </th>
                                <th>
                                    交付时间
                                </th>
                                <th>
                                    状态
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    1
                                </td>
                                <td>
                                    TB - Monthly
                                </td>
                                <td>
                                    01/04/2012
                                </td>
                                <td>
                                    Default
                                </td>
                            </tr>
                            <tr class="success">
                                <td>
                                    1
                                </td>
                                <td>
                                    TB - Monthly
                                </td>
                                <td>
                                    01/04/2012
                                </td>
                                <td>
                                    Approved
                                </td>
                            </tr>
                            <tr class="error">
                                <td>
                                    2
                                </td>
                                <td>
                                    TB - Monthly
                                </td>
                                <td>
                                    02/04/2012
                                </td>
                                <td>
                                    Declined
                                </td>
                            </tr>
                            <tr class="warning">
                                <td>
                                    3
                                </td>
                                <td>
                                    TB - Monthly
                                </td>
                                <td>
                                    03/04/2012
                                </td>
                                <td>
                                    Pending
                                </td>
                            </tr>
                            <tr class="info">
                                <td>
                                    4
                                </td>
                                <td>
                                    TB - Monthly
                                </td>
                                <td>
                                    04/04/2012
                                </td>
                                <td>
                                    Call in to confirm
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
                <c:forEach items="${requestScope.articleList}" var="li">
                    <tr>
                        <div>
                            <td>
                                 ${li.typeName}
                            </td>
                                帖子总数${li.count}
                            进入
                        </div>
                    </tr>
                </c:forEach>
            </table>
        </div>



        <!-- END BASIC TABLE -->
    </div>

</div>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables/jquery.dataTables.js"></script>
<script src="${pageContext.request.contextPath }/js/dataTables/dataTables.bootstrap.js"></script>
</body>
</html>
