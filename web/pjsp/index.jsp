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
    var root = "<%=root%>";
</script>
<body>
<div class="page-content">
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-sm-10">
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
                    创建一个新的会议
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" class="form-inline" role="form" style="display: flex" >
                    <div style="border:0px solid red;margin-top:43px;margin-left:20px;">
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
                                    <option value="1">一般员工会议</option>
                                    <option value="2">高层会议</option>
                                </select>
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <div class="input-prepend">
                                    <label class="control-label">会议内容：</label>
                                    <span class="add-on">^_^</span>
                                    <input class="span2" style="width:270px;" id="content" type="text" placeholder="placeholder">
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
                                <input class="input-xlarge search-query" style="width:200px;" id="nowDate" type="date">
                                <input class="search-query" type="time" id="nowTime" />
                            </div>
                        </div>
                        <br>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">结束时间：</label>
                                <input class="input-xlarge search-query" style="width:200px;" id="endDate" type="date">
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
                    <div style="border:0px solid red;margin-left:40px;overflow:scroll;height:450px;width: 300px;overflow-x:hidden">
                        <div class="panel-heading"><label class="control-label"><center>&nbsp;&nbsp;&nbsp;姓名&nbsp;&nbsp;&nbsp;</center></label>
                            <label class="control-label" style="margin-left:30px;"><center>部门</center></label></div>
                        <%--<iframe src="${pageContext.request.contextPath}/pjsp/deptPerson.jsp" frameborder="0" width="300px;" height="400px;"></iframe>--%>
                        <c:forEach items="${sessionScope.personList}" var="info">
                            <%--<div class="control-group" style="background-color: white;">;--%>
                                <label class="fancy-checkbox">
                                    <div style="display: flex;border:1px solid gainsboro;width:200px;" id="${info.wo_id}">
                                        <div style="margin: 10px;"><input type="checkbox" name="idcheckBox"><span>${info.wo_name}</span>&nbsp;&nbsp;&nbsp;</div>
                                        <div style="margin: 10px;"><span>${info.de_name}</span></div>
                                    </div>
                                </label>
                            <%--</div>--%>
                        </c:forEach>
                    </div>
                </form>
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


<div class="modal fade" id="myModalchange" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:830px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabelChange">
                    修改会议信息
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" class="form-inline" role="form" style="display: flex" >
                    <div style="border:0px solid red;margin-top:43px;margin-left:20px;">
                        <fieldset>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">会议主题：&nbsp;</label><input class="input-xlarge" id="meetingNameChange" type="text" placeholder="placeholder">
                                    <div id="messageChange" style="color: red;"></div>
                                </div>
                            </div>
                            <br>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">会议类型：</label>
                                    <select class="input-xlarge" id="meetingTypeChange">
                                        <option value=1>一般员工会议</option>
                                        <option value=2>高层会议</option>
                                    </select>
                                </div>
                            </div>
                            <br>
                            <div class="control-group">
                                <div class="controls">
                                    <div class="input-prepend">
                                        <label class="control-label">会议内容：</label>
                                        <span class="add-on">^_^</span>
                                        <input class="span2"  style="width:270px;" id="contentChange" type="text" placeholder="placeholder">
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label" >会议地点：</label>
                                    <select class="input-xlarge" id="mpIdChange">
                                        <c:forEach items="${sessionScope.placeAll}" var="info">
                                            <option value=${info.mpId}>${info.mpTitle}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <br>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">开始时间：</label>
                                    <input class="input-xlarge search-query" style="width:200px;" id="nowDateChange" type="date">
                                    <input class="search-query" type="time" id="nowTimeChange" />
                                </div>
                            </div>
                            <br>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">结束时间：</label>
                                    <input class="input-xlarge search-query" style="width:200px;" id="endDateChange" type="date">
                                    <input class="search-query" type="time" id="endTimeChange" />
                                </div>
                            </div>
                            <br>
                            <div class="control-group">
                                <div class="controls">
                                    <label class="control-label">会议状态：</label>
                                    <select class="input-xlarge" id="mstateChange">
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
                                        <textarea id="remarkChange" cols="37" style="margin-left:57px;" rows="2"> </textarea>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <input type="hidden" id="mIdInfomation">
                    <div style="border:0px solid red;margin-left:40px;overflow:scroll;height:450px;width: 300px;overflow-x:hidden">
                        <div class="panel-heading"><label class="control-label"><center>&nbsp;&nbsp;&nbsp;姓名&nbsp;&nbsp;&nbsp;</center></label>
                            <label class="control-label" style="margin-left:30px;"><center>部门</center></label></div>
                            <c:forEach items="${sessionScope.personList}" var="info">
                                <label class="fancy-checkbox">
                                    <div style="display: flex;border:1px solid gainsboro;width:200px;" id="${info.wo_id}"><%----%>
                                        <div style="margin: 10px;"><input type="checkbox" name="idcheckBoxNew" value="${info.wo_id}"><span>${info.wo_name}</span>&nbsp;&nbsp;&nbsp;</div>
                                        <div style="margin: 10px;"><span>${info.de_name}</span></div>
                                    </div>
                                </label>
                            </c:forEach>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" id="closeChange" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="onSubmitChange" class="btn btn-primary" data-dismiss="modal">修改信息
                </button>
            </div>
        </div>
    </div>
</div>
<%--<a href="#" title="1111111111111111">Tooltips</a>--%>
<a href="#myModal" id="jd" data-toggle='modal' class='tooltip-info' data-rel='tooltip' title='View'></a>
<a href="#myModalchange" id="change" data-toggle='modal' class='tooltip-info' data-rel='tooltip' title='View'></a>
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
/*        $(document).tooltip({
            track: true
        });*/
    });
</script>
</body>
</html>