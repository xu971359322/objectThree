<%--
  Created by IntelliJ IDEA.
  User: 解星宇
  Date: 2018/8/16
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
    .lis li{
        font-size: 20px;
    }
    .lis li a{
        color: #000;
    }

    </style>
</head>
<body>
<div class="container" class="col-md-2 column" style="width: 98%">
            <div class="row clearfix" class="col-md-1 column" >
                <div class="col-md-2 column" style="padding-left: -10px">
                    <ul class="lis" style="list-style:none;">
                        <li>
                            <a href="${pageContext.request.contextPath}/resou/resouAll.do" target="myfra">公司所有文档</a><br/><br/>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/resou/selShowAll.do" target="myfra">私密文档</a><br/><br/>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/resou/myWord.do" target="myfra">我的文档</a><br/><br/>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/resou/Load.do" target="myfra">文档上传</a><br/><br/>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/resou/dustbin.do" target="myfra">文档回收站</a><br/><br/>
                        </li>
                    </ul>
                </div>
                <div class="col-md-10 column">
                    <iframe name="myfra" style="height: 98%; width: 100%">

                    </iframe>
                </div>
    </div>
</div>
</body>
</html>
