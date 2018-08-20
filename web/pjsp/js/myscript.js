/**
 * 链接数据库
 * @param url 连接地址
 * @param data 传入参数
 * @param method 回调方法
 */
var getAjaxFun = function (url, data, method) {
    $.ajax({
        async: false,
        cache: false,
        type: 'POST',
        dataType: "json",
        url: url,
        data: data,
        success: function (data){//请求成功
            method(data);
        },
        // 请求的action路径
        error: function () {// 请求失败处理函数
            Lobibox.alert('error', {
                msg: "请求失败！"
            });
        }
    });
};
(function ($) {
    var calendar;
    //日历初始化
    function calendarInit() {
        calendar = $('#calendar').fullCalendar({
            firstDay: 1,//每周开始的日期：0为周日
            isRTL: false,//是否从右至左组织日历
            weekends: true,//是否显示周末
            defaultView: 'month',//初始化时的默认视图，month、agendaWeek、agendaDay
            allDaySlot: true,//agenda视图下是否显示all-day
            allDayText: '今日',//agenda视图下all-day的显示文本
            slotMinutes: 30,//agenda视图下两个相邻时间之间的间隔
            eventLimit: true,
            allDayDefault: false,
            //设置头部信息，如果不想显示，可以设置header为false
            header: {
                //日历头部左边：初始化切换按钮
                left: 'prev,next today',
                //日历头部中间：显示当前日期信息
                center: 'title',
                //日历头部右边：初始化视图
                right: 'month,agendaWeek,agendaDay'
            },
            monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
            monthNamesShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
            dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
            dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
            buttonText: {
                prev: "<span class='fc-text-arrow'>《上个月</span>",
                next: "<span class='fc-text-arrow'>下个月》</span>",
                prevYear: "<span class='fc-text-arrow'>&laquo;上一年</span>",
                nextYear: "<span class='fc-text-arrow'>下一年&raquo;</span>",
                today: '返回今天',
                month: '月',
                week: '周',
                day: '日'
            },
            editable: false,	//是否可拖拽
            droppable: true, 	//这允许事情被扔到日历上！！！
            selectable: true,	//是否选中对应元素
            selectHelper: false,
            events: calendearSelect,//初始化日程表
            select: calendearAdd,
            eventClick: calendearSelectEdit,
            eventMouseover: calendearMouseover
        });
    }

    //读取日历数据
    function calendearSelect(start, end, callback) {
        //只显示本页数据
        var fstart = $.fullCalendar.formatDate(start, "yyyy-MM-dd HH:mm:ss");
        var fend = $.fullCalendar.formatDate(end, "yyyy-MM-dd HH:mm:ss");
        getAjaxFun(root + "/calendar/doList.do", {
            "start": fstart,
            "end": fend
        }, function (reData){
            var events = [];
            for (var i = 0; i < reData.length; i++) {
                var array_element = reData[i];
                var title =array_element.mTitle;
                if (array_element != null) {
                    var color = "";
                    if (array_element.colorInfo ==1) {
                        color = "lightblue";
                    } else if (array_element.colorInfo ==0) {
                        color = "gray";
                    } else if (array_element.colorInfo ==2) {
                        color = "yellowgreen";
                    }
                    //待批0 已批准1 进行中 2
                    var tjson = {
                        id: array_element.mId,
                        title: title,
                        start: array_element.startTime,
                        end: array_element.endTime,
                        color: color,
                        allDay: true
                    };
                    events.push(tjson);
                }
            }
            callback(events);
        });
    }

    function clear(){
/*        $("#nowDate").val("");
        $("#nowTime").val("");*/
        $("#meetingName").val("");
        $("#expertMe").html("");
        $("#message").html("");
        $("#onSubmit").unbind();//摧毁上次绑定的事件
    }

    //添加，会议消息
    function calendearAdd(start, end, allDay) {
        var aa = queryCalendearByName(start, end, allDay);
        if (aa != "") {
            Lobibox.alert('success', {
                msg: "一个用户一天只能添加4条日程",
            });
            return;
        }
        document.getElementById("jd").click();
        clear();
        $("#onSubmit").click(function () {
            var nDate = $("#nowDate").val();
            var nTime = $("#nowTime").val();
            var endDate = $("#endDate").val();
            var endTime = $("#endTime").val();
            if ($("#meetingName").val() != "") {
                calendar.fullCalendar('renderEvent',
                    {
                        title: $("#meetingName").val(),
                        start: start,
                        end: end,
                        allDay: allDay
                    },
                    true, // make the event "stick"
                    document.getElementById("close").click()
                );
                Lobibox.alert('success', {
                    msg: "添加成功",
                    callback: function ($this, type, ev) {
                        window.location.reload();
                    }
                });
            } else {
                $("#message").html("请输入日程");
                return;
            }
            calendar.fullCalendar('unselect');
           $.ajax({
                async: false,
                cache: false,
                type: 'POST',
                dataType: "text",
                data: {
                    "meetingName": $("#meetingName").val(),
                    "start":nDate+" "+nTime,
                    "end":endDate+" "+endTime,
                    "colorInfo":$("#mstate").val(),
                    "meetingType":$("#meetingType").html(),
                    "mpId":$("#mpId").val(),
                    "allDay": allDay,
                    "content":$("#content").val(),
                    "remark":$("#remark").val(),
                    "mstate":$("#mstate").val()
                },
                url: root + "/calendar/fullCalendarAdd.do",
                //请求失败处理函数
                error: function () {
                    Lobibox.alert('error', {
                        msg: "请求失败",
                        callback: function ($this, type, ev) {
                            window.location.reload();
                        }
                    });
                }
            });
        });
    }

    /*个人日程*/
    /*function calendearAdd(start, end, allDay) {
        var aa = queryCalendearByName(start, end, allDay);
        if (aa != "") {
            Lobibox.alert('success', {
                msg: "一个用户一天只能添加4条日程",
            });
            return;
        }
        document.getElementById("jd").click();
        $("#titleName").val("");
        $("#expertMe").html("");
        $("#message").html("");
        //摧毁上次绑定的事件
        $("#onSubmit").unbind();
        $("#onSubmit").click(function () {
            if ($("#titleName").val() != "") {
                calendar.fullCalendar('renderEvent',
                    {
                        title: $("#titleName").val(),
                        start: start,
                        end: end,
                        allDay: allDay
                    },
                    true, // make the event "stick"
                    document.getElementById("close").click()
                );
                Lobibox.alert('success', {
                    msg: "添加成功",
                    callback: function ($this, type, ev) {
                        window.location.reload();
                        //$('#calendar').fullCalendar('refetchEvents');
                    }
                });
            } else {
                $("#message").html("请输入日程");
                return;
            }
            calendar.fullCalendar('unselect');
            //var color = $("input[type='radio']:checked").val();
            var one = "";
            var two = "";
            var three = "";
            var four = "";
            var eightColor = document.getElementsByName("eightColor");
            var tenColor = document.getElementsByName("tenColor");
            var thirteenColor = document.getElementsByName("thirteenColor");
            var fifteenColor = document.getElementsByName("fifteenColor");
            for (var i = 0; i < eightColor.length; i++) {
                if (eightColor[i].checked) one = eightColor[i].value;
            }
            for (var i = 0; i < tenColor.length; i++) {
                if (tenColor[i].checked) two = tenColor[i].value;
            }
            for (var i = 0; i < thirteenColor.length; i++) {
                if (thirteenColor[i].checked) three = thirteenColor[i].value;
            }
            for (var i = 0; i < fifteenColor.length; i++) {
                if (fifteenColor[i].checked) four = fifteenColor[i].value;
            }
            //val = 1 绿色空闲，val = 2 灰色锁定
            $.ajax({
                async: false,
                cache: false,
                type: 'POST',
                dataType: "text",
                data: {
                    "titleName": $("#titleName").val(),
                    "start": start,
                    "end": end,
                    "eightColor": one, //8点-10点
                    "tenColor": two,	 //10点-12点
                    "thirteenColor": three,	//13点-15点
                    "fifteenColor": four,	//15点-17点
                    "allDay": allDay
                },
                url: root + "/calendar/fullCalendarAdd.do",
                //请求的action路径
                error: function () { //请求失败处理函数
                    Lobibox.alert('error', {
                        msg: "请求失败",
                        callback: function ($this, type, ev) {
                            window.location.reload();
                        }
                    });
                }
            });
        });
    }*/

    //添加之前查询  这个专家 当日 是否添加过日程
    function queryCalendearByName(start, end, allDay) {
        var judge;
        var fstart = $.fullCalendar.formatDate(start, "yyyy-MM-dd HH:mm:ss");
        var fend = $.fullCalendar.formatDate(end, "yyyy-MM-dd HH:mm:ss");
        getAjaxFun(root + "/calendar/queryCalendearByName.do", {
            "start": fstart,
            "end": fend
        }, function (reData) {
            judge = reData;
        });
        return judge;
    }

    //修改
    function calendearSelectEdit(calEvent, jsEvent, view) {
        var fstart = $.fullCalendar.formatDate(calEvent.start, "HH:mm");
        var fend = $.fullCalendar.formatDate(calEvent.end, "HH:mm");
        var start = $.fullCalendar.formatDate(calEvent.start, "yyyy-MM-dd HH:mm:ss");
        var end = $.fullCalendar.formatDate(calEvent.end, "yyyy-MM-dd HH:mm:ss");
        var str = "";
        var reg = /[^:]*:([^:]*)/;
        str = calEvent.title.replace(reg, "$1");
        //截取冒号之前  取专家名字
        var adminName = calEvent.title.substr(0, calEvent.title.indexOf(':'));
        var form = $("<form class='form-inline'><lable>修改日程 </lable><div class='modal'></form>");
        form.append("<textarea class='form-control input-focused' id='textarea' maxlength = '50' autocomplete=off placeholder='日程名称'>" + str + "</textarea><div id='messageEdit' style='color: red;'></div>");
        form.append("时间段：");
        form.append("<form class='form-inline'><label>" + fstart + "-" + fend + "  </label></form>");
        if (calEvent.color == "green") {
            form.append("<label class='blue'> <input name='colorEdit' value='1' checked type='radio' class='ace' /> <span class='lbl' style='color:green;font-weight:bold;'> 空闲  </span> </label>");
            form.append("<label class='blue'> <input name='colorEdit' value='2' type='radio' class='ace' /> <span class='lbl' style='color:gray;font-weight:bold;'> 锁定   </span> </label>");
            form.append("<label class='blue'> <input name='colorEdit' value='3' type='radio' class='ace' /> <span class='lbl' style='color:orange;font-weight:bold;'> 预订   </span> </label>");
        } else if (calEvent.color == "gray") {
            form.append("<label class='blue'> <input name='colorEdit' value='1' type='radio' class='ace' /> <span class='lbl' style='color:green;font-weight:bold;'> 空闲   </span> </label>");
            form.append("<label class='blue'> <input name='colorEdit' value='2' checked type='radio' class='ace' /> <span class='lbl' style='color:gray;font-weight:bold;'> 锁定   </span> </label>");
            form.append("<label class='blue'> <input name='colorEdit' value='3' type='radio' class='ace' /> <span class='lbl' style='color:orange;font-weight:bold;'> 预订   </span> </label>");
        } else if (calEvent.color == "orange") {
            form.append("<label class='blue'> <input name='colorEdit' value='1' type='radio' class='ace' /> <span class='lbl' style='color:green;font-weight:bold;'> 空闲   </span> </label>");
            form.append("<label class='blue'> <input name='colorEdit' value='2' type='radio' class='ace' /> <span class='lbl' style='color:gray;font-weight:bold;'> 锁定   </span> </label>");
            form.append("<label class='blue'> <input name='colorEdit' value='3' checked type='radio' class='ace' /> <span class='lbl' style='color:orange;font-weight:bold;'> 预订   </span> </label>");
        }
        form.append("<br/>");
        form.append("<br/>");
        var div = bootbox.dialog({
            message: form,
            buttons: {
                "edit": {
                    "label": "<i class='icon-ok'></i> 保存",
                    "className": "btn btn-sm btn-success",
                    "callback": function () {
                        var val = $("#textarea").val();
                        var color = $("input[name='colorEdit']:checked").val();
                        if (val != "") {
                            $.ajax({
                                async: false,
                                cache: false,
                                type: "POST",
                                dataType: "text",
                                data: {
                                    "id": calEvent.id,
                                    "name": val,
                                    "color": color,
                                    "allDay": calEvent.allDay
                                },
                                url: root + "/expertOneselfClient/fullCalendarEdit",
                                //请求的action路径
                                error: function () { //请求失败处理函数
                                    Lobibox.alert('error', {
                                        msg: "请求失败"
                                    });
                                },
                                success: function (data) {
                                    if (data == "") {
                                        Lobibox.alert('success', {
                                            msg: "修改成功",
                                            callback: function ($this, type, ev) {
                                                window.location.reload();
                                            }
                                        });
                                    }
                                }
                            });
                            //calendar.fullCalendar('updateEvent', calEvent);
                            div.modal("hide");
                            return false;
                        } else {
                            $("#messageEdit").html("请输入日程");
                            return false;
                        }
                    }
                },
                "delete": {
                    "label": "<i class='icon-trash'></i> 删除",
                    "className": "btn-sm btn-danger",
                    "callback": function () {
                        //截取冒号之前  取专家名字
                        var adminName = calEvent.title.substr(0, calEvent.title.indexOf(':'));
                        Lobibox.confirm({
                            msg: "是否删除当天日程?",
                            callback: function ($this, type, ev) {
                                if (type == "yes") {
                                    $.ajax({
                                        async: false,
                                        cache: false,
                                        type: "POST",
                                        dataType: "text",
                                        data: {
                                            "start": start,
                                            "end": end,
                                            "name": adminName
                                        },
                                        url: root + "/expertOneselfClient/fullCalendarDel",
                                        //请求的action路径
                                        error: function () { //请求失败处理函数
                                            Lobibox.alert('error', {
                                                msg: "请求失败"
                                            });
                                        },
                                        success: function (data) {
                                            if (data == "") {
                                                Lobibox.alert('success', {
                                                    msg: "删除成功",
                                                    callback: function ($this, type, ev) {
                                                        window.location.reload();
                                                    }
                                                });
                                            }
                                        }
                                    });
                                    calendar.fullCalendar('removeEvents', function (ev) {
                                        return (ev._id == calEvent._id);
                                    })
                                }
                            }
                        });
                    }
                },
                "close": {
                    "label": "<i class='icon-remove'></i> 关闭",
                    "className": "btn-sm"
                }
            }
        });
    }


    //鼠标放上去显示信息
    function calendearMouseover(calEvent) {
        var fstart = $.fullCalendar.formatDate(calEvent.start, "yyyy-MM-dd HH:mm");
        var fend = $.fullCalendar.formatDate(calEvent.end, "yyyy-MM-dd HH:mm");
        var str=null;
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            dataType: "json",
            data: {
                "mid": calEvent.id
            },
            url: root + "/calendar/queryCalendearById.do",
            error: function () {
                Lobibox.alert('error', {
                    msg: "请求失败"
                });
            },
            success: function (data) {
                var info=data.infomation;
                if (data !="") {
                    str="会议名称:"+info.mTitle+"\r\n"+
                        +"主要内容:"+info.mContent+"\r\n";
                }
            }
            /*OaMeeting{mId=7, mTitle='132123', mpId=2, mBegintime=null, eEndtime=null, mContent='评选年度人物进行颁奖，等一系列活动！
                                    <option value="1">Enter</option>
                                    <option value="2">Your</option>
                                    <option value="3">Options</option>
                                    <option value="4">Here!</option>', woId='3738f4b7-9d50-11e8-b8e3-10e7c6eac62f', mstate=0}*/
        });
        /*alert(str+"=========="+calEvent.id);*/
        $(this).attr('title',"--详细信息如下--\r\n "+str+"开始时间:"+fstart+"\r\n"+"结束时间:" + fend);
        $(this).css('font-weight','normal');
    }

    //添加绑定
    function addBangDing() {
        $('#expert').change(function () {
            calendar.fullCalendar('refetchEvents');
        });
    }
    calendarInit();     //日历初始化
    addBangDing();
})(window.jQuery);