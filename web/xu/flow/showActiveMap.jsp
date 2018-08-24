<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="margin:0px">
	<img style="position: absolute;left:0px;top:0px" src="${pageContext.request.contextPath }/process/showResources.do?processDefinitionId=${processDefinitionId}&type=png">
	<div style="position: absolute;border:2px red solid;left:${x}px;top:${y-2}px;width:${width-2}px;height:${height-2}px"></div>

	<a onclick="history.go(-1)">返回上一级</a>
</body>
</html>