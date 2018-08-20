<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@include file="common.jsp"%>
<html>
<body>
<c:forEach items="${sessionScope.personList}" var="info">
    <div class="control-group" style="background-color: white">
        <label class="fancy-checkbox">
            <div style="display: flex;">
                <input type="hidden"  name="wo_id" value="${info.wo_id}">
                <div style="margin: 10px;"><input type="checkbox" name="wo_name"><span>${info.wo_name}</span>&nbsp;&nbsp;&nbsp;</div>
                <div style="margin: 10px;"><span>${info.de_name}</span></div>
            </div>
        </label>
    </div>
</c:forEach>
</body>
</html>
