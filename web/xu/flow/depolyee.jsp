<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/9
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/process/deployed.do" method="post" enctype="multipart/form-data">
    <div align="center"><h1>流程部署</h1></div>

    <table  class="table table-striped"  align="center">

        <tr >
            <Td align="center">输入流程名称</Td>
            <Td><input type="text" name="name" /></Td>
        </tr>
        <tr>
            <Td  align="center">添加zip文件</Td>
            <Td><input type="file" name="file" /></Td>
        </tr>
        <Tr align="center">
            <Td colspan="2">
                <button class="btn btn-info" type="submit">确认部署</button>
            </Td>
        </Tr>
            <%--<TR>--%>
                <%--<Th colspan="2">请在下边分别选择流程定义bpmn文件和png文件</Th>--%>
            <%--</TR>--%>
            <%--<tr>--%>
           <%--&lt;%&ndash; <Td>输入流程名称</Td>--%>
            <%--<Td><input type="text" name="name" /></Td>--%>
            <%--</tr>&ndash;%&gt;--%>
            <%--<tr>--%>
                <%--<Td>选择BPMN文件</Td>--%>
                <%--<Td><input type="file" name="resource_bpmn" /></Td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<Td>选择PNG文件</Td>--%>
                <%--<Td><input type="file" name="resource_png" /></Td>--%>
            <%--</tr>--%>
            <%--<Tr>--%>
                <%--<Td colspan="2">--%>
                    <%--<input type="submit" value="确认部署"/>--%>
                <%--</Td>--%>
            <%--</Tr>--%>
    </table>
</form>
</body>
</html>
