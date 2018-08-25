var getAjaxFun = function (url, data, method) {
    $.ajax({
        async: false,
        cache: false,
        type: 'POST',
        dataType: "json",
        url: url,
        data: data,
        success: function (data){
            method(data);
        },
        error: function () {
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
/*            firstDay: 1,//每周开始的日期：0为周日
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
            },*/
            defaultView:"month",            // year, month, date: 整数, 初始化加载时的日期，默认是month
            height:740,                    // 日历高度,包括表头   contentHeight: 600 内容高度，不包括表头
            editable: true,                 // 默认值false, 用来设置日历中的日程是否可以编辑
            draggable: true,                // 是否可拖动
            weekends: true,                 // 默认为true, 标识是否显示周六和周日的列
            slotMinutes:30,                 // 整型, 默认值30, 表示在agenda的views中, 两个时间之间的间隔
            disableDragging:false,          // Boolean类型, 默认false, 所有的event可以拖动, 必须editable = true
            diableResizing:false,           // Boolean, 默认false, 所有的event可以改变大小, 必须editable = true
            dragRevertDuration:500,         // 拖动恢复的时间, 默认500毫秒, 表示一个不成功的拖动之后, 控件回复到原始位置的时间.
            dragOpacity:.5,                 // Float类型, 表示拖动时候的不透明度.
            monthNames:['一月','二月', '三月', '四月', '五月', '六月', '七月','八月', '九月', '十月', '十一月', '十二月'], //默认为英文月分，这里可以改成中文
            dayNames:['星期日', '星期一', '星期二', '星期三','星期四', '星期五', '星期六'],  //换成中文星期
            header:{
                left:   'month,agendaWeek,agendaDay',  //左边显示的按钮 (month,basicWeek无时间格式,basicDay无时间格式,agendaWeek,agendaDay)
                center: 'title',        //中间显示标题
                right:  'prevYear,prev,today,next,nextYear'  //右边显示的按钮
            },
            buttonText:{                    //按钮对应的文本
                prevYear: '去年',         //不建议改这个值，因为它本身是含[去年、上一周、前天]三个意思，你就让它默认
                nextYear: '明年',         //同上
                today:    '今天',
                month:    '月',
                week:     '周',
                day:      '日'
            },
            dayNamesShort:['周日', '周一', '周二', '周三','周四', '周五', '周六'],  //短格式的星期
            titleFormat:{                   //格式化标题
                month: 'MMMM yyyy',                             // 如：September 2009
                week: "MMM d[yyyy]{'&#8212;'[ MMM] d yyyy}",    // 如：Sep 7 - 13 2009
                day: 'dddd, MMM d, yyyy'                        // 如：Tuesday, Sep 8, 2009
            },
           /* weekMode:'fixed',  */         //固定显示6周高
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
/*        if (aa != "") {
            Lobibox.alert('success', {
                msg: "一个用户一天只能添加4条日程",
            });
            return;
        }*/
        document.getElementById("jd").click();
        clear();
        $("#onSubmit").click(function () {
            var nDate = $("#nowDate").val();
            var nTime = $("#nowTime").val();
            var endDate = $("#endDate").val();
            var endTime = $("#endTime").val();
            var checkBox=$("[name=idcheckBox]:checked");
            var infoIds = '';
            checkBox.each(function(){
                infoIds +=$(this).parent().parent().attr("id")+ ',';
            })
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
                        "meetingType":$("#meetingType").val(),
                        "mpId":$("#mpId").val(),
                        "allDay": allDay,
                        "content":$("#content").val(),
                        "remark":$("#remark").val(),
                        "mstate":$("#mstate").val(),
                        "infoIds":infoIds
                    },
                    url: root + "/calendar/fullCalendarAdd.do",
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

    //添加之前查询
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
        var checklist = document.getElementsByName("idcheckBoxNew");
        for(var i=0;i<checklist.length;i++){
            checklist[i].checked=false;
        }
        document.getElementById("change").click();
        $.ajax({
            async: false,
            cache: false,
            type: "POST",
            dataType: "json",
            data: {
                "mid": calEvent.id
            },
            url: root + "/calendar/fullCalendarEdit.do",
            error: function () {
                Lobibox.alert('error', {
                    msg: "请求失败"
                });
            },
            success: function (data) {
                var time1=data.meeting.startTime.substring(0,10);
                var detailtime1=data.meeting.startTime.substring(11,16);
                var time2=data.meeting.endTime.substring(0,10);
                var detailtime2=data.meeting.endTime.substring(11,16);
                if (data!="") {
                    var siteMap = eval(data.queryCalendearAllInfo);
                    for (var j = 0; j < siteMap.length; j++) {
                        $.each(siteMap[j], function (key, value) {
                            for (var k = 0; k < checklist.length; k++) {
                                if (siteMap[j].wo_id == checklist[k].value) {
                                    checklist[k].checked = true;
                                }
                            }
                        });
                    }
                    //$("#mpIdChange").find("option:contains('2')").attr("selected",true);
                    $("#mIdInfomation").val(data.meeting.mId);
                    $("#nowDateChange").val(time1);
                    $("#nowTimeChange").val(detailtime1);
                    $("#endDateChange").val(time2);
                    $("#endTimeChange").val(detailtime2);
                    $("#meetingNameChange").val(data.meeting.mTitle);
                    $("#mstateChange").val(data.meeting.mstate);
                    $("#meetingTypeChange").val(data.meeting.mType);
                    $("#mpIdChange").val(data.meeting.mpId);
                    $("#contentChange").val(data.meeting.mContent);
                    $("#remarkChange").val(data.meeting.mremark);
                }
                //calendearDelete();
                calendearUpdate();
            }
        });
        //calendar.fullCalendar('updateEvent', calEvent);
    }

    //删除会议人员
    function calendearDelete() {
/*            var checkBox=$("[name=idcheckBoxNew]:checked");
            var infoIds = '';
            checkBox.each(function(){
                infoIds +=$(this).parent().parent().attr("id")+ ',';
            })//未选中的checkbox传id值，*/
            alert("11111111111111111111111111");

    }

    //修改会议消息
    function calendearUpdate() {
        $("#onSubmitChange").click(function (){
            $.ajax({
                async: false,
                cache: false,
                url: root + "/calendar/fullCalendarDetele.do",
                type: 'POST',
                dataType: "json",
                data: {
                    "mIdInfomation":$("#mIdInfomation").val()
                },
                success:function (data){

                }
            });
            var nDate = $("#nowDateChange").val();
            var nTime = $("#nowTimeChange").val();
            var endDate = $("#endDateChange").val();
            var endTime = $("#endTimeChange").val();
            var checkBox=$("[name=idcheckBoxNew]:checked");
            var infoIds = '';
            checkBox.each(function(){
                infoIds +=$(this).parent().parent().attr("id")+ ',';
            })//未选中的checkbox传id值，
            $.ajax({
                async: false,
                cache: false,
                url: root + "/calendar/fullCalendarUpdate.do",
                type: 'POST',
                dataType: "text",
                data: {
                    "meetingNameChange": $("#meetingNameChange").val(),
                    "startChange":nDate+" "+nTime,
                    "endChange":endDate+" "+endTime,
                    "colorInfoChange":$("#mstateChange").val(),
                    "meetingTypeChange":$("#meetingTypeChange").val(),
                    "mpIdChange":$("#mpIdChange").val(),
                    "allDayChange":true,
                    "contentChange":$("#contentChange").val(),
                    "remarkChange":$("#remarkChange").val(),
                    "mstateChange":$("#mstateChange").val(),
                    "infoIdsChange":infoIds,
                    "mIdInfomation":$("#mIdInfomation").val()
                },
                error: function () {
                    window.location.reload();
                },success:function (data) {
                    window.location.reload();
                }
            });
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