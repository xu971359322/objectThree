<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="common.jsp"%>
    <style type="text/css">
        .form-groupNew{
            margin-left:30px;
            margin-top: 30px;
        }
        .divInfo{
            display: flex;
        }
        .panel-heading {
            height: 500px;
        }
        body{
            background-color:whitesmoke;
        }
    </style>
    <style type="text/css">
        .form-inline {
            background-color: white;
        }
        .divInfoNew{
            margin-left:10px;
        }
        .menuName{
            font-weight:bold;
            font-size:large;
        }
    </style>
</head>
<body>
<div class="divInfo">
        <div class="col-md-5">
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;当前位置是：增加角色</strong></h3><hr>
                        <br><br><br><br><br>
                        <form action="${pageContext.request.contextPath}/system/addRole.do" method="post" class="form-inline" role="form">
                            <div class="form-group form-groupNew">
                                <label class="form-label">角色名称:</label>
                                <input type="text" style="margin-left:10px;width:400px;" name="roleName" class="form-control"  placeholder="角色名称">
                            </div>
                            <br><br><br>
                            <div class="form-group form-groupNew">
                                <label class="form-label">备注:</label>
                                <input type="text" style="margin-left:40px;width:400px;" name="roleRemark" class="form-control"  placeholder="备注">
                            </div>
                    </div>
            </div>
        </div>
        <div class="col-md-7">
            <div class="panel" style="border:0px solid red;margin-left:10px;overflow:scroll;height:500px;width:900px;overflow-x:hidden">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong><span style="color:deepskyblue;vertical-align:middle">●</span>&nbsp;菜单信息</strong>
                        <input type="button" class="btn btn-info" style="float: right" value="返回"  onclick="history.go(-1)"/>
                    </h3>
                    <hr>
                    <div style="border-left:0.5px solid black">
                        <div class="form-inline" role="form">
                            <c:forEach items="${requestScope.teamRoleListBycondition}" var="k" varStatus="st">
                                <fieldset style="border-color:#E2DED6;border-width:1px;border-style:solid;">
                                    <legend style="color:#333333;font-size:10em;font-weight:bold;">
                                        <div class="form-group">
                                            <label class="fancy-checkbox">
                                                <input type="checkbox">
                                                <c:if test="${st.index==0}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;个人办公</span>
                                                </c:if>
                                                <c:if test="${st.index==1}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;邮件管理</span>
                                                </c:if>
                                                <c:if test="${st.index==2}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;会议管理</span>
                                                </c:if>
                                                <c:if test="${st.index==3}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;资源管理</span>
                                                </c:if>
                                                <c:if test="${st.index==4}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;公司论坛</span>
                                                </c:if>
                                                <c:if test="${st.index==5}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;考勤管理</span>
                                                </c:if>
                                                <c:if test="${st.index==6}">
                                                    <span class="menuName">&nbsp;&nbsp;&nbsp;系统管理</span>
                                                </c:if>
                                            </label>
                                        </div>
                                    </legend>
                                    <div class="divInfoNew">
                                        <c:forEach items="${teamRoleListBycondition[st.index]}" var="info">
                                            <c:if test="${info.TYPE!='menu'}">
                                                <div class="form-group">
                                                    <label class="fancy-checkbox">
                                                        <input type="checkbox" name="permission" value="${info.id}">
                                                        <span>${info.NAME}</span>
                                                    </label>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </fieldset>
                                <br/>
                            </c:forEach>
                            </div>
                        </div>
                    <input type="submit" class="btn btn-info" style="position: relative;top:-599.5px;left:670px;" value="保存"/>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>