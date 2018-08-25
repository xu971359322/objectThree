<%--
  Created by IntelliJ IDEA.
  User: ZWZ
  Date: 2018/8/24
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/css/style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/zwz/js/zw/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <%-------------------------------------------------------------------------------------------------------------------------------%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/zwz/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/zwz/zwzcss/bootstrap.js"></script>
</head>

<h4>会议室管理</h4>


<body class="pos-r">
<div style="margin-left:200px;">

    <div class="page-container">


        <div class="mt-20">
            <table class="table table-border table-bordered table-bg table-hover table-sort">
                <thead>
                <tr class="text-c">
                    <th>名称</th>
                    <th>描述</th>
                    <th >容纳人数</th>
                    <th>设备简介</th>
                    <th>地址</th>
                    <th width="70">操作</th>
                </tr>
                </thead>


                <tbody>

                <c:forEach items="${allmeetingroomlist}" var="z" varStatus="i" >
                    <tr class="text-c va-m">
                        <td>${z.title}</td>

                        <td>
                                ${z.content}
                        </td>
                        <td>
                                ${z.people}
                        </td>
                        <td>

                                ${z.facility}
                        </td>
                        <td>

                                ${z.place}
                        </td>



                        <td class="td-manage">


                            <a style="text-decoration:none" class="ml-5" onClick="product_edit('${z.id}')"   title="编辑会议室">
                                <i class="Hui-iconfont">&#xe6df;</i></a>

                        </td>

                    </tr>

                </c:forEach>



                </tbody>
            </table>
        </div>
    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/showall.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/zwz/js/zw/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode);
                    return false;
                } else {
                    //demoIframe.attr("src",treeNode.file + ".html");
                    return true;
                }
            }
        }
    };




    $(document).ready(function(){
        var t = $("#treeDemo");
        t = $.fn.zTree.init(t, setting, zNodes);
        //demoIframe = $("#testIframe");
        //demoIframe.on("load", loadReady);
        var zTree = $.fn.zTree.getZTreeObj("tree");
        //zTree.selectNode(zTree.getNodeByParam("id",'11'));
    });

    $('.table-sort').dataTable({
        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            {"orderable":false,"aTargets":[0,5]}// 制定列不参与排序
        ]
    });





    /*显示编辑会议室页面-查询单个会议室*/
    function product_edit(id){
        $.ajax({
            type: 'POST',
            url:'${pageContext.request.contextPath }/zw/showonemeetingroom.do?id='+id
//

        });
        setTimeout(function(){
            self.location='${pageContext.request.contextPath }/zwz/showonemeetingroom.jsp';
        },150);


    }




</script>
</body>

</html>
