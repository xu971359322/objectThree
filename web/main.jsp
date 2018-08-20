<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
	<title>Home</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
<%--	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/assets/img/favicon.png">--%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/b.tabs.css"/>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.jsp"><img src="${pageContext.request.contextPath}/assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search dashboard...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>
				<div class="navbar-btn navbar-btn-right">
					<a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
				</div>
				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
								<i class="lnr lnr-alarm"></i>
								<span class="badge bg-danger">5</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
								<li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
								<li><a href="#" class="more">See all notifications</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#">Basic Use</a></li>
								<li><a href="#">Working With Data</a></li>
								<li><a href="#">Security</a></li>
								<li><a href="#">Troubleshooting</a></li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span>${worker.woName}</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
								<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
								<li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
								<li><a href="${pageContext.request.contextPath}/user/exit.do"><i class="lnr lnr-exit"></i> <span>退出系统</span></a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div class="content">
					<div class="container">		
			 		<div id="sidebar-nav" class="sidebar" ><!-- style="display:none;" -->
						<div class="sidebar-scroll">
							<nav>
								<ul class="nav">
									<li>
										<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>个人办公</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
										<div id="subPages" class="collapse ">
											<ul class="nav" id="menuSideBar">
												<li mid="tab1" funurl="${pageContext.request.contextPath}/resource.jsp"><a tabindex="-1" href="javascript:void(0);">日程安排</a></li>
												<li mid="tab2" funurl="${pageContext.request.contextPath}/xu/report/"><a tabindex="-1" href="javascript:void(0);">申请报告</a></li>
												<li mid="tab3" funurl="${pageContext.request.contextPath}/bbs.jsp"><a tabindex="-1" href="javascript:void(0);">办理任务</a></li>
												<li mid="tab4" funurl="${pageContext.request.contextPath}/demo.do"><a tabindex="-1" href="javascript:void(0);">在线交流<span style="color:red;">&nbsp;&nbsp;New</span></a></li>
											</ul>
										</div>
									</li>
									<li><a href="${pageContext.request.contextPath}/email.jsp" class=""><i class="lnr lnr-code"></i><span>邮件管理</span></a></li>
									<li><a href="${pageContext.request.contextPath}/office.jsp" class=""><i class="lnr lnr-chart-bars"></i> <span>会议管理</span></a></li>
									<li><a href="${pageContext.request.contextPath}/resource.jsp" class=""><i class="lnr lnr-cog"></i> <span>资源管理</span></a></li>
									<li><a href="${pageContext.request.contextPath}/bbs.jsp" class=""><i class="lnr lnr-alarm"></i> <span>公司论坛</span></a></li>
									<li><a href="${pageContext.request.contextPath}/attendance.jsp" class=""><i class="lnr lnr-text-format"></i> <span>考勤管理</span></a></li>
									<li><a href="${pageContext.request.contextPath}/admin.jsp" class=""><i class="lnr lnr-dice"></i> <span>系统管理</span></a></li>
								</ul>
							</nav>
						</div>
					</div>
				<div style="width:1640px;height:860px;position:relative;top:86px;left:-130px;">
					<div id="mainFrameTabs" style="width:1640px;height:860px;border:0px solid red;">
					         <ul class="nav nav-tabs" role="tablist"> 
					            <li role="presentation" class="active noclose"><a href="#bTabs_navTabsMainPage" data-toggle="tab">首页</a></li> 
					          </ul>
					          <div class="tab-content">
					         	   <div class="tab-pane active" id="bTabs_navTabsMainPage">
						              <div style="text-align: center;font-size: 20px;line-height: 20px;">
										  <iframe src="${pageContext.request.contextPath}/pjsp/programme.jsp" width="1630px"height="800px" frameborder="0"></iframe>
									  </div>
					               </div>
					  		 </div>
					</div>
				</div>
			</div>
		</div>
	<div class="clearfix"></div>
</div>
	<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/scripts/klorofil-common.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/b.tabs.js" ></script>
	<script type="text/javascript">
		$(function() {
			$('a',$('#menuSideBar')).on('click', function(e) {
			    e.stopPropagation();
			    var li = $(this).closest('li');
			    var menuId = $(li).attr('mid');
			    var url = $(li).attr('funurl');
			    var title = $(this).text();
			    //校验登录是否超时，通常使用ajax访问服务端测试登录是否超时
			    //若页面端已有超时自动跳转的处理，则不需要设置该回调
			    var checkLogin = function(){
			      /*  ....*/
			    };
			    $('#mainFrameTabs').bTabsAdd(menuId,title,url,null);
			});

			//插件的初始化
			$('#mainFrameTabs').bTabs({
			    //登录界面URL，用于登录超时后的跳转
			    'loginUrl' : '',
			    //用于初始化主框架的宽度高度等，另外会在窗口尺寸发生改变的时候，也自动进行调整
			    'resize' : function(){
			        //这里只是个样例，具体的情况需要计算
			       /*  $('#mainFrameTabs').height(1000); */
			    }
			});
		});
	</script>
</body>

</html>
