<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="common.jsp"%>
</head>
<body>
<div class="col-md-12">
    <div class="panel">
        <div class="panel-heading">
            <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;分配角色</strong>
                <input type="text" >    <input type="text" >
            </h3>
            <div class="right">
                <input type="button" class="btn btn-info" value="增加">
                <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
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
</body>
</html>
