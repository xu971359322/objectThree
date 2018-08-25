<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/8/24
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>修改会议室</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>
</head>
<body>

<h4>修改会议室</h4>
<table class="table table-striped" align="center">
    <tbody>

    <c:forEach items="${nemeetingroom}" var="z">
    <form action="${pageContext.request.contextPath }/zw/updateonemettingroom.do" method="post">

    <tr  style="background: #F9F9F9" >
        <td align="center">会议室名称</td>
        <td>

            <input type="text" value="${z.title}" name="title">
        </td>
        <td align="center">会议室地址</td>
        <td>

            <input type="text" value="${z.place}" name="place">
        </td>
    </tr>



    <tr style="background: #F9F9F9">
        <td align="center">容纳人数</td>
        <td>

            <input type="number" name="people" value="${z.people}" step="1" min="1" max="2000"/>


        </td>
        <td align="center">会议室描述</td>
        <td>

            <input type="text" value="${z.content}" name="content">

        </td>
    </tr>

        <input type="hidden" name="id" value="${z.id}">
        <tr style="background: #F9F9F9">
            <td align="center">设备描述</td>
            <td>

                <input type="text" value="${z.facility}" name="facility">

            </td>

            <td >
                <input type="submit"  onclick=" return confirm('确定修改该会议室？')" value="修改">
                <a href="${pageContext.request.contextPath }/zw/showallmeeting.do" style="color: #0c1312"><input type="button" value="返回"></a>
            </td>
        </tr>


        <tr style="height: 40px; background: #FFFFFF">
            <td ></td>
        </tr>
        </c:forEach>




    </tbody>
</table>

</body>

</html>
