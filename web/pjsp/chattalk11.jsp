<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>ShiYanLou Chat</title>
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="alternate icon" href="${pageContext.request.contextPath}/pjsp/assets/i/favicon.png">
<link rel="stylesheet" href="${pageContext.request.contextPath}/pjsp/assets/css/amazeui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/pjsp/assets/css/app.css">
<link href="${pageContext.request.contextPath}/pjsp/umeditor/themes/default/css/umeditor.css" rel="stylesheet">
<style>
.title {
    text-align: center;
}

.chat-content-container {
    height: 29rem;
    overflow-y: scroll;
    border: 1px solid silver;
    background-color: whitesmoke;
}
#userInfo{
    width:300px;
    border: 0px solid red;
    float: right;
}
#Info{
    width:100px;//////////////////////////////////////////////////////////////////////////////////////////////////////////
    border: 0px solid orange;
    float: right;
}
</style>
</head>
<body>
    <!-- chat content start -->
    <div class="chat-content" style="border:0px solid green;display: flex">
        <div style="width:1050px;margin-left:-10px;border:0px solid green;">
        <div class="am-g am-g-fixed chat-content-container" style="width: 1000px;height: 500px;">
            <div class="am-u-sm-12">
                <ul id="message-list" class="am-comments-list am-comments-list-flip"></ul>
            </div>
        </div>
        <!-- message input start -->
        <div class="message-input am-margin-top">
            <div class="am-g am-g-fixed">
                <div class="am-u-sm-12" style="width:1000px;">
                    <form class="am-form">
                        <div class="am-form-group" style="width:1000px;margin-left:-14px;">
                            <script type="text/plain" id="myEditor" style="width: 100%;height: 8rem;"></script>
                        </div>
                    </form>
                </div>
         </div>

        <div class="am-g am-g-fixed am-margin-top" style="border:1px solid rebeccapurple;position:relative;top:-17px;">
            <div class="am-u-sm-6">
                  <div id="message-input-nickname" class="am-input-group am-input-group-primary">
                     <span class="am-input-group-label"><i class="am-icon-user"></i></span>
                            <input id="nickname" type="text" class="am-form-field"  placeholder="Please enter nickname" disabled/>
                       </div>
                 </div>
        <div class="am-u-sm-6">
            <button id="send" type="button" class="am-btn am-btn-primary">
            <i class="am-icon-send"></i> Send
            </button>
            </div>
            </div>
            </div>
        </div>
                            <div id="userInfo"></div>
                            <div id="Info"></div>
    </div>
    <!-- chat content start -->

    <!-- message input end -->

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <![endif]-->

    <!-- umeditor js -->
    <script charset="utf-8" src="${pageContext.request.contextPath}/pjsp/umeditor/umeditor.config.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/pjsp/umeditor/umeditor.min.js"></script>
    <script src="${pageContext.request.contextPath}/pjsp/umeditor/lang/zh-cn/zh-cn.js"></script>

    <script type="text/javascript">
            var name='${sessionScope.worker.wo_loginName}';<%--${pageContext.request.getServerName()}192.168.43.169--%>
            var target = "ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/first?uname="+name;
            var ws=null;

            window.onbeforeunload=beforeunload;
            function beforeunload(){
                //var msg="确定要退出当前聊天吗？";
                //return msg;
                ws.close();
            }

            $(function(){
                var um = UM.getEditor('myEditor'); // 初始化消息输入框
                $('#nickname').val(name);
                /*$('#nickname').attr()*/
                $('#nickname')[0].focus(); // 使昵称框获取焦点
                //判断浏览器是否支持webSocket
                if ('WebSocket' in window) {
                    ws = new WebSocket(target);//创建连接管道
                } else if ('MozWebSocket' in window) {
                    ws= new MozWebSocket(target);
                } else{
                    alert("你的浏览器不支持webSocket");
                    return;
                }
                ws.onopen = function () {
                    // alert("管道已建立！");
                };
                ws.onmessage = function (message){
                    eval("var t="+message.data);
                    if(t.msg!=undefined){
                        $("<div>"+t.msg+"</div>").appendTo($("#Info"));
                    }

                    //用户列表
                    if(t.name!=undefined){
                        $("#userInfo").html("");
                        $.each(t.name,function(index,k){
                            $("#userInfo").append("<input type='checkbox'  value='"+k+"'/>"+k+"<br/>");
                        });
                    }
                    if(t.content!=undefined){
                        var messageItem = '<li class="am-comment '
                            + (t.flag ? 'am-comment-flip' : 'am-comment')
                            + '">'
                            + '<a href="javascript:void(0)" ><img src="assets/i/'
                            + (t.flag ? 'app-icon72x72@2x.png' : 'app-icon72x72@2x.png')
                            + '" alt="" class="am-comment-avatar" width="48" height="48"/></a>'
                            + '<div class="am-comment-main"><header class="am-comment-hd"><div class="am-comment-meta">'
                            + '<a href="javascript:void(0)" class="am-comment-author">'
                            + t.personName + '</a> <time>' + t.time
                            + '</time></div></header>'
                            + '<div class="am-comment-bd">' + t.content
                            + '</div></div></li>';
                        $(messageItem).appendTo('#message-list');
                        // 把滚动条滚动到底部
                        $(".chat-content-container").scrollTop($(".chat-content-container")[0].scrollHeight);
                    }
                };
                //发送消息
                $("#send").click(function(){
                    var nickname = $('#nickname').val();
                    if (!um.hasContents()) {// 判断消息输入框是否为空
                        um.focus();// 消息输入框获取焦点
                        $('.edui-container').addClass('am-animation-shake');// 添加抖动效果
                        setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
                    }else if (nickname == '') {    // 判断昵称框是否为空
                        $('#nickname')[0].focus();//昵称框获取焦点
                        $('#message-input-nickname').addClass('am-animation-shake');// 添加抖动效果
                        setTimeout("$('#message-input-nickname').removeClass('am-animation-shake')", 1000);
                    }else{
                        var val=um.getContent();
                        var obj=null;//定义一个变量，用于接收json数据\
                        var users=$("#userInfo :checked");//获取选中的复选框
                        if(users.size()==0){
                            obj={
                                "msg":val,
                                "type":1
                            }
                        }else{
                            obj={
                                "msg":val,
                                "type":0,
                                "toUser":users.val()
                            }
                        }
                        var str=JSON.stringify(obj);
                        ws.send(str);
                        um.setContent('');
                    }
                });
            });
    </script>
    
</body>
</html>