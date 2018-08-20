<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/xu/js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
</head>
<body>
	<table class="table table-striped"  align="center">
		<Tr>
			<th>流程定义ID</th>
			<th>流程定义名称</th>
			<th>流程定义的部署ID</th>
			<th>BPMN</th>
			<th>PNG</th>
			<th>版本</th>
			<th>删除</th>
		</Tr>
		<c:forEach items="${requestScope.list }" var="p">
			<Tr align="center">
				<Td>${p.id }</Td>
				<Td>${p.name }</Td>
				<Td>${p.deploymentId }</Td>
				<Td>
					<a target="_blank" href="${pageContext.request.contextPath}/process/showResources.do?processDefinitionId=${p.id }&type=bpmn">${p.resourceName }</a>
				</Td>
				<Td>
				
					<a target="_blank" href="${pageContext.request.contextPath}/process/showResources.do?processDefinitionId=${p.id }&type=png">${p.diagramResourceName }</a>
				
				</Td>
				<Td>${p.version }</Td>
				<Td>
					<a href="${pageContext.request.contextPath}/process/delProcess.do?id=${p.deploymentId }">删除</a>
				</Td>
			</Tr>
			</c:forEach>
	</table>
</body>
</html>