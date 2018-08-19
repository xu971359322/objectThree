<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
 <h1>OA管理系统</h1>
<div class="login-form">
	<div class="close"><span style="color: white;font-size:17px;margin-left:30px;"><strong>Login</strong></span></div>
	<div class="head-info">
		<label class="lbl-1"> </label>
		<label class="lbl-2"> </label>
		<label class="lbl-3"> </label>
	</div>
	<div class="clear"> </div>
	<div class="avtar">
		<img src="${pageContext.request.contextPath}/images/avtar.png" />
	</div>
	<form action="${pageContext.request.contextPath}/user/loginInfo.do" method="post">
		<input type="text" class="text" name="username"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
		<!-- <div class="key"> -->
			<input type="password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
		<!-- </div> -->
		<p style="position:relative;top:-30px;color: red;">${requestScope.err }</p>
		<div class="signin">
			<input type="submit" value="Login" >
		</div>
	</form>


	<a href="${pageContext.request.contextPath}/user/demo.do">111111111111111111111111111111111111111111111111</a>
</div>
</body>
</html>