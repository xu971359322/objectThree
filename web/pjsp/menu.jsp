<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="common.jsp"%>
    <style type="text/css">
        .form-inline {
            background-color: white;
        }
        .divInfo{
            margin-left:10px;
        }
        .menuName{
            font-weight:bold;
            font-size:large;
        }
    </style>
</head>
<body>
<div style="border-left:0.5px solid black">
    <div class="form-inline" role="form">
        <fieldset style="border-color:#E2DED6;border-width:1px;border-style:solid;">
            <legend style="color:#333333;font-size:0.8em;font-weight:bold;">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span class="menuName">&nbsp;&nbsp;&nbsp;员工</span>
                    </label>
                </div>
            </legend>
            <div class="divInfo">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>查询员工</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>删除员工</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>修改员工</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>增加员工</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>部门管理</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>增加或修改部门</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>删除部门</span>
                    </label>
                </div>
            </div>
        </fieldset>
        <br>
        <div style="border-color:#E2DED6;border-width:1px;border-style:solid;">
            <legend style="color:#333333;font-size:0.8em;font-weight:bold;">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span class="menuName">&nbsp;&nbsp;&nbsp;邮件</span>
                    </label>
                </div>
            </legend>
            <div class="divInfo">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>写邮件</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>收件箱</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>允许回复</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>草稿箱</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>已发送</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>已删除</span>
                    </label>
                </div>
            </div>
            <br>
            <fieldset style="border-color:#E2DED6;border-width:1px;border-style:solid;">
                <legend style="color:#333333;font-size:0.8em;font-weight:bold;">
                    <div class="form-group">
                        <label class="fancy-checkbox">
                            <input type="checkbox">
                            <span class="menuName">&nbsp;&nbsp;&nbsp;公文</span>
                        </label>
                    </div>
                </legend>
                <div class="divInfo">
                    <div class="form-group">
                        <label class="fancy-checkbox">
                            <input type="checkbox">
                            <span>公文列表</span>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="fancy-checkbox">
                            <input type="checkbox">
                            <span>公文拟章</span>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="fancy-checkbox">
                            <input type="checkbox">
                            <span>公文编辑</span>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="fancy-checkbox">
                            <input type="checkbox">
                            <span>公文草稿</span>
                        </label>
                    </div>
                    <div class="form-group">
                        <label class="fancy-checkbox">
                            <input type="checkbox">
                            <span>公文审核</span>
                        </label>
                    </div>
                </div>
        </fieldset>
        <br>
        <fieldset style="border-color:#E2DED6;border-width:1px;border-style:solid;">
            <legend style="color:#333333;font-size:0.8em;font-weight:bold;">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span class="menuName">&nbsp;&nbsp;&nbsp;文档管理</span>
                    </label>
                </div>
            </legend>
            <div class="divInfo">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>资料中心</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>删除文件</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>上传</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>回收站</span>
                    </label>
                </div>
            </div>
        </fieldset>
        <br>
        <fieldset style="border-color:#E2DED6;border-width:1px;border-style:solid;">
            <legend style="color:#333333;font-size:0.8em;font-weight:bold;">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span class="menuName">&nbsp;&nbsp;&nbsp;事务管理</span>
                    </label>
                </div>
            </legend>
            <div class="divInfo">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>日程管理</span>
                    </label>
                </div>
            </div>
        </fieldset>
        <br>
        <fieldset style="border-color:#E2DED6;border-width:1px;border-style:solid;">
            <legend style="color:#333333;font-size:0.8em;font-weight:bold;">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span class="menuName">&nbsp;&nbsp;&nbsp;系统管理</span>
                    </label>
                </div>
            </legend>
            <div class="divInfo">
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>角色管理</span>
                    </label>
                </div>
                <div class="form-group">
                    <label class="fancy-checkbox">
                        <input type="checkbox">
                        <span>分配角色</span>
                    </label>
                </div>
            </div>
        </fieldset>
    </div>
</div>
</body>
</html>
