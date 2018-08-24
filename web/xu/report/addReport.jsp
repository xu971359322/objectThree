<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 19:09
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
<style>
    /*th,td{*/
        /*text-align: center;*/
    /*}*/

</style>
</head>
<body>
    <form action="${pageContext.request.contextPath }/report/addReport.do" method="post" enctype="multipart/form-data">
        <table class="table table-striped" align="center">
            <tbody>
                <tr>
                    <td>标题</td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td>费用申请</td>
                    <td><input type="number" name="money" value="0"></td>
                </tr>
                <tr>
                    <td>详情介绍</td>
                    <td><textarea name="content" rows="10" cols="50"></textarea></td>
                </tr>

                <tr>
                    <td>添加附件</td>
                    <td><input type="file" name="file"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button class="btn btn-info" type="submit">提交</button>
                    </td>
                </tr>
            </tbody>
        </table>

    </form>
</body>
</html>
