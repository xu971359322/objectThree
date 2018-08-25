<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
</head>
<body>
<div id="wrapper">
            <div class="container-fluid">
                <div class="col-md-7">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;日程信息</strong></h3>
                            <div class="right">
                                <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i>
                                </button>
                                <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                            </div>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.meetingAll}" var="info">
                                        <tr>
                                            <td>${info.m_title}</td>
                                            <td>${info.mp_title}</td>
                                            <td>${fn:substring (info.m_begintime,0,16)}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-md-5">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;邮件信息</strong></h3>
                                <div class="right">
                                    <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i>
                                    </button>
                                    <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.emailAll}" var="info">
                                        <tr>
                                            <td>${info.emTitle}</td>
                                            <td>
                                                <fmt:formatDate value="${info.emTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                <div class="col-md-5">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;公共信息</strong></h3>
                            <div class="right">
                                <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i>
                                </button>
                                <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                            </div>
                        </div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Steve</td>
                                    <td>Jobs</td>
                                    <td>@steve</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Simon</td>
                                    <td>Philips</td>
                                    <td>@simon</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Jane</td>
                                    <td>Doe</td>
                                    <td>@jane</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Jane</td>
                                    <td>Doe</td>
                                    <td>@jane</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Jane</td>
                                    <td>Doe</td>
                                    <td>@jane</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
     </div>
</div>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/scripts/klorofil-common.js"></script>
</body>
</html>
