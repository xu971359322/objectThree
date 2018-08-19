<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function(){
            $('[name=sel]').change(function () {
                if(this.checked==true){
                        $('#myModal').modal('show');
                }
            })
            $('#myfrm').submit(function () {
                var  selectVal= $('[name=type]').val();

                var upFileName = $("#exampleInputFile").val();
                var index1=upFileName.lastIndexOf(".");
                var index2=upFileName.length;
                var suffix=upFileName.substring(index1+1,index2);//后缀名

                if($('#exampleInputPassword1').val()==null) {
                    alert('请填写文件描述')
                    return false;
                }else if ($('#exampleInputFile').val()==null){
                    alert('请选择文件');
                    return false;
                }else if(selectVal=='0'){
                    alert('请选择文件类型');
                    return false;
                }else if (selectVal!=suffix){
                    alert('当前上传文件与所选格式不符');
                    return false;
                }
                return true;
            })
        });
    </script>
</head>
<body>

<center><h1>文档上传</h1></center>
<div class="container">
    <div class="row clearfix">
            <form action="${pageContext.request.contextPath }/resou/FileUp.do" method="post" enctype="multipart/form-data" id="myfrm">
                <div class="form-group">
                    <label for="exampleInputPassword1">请对文件进行一下简单描述</label><input type="text" class="form-control" id="exampleInputPassword1" name="fMess" />
                </div>

                <div class="form-group">
                上传文件类型
                    <select name="type">
                    <option value="0">未选择</option>
                    <option value="doc">word文档</option>
                    <option value="pptx">ptt演示文档</option>
                    <option value="xlsx">excle表格</option>
                    <option value="txt">txt文本文档</option>
                </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">上传文件</label><input type="file" id="exampleInputFile" name="fName" />
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
                                    指定给
                                </h4>
                            </div>
                            <div class="modal-body">
                                <div class="checkbox">
                                    <c:forEach items="${sessionScope.resouUserList}" var="l">
                                        <label><input type="checkbox" name="user" value="${l.woId}"/>${l.woName}</label>&nbsp;&nbsp;&nbsp;&nbsp;
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                </button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal">提交更改
                                </button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
                <button type="submit" class="btn btn-default">确认上传</button>
            </form>
    </div>
</div>
</body>
</html>
