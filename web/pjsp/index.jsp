<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    String root = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/linearicons/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/demo.css">
<link rel="stylesheet" href="<%=root%>/css/fullcalendar.css"/>
<link rel="stylesheet" href="<%=root%>/css/ace.min.css"/>
<link rel="stylesheet" href="<%=root%>/css/ace-rtl.min.css"/>
<link rel="stylesheet" href="<%=root%>/css/ace-skins.min.css"/>
<link rel="stylesheet" href="<%=root%>/css/lobibox.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
<style type="text/css">
    .control-label {
        margin-top: -10px;
    }
    .input-xlarge {
        margin-left: 30px;
    }
    .span2 {
        margin-left: 5px;
    }
</style>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var root = "<%=root%>"; //js中存放当前页面的root路径方便调用
</script>
<body>
<div class="page-content">
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-sm-9">
                    <div id="calendar"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:830px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    创建一个新的日程
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" class="form-inline" role="form" style="display: flex" >
                    <div style="border:0px solid red;margin-top:50px;">
                    <fieldset>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">会议主题：&nbsp;</label><input class="input-xlarge" id="meetingName" type="text" placeholder="placeholder">
                                <div id="message" style="color: red;"></div>
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">会议类型：</label>
                                <select class="input-xlarge" id="meetingType">
                                    <option value="1">Enter</option>
                                    <option value="2">Your</option>
                                    <option value="3">Options</option>
                                    <option value="4">Here!</option>
                                </select>
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <label class="control-label">会议内容：</label>
                                    <span class="add-on">^_^</span>
                                    <input class="span2" id="content" type="text" placeholder="placeholder">
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label" >会议地点：</label>
                                <select class="input-xlarge" id="mpId">
                                    <c:forEach items="${sessionScope.placeAll}" var="info">
                                        <option value="${info.mpId}">${info.mpTitle}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">开始时间：</label>
                                <input class="input-xlarge search-query" id="nowDate" type="date">
                                <input class="search-query" type="time" id="nowTime" />
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">结束时间：</label>
                                <input class="input-xlarge search-query" id="endDate" type="date">
                                <input class="search-query" type="time" id="endTime" />
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">会议状态：</label>
                                <select class="input-xlarge" id="mstate">
                                    <option value=0>待批</option>
                                    <option value=1>已批准</option>
                                    <option value=2>进行中</option>
                                </select>
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <div class="textarea">
                                    <label class="control-label" style="margin-top:-40px;">备注：</label>
                                    <textarea id="remark" cols="37" style="margin-left:57px;" rows="2"> </textarea>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    </div>
                    <div style="border:0px solid red;margin-left:15px;">
                        <div class="panel-heading"><label class="control-label"><center>&nbsp;&nbsp;&nbsp;姓名&nbsp;&nbsp;&nbsp;</center></label>
                            <label class="control-label" style="margin-left:30px;"><center>部门</center></label></div>
                        <iframe src="${pageContext.request.contextPath}/pjsp/deptPerson.jsp" frameborder="0" width="300px;" height="400px;"></iframe>
                    </div>
                </form>
<%--
                <br>
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <label class="sr-only" for="exampleInputEmail2">邮箱</label>
                        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="请输入你的邮箱地址"/>
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="exampleInputPassword2">密码</label>
                        <input type="password" class="form-control" id="exampleInputPassword2" placeholder="请输入你的邮箱密码"/>
                    </div>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"/>
                            记住密码

                        </label>
                    </div>
                    <button type="submit" class="btn btn-default">进入邮箱</button>
                </form>--%>
            </div>
            <div class="modal-footer">
                <button type="button" id="close" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="onSubmit" class="btn btn-primary" data-dismiss="modal">提交更改
                </button>
            </div>
        </div>
    </div>
</div>
<a href="#" title="1111111111111111">Tooltips</a>
<a href="#myModal" id="jd" data-toggle='modal' class='tooltip-info' data-rel='tooltip' title='View'></a>
<script src="<%=root%>/js/jquery.js"></script>
<script src="<%=root%>/js/bootstrap.min.js"></script>
<script src="<%=root%>/js/jquery-ui.js"></script>
<script src="<%=root%>/js/bootstrap-typeahead.js"></script>
<script src="<%=root%>/js/jquery-ui.custom.min.js"></script>
<script src="<%=root%>/js/jquery.ui.touch-punch.js"></script>
<script src="<%=root%>/js/fullcalendar.js"></script>
<script src="<%=root%>/js/ace-extra.min.js"></script>
<script type="text/javascript" src="<%=root%>/js/lobibox.js"></script>
<script type="text/javascript" src="<%=root%>/pjsp/js/myscript.js"></script>
<script type="text/javascript">
    function NOW() {
        var now = new Date();
        var nowYear = now.getFullYear(); //年
        var nowMonth = now.getMonth() + 1 < 10 ? "0" + (now.getMonth() + 1) : now.getMonth(); //月
        var nowDay = now.getDate() < 10 ? "0" + now.getDate() : now.getDate(); //日期
        var nowHour = now.getHours() < 10 ? "0" + now.getHours() : now.getHours(); //时
        var nowMinute = now.getMinutes() < 10 ? "0" + now.getMinutes() : now.getMinutes(); //分
        var nowDate = nowYear + "-" + nowMonth + "-" + nowDay;
        var nowTime = nowHour + ":" + nowMinute;
        $("#nowDate").val(nowDate);
        $("#nowTime").val(nowTime);
    }
</script>
<script type="text/javascript">
    $(function () {
        NOW();
        $(document).tooltip({
            track: true
        });
    });
</script>
</body>
</html>