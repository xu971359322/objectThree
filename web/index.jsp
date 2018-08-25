<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css'/>
</head>
<body>
<h1 style="color:lightslategray;">OA管理系统</h1>
<div class="login-form">
	<div class="close"><span style="color:lightyellow;font-size:21px;margin: 0px 30px">Login</span></div>
	<div class="head-info">
		<label class="lbl-1"></label>
		<label class="lbl-2"></label>
		<label class="lbl-3"></label>
	</div>
	<div class="clear"> </div>
	<div class="avtar">
		<img src="${pageContext.request.contextPath}/images/avtar.png" />
	</div>
	<form action="${pageContext.request.contextPath}/user/loginInfo.do" method="post">
		<input type="text" class="text" name="username" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
		<!-- <div class="key"> -->
		<input type="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
		<!-- </div> -->
		<div class="form-group" style="width:300px;height: 0px;position:relative;left:90px;top:-30px;z-index:9">
			<select class="form-control" style="width:300px;" name="workerRole">
				<c:forEach items="${sessionScope.roleList}" var="role">
					<option value="${role.roId}">${role.roName}</option>
				</c:forEach>
			</select><span style="position:relative;left:213px;top:-30px;color: red;">${requestScope.err }</span>
		</div>
		<br>
		<div class="signin">
			<input type="submit" value="Login" >
		</div>
	</form>
</div>
</body>
</html>