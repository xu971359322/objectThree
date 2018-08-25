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
    <title>通知会议人员</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>
</head>
<body>

<h4> 通知会议人员</h4>
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

        <form action="${pageContext.request.contextPath }/zw/informman.do" method="post">
            <input type="hidden" name="id" value="${z.id}">
            <input type="hidden" name="iid" value="${z.iid}">
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
                <td align="center">通知方式</td>
                <td>

                     <input type="checkbox" name="mailbox" value="邮箱">电子邮箱
                    <input type="checkbox" checked="checked" name="message" value="短信">手机短信
                </td>

                <td align="center"></td>
                <td>
                    <input type="submit"  onclick="alert('已成功通知')"  value="通知">
                    <a href="${pageContext.request.contextPath }/zw/seleratifymeeting.do" style="color: #0c1312"><input type="button" value="返回"></a>
                </td>

            </tr>

       </form>

        </tbody>
    </table>

</body>
</html>