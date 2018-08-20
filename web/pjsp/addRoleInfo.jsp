<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="common.jsp"%>
    <style type="text/css">
        .form-group{
            margin-left:30px;
            margin-top: 30px;
        }
        .divInfo{
            display: flex;
        }
        .panel-heading {
            height: 500px;
        }
        body{
            background-color:whitesmoke;
        }
    </style>
</head>
<body>
<div class="divInfo">
        <div class="col-md-5">
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;当前位置是：增加角色</strong></h3><hr>
                        <br><br><br><br><br>
                        <form  action="${pageContext.request.contextPath}/p/ping_searchLS" method="post" class="form-inline" role="form">
                            <div class="form-group">
                                <label class="form-label">角色名称:</label>
                                <input type="text" style="margin-left:10px;width:400px;" name="companyname" value="${sessionScope.clientName}" class="form-control"  placeholder="角色名称">
                            </div>
                            <br><br><br>
                            <div class="form-group">
                                <label class="form-label">备注:</label>
                                <input type="text" style="margin-left:40px;width:400px;" name="uname" value="${sessionScope.manger}" class="form-control"  placeholder="备注">
                            </div>

                    </div>
            </div>
        </div>
        <div class="col-md-7">
            <div class="panel">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;菜单信息</strong>
                        <input type="button" class="btn btn-info" style="float: right" value="返回"  onclick="history.go(-1)"/>
                    </h3>
                    <hr>
                    <iframe src="${pageContext.request.contextPath}/pjsp/menu.jsp" width="850px;" height="400px;" frameborder="0"></iframe>
                    <input type="submit" class="btn btn-info" style="position: relative;top:-462.5px;left:700px;" value="保存"/>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
