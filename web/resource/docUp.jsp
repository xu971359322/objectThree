<%--
  Created by IntelliJ IDEA.
  User: 解星宇
  Date: 2018/8/15
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"/>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.min.js"></script>


    <script type="text/javascript">
        $(function(){
            $('[name=sel]').change(function () {
                if(this.checked==true){
                        $('#myModal').modal('show');
                }
            })
        })
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
            <ul class="list-inline">
                <li>
                    文档
                </li>
            </ul>
        </div>
        <div class="col-md-10 column">
            <form action="${pageContext.request.contextPath }/wordUp.do" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleInputPassword1">请对文件进行一下简单描述</label><input type="text" class="form-control" id="exampleInputPassword1" />
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">上传文件</label><input type="file" id="exampleInputFile" />
                </div>
                <div class="checkbox">
                    <label><input type="checkbox" name="sel" />是否设置为私密文件</label>
                </div>

                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">
                                    模态框（Modal）标题
                                </h4>
                            </div>
                            <div class="modal-body">
                                在这里添加一些文本
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary">
                                    提交更改
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
                <button type="submit" class="btn btn-default">确认上传</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
