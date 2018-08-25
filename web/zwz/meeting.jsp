<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/8/22
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>会议</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>
</head>
<body>

<h4> 会议详情</h4>
    <table class="table table-striped" align="center">
        <tbody>
        <c:forEach items="${list}" var="z">

            <tr  style="background: #F9F9F9" >
                <td align="center">标题</td>
                <td>
                        ${z.title}
                </td>
                <td align="center">会议室</td>
                <td>
                    ${z.mptitle}
                </td>
            </tr>



            <tr style="background: #F9F9F9">
                <td align="center">会议室地址</td>
                <td>

                     ${z.place}


                </td>
                <td align="center">会议人数</td>
                <td>
                     ${z.number}人

                </td>
            </tr>

        <form action="${pageContext.request.contextPath }/zw/updatemetting.do" method="post">
            <input type="hidden" name="id" value="${z.id}">
            <tr style="background: #F9F9F9">
                <td align="center">开始时间</td>
                <td>

                  ${z.begintime}
                </td>

                <td align="center">结束时间</td>
                <td>

                        ${z.endtime}
                </td>
            </tr>



        </c:forEach>
        <tr style="height: 40px; background: #FFFFFF">
            <td ></td>
        </tr>

            <tr style="background: #F9F9F9">
                <td align="center">是否批准此会议</td>
                <td>

                     <select name="ratify">
                         <option value="1">批准</option>
                         <option value="3">不批准</option>
                     </select>
                </td>

                <td align="center">会议建议</td>
                <td>
                   <input type="text" name="suggest"><br>
                    <input type="submit" value="审核">
                    <a href="${pageContext.request.contextPath }/zw/showapproval.do" style="color: #0c1312"><input type="button" value="返回"></a>
                </td>

            </tr>

       </form>

        </tbody>
    </table>

</body>
</html>