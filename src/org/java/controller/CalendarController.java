package org.java.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.java.entity.OaMeetingCustom;
import org.java.service.SysCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/calendar")
public class CalendarController extends BaseController{

    @Autowired
    @Qualifier("sysCalendarService")
    private SysCalendarService sysCalendarService;

    @RequestMapping(value = "/doList", method = RequestMethod.POST)
    public void doList(HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf8");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        List<OaMeetingCustom> mapList =sysCalendarService.getList(start,end);
        JSONArray datas = JSONArray.fromObject(mapList);
        response.getWriter().print(datas.toString());
    }

    /**
     * 添加时查询当前用户当天是否添加过日程
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/queryCalendearByName", method = RequestMethod.POST)
    public void queryCalendearByName(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf8");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        List<OaMeetingCustom> mapList = sysCalendarService.queryAll(start,end);
        JSONArray jsonArray = JSONArray.fromObject(mapList);
        response.getWriter().print(jsonArray.toString());
    }

    @RequestMapping(value = "/fullCalendarAdd", method = RequestMethod.POST)
    public void fullCalendar(HttpServletRequest request, HttpSession session,
                             HttpServletResponse response,
                             @RequestParam(value = "meetingName") String meetingName,
                             @RequestParam(value = "start") Date start,
                             @RequestParam(value = "end") Date end,
                             @RequestParam(value = "colorInfo") String colorInfo,
                             @RequestParam(value = "allDay") Boolean allDay,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "remark") String remark,
                             @RequestParam(value = "mpId") Integer mpId,
                             @RequestParam(value = "mstate") Integer mstate,
                             @RequestParam(value = "meetingType") String meetingType) throws IOException, ParseException {
        response.setContentType("text/html;charset=utf8");

        Map<String,Object> worker=(Map<String,Object>) session.getAttribute("worker");
        String adminId=worker.get("wo_id").toString();

       /* String[] array = { eightColor, tenColor, thirteenColor, fifteenColor };
        for (int i = 0; i < array.length; i++) {
            UpdateStatement(array[i], i, adminId,meetingName, start,end, eightColor, tenColor, thirteenColor, fifteenColor,allDay,content);
        }*/

        UpdateStatement(1, adminId,meetingName, start,end, colorInfo,allDay,content,mpId,mstate,meetingType,remark);
    }

    private void UpdateStatement(Integer i, String adminId,
                                 String titleName, Date start, Date end,
                                 String colorInfo,Boolean allDay,String content,Integer mpId,Integer mstate,String meetingType,String remark) {
        OaMeetingCustom fullCalendar = new OaMeetingCustom();
        if (i == 0) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String sDate = sf.format(start);
            String eDate = sf.format(end);
            fullCalendar.setmTitle(titleName);
            fullCalendar.setmContent(content + meetingType);
            fullCalendar.setWoId(adminId);
            fullCalendar.setStartTime(sDate);
            fullCalendar.setEndTime(eDate);
            fullCalendar.setIfAllDay(allDay);
            fullCalendar.setColorInfo(colorInfo);
            fullCalendar.setMpId(mpId);//地点
            fullCalendar.setMstate(mstate);
            fullCalendar.setMremark(remark);
        } else if (i == 1) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String sDate = sf.format(start);
            String eDate = sf.format(end);
            System.out.println("开始时间" + sDate + "结束时间" + eDate);
            fullCalendar.setmTitle(titleName);
            fullCalendar.setmContent(content + meetingType);
            fullCalendar.setWoId(adminId);
            fullCalendar.setStartTime(sDate);
            ;
            fullCalendar.setEndTime(eDate);
            fullCalendar.setIfAllDay(allDay);
            fullCalendar.setColorInfo(colorInfo);
            fullCalendar.setMpId(mpId);//地点
            fullCalendar.setMstate(mstate);
            fullCalendar.setMremark(remark);
            sysCalendarService.addInfo(fullCalendar);
        }
    }

    /**
     * 添加时查询当前用户当天是否添加过日程
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/queryCalendearById", method = RequestMethod.POST)
    public void queryCalendearById(HttpServletResponse response,@RequestParam("mid") Integer mid) throws Exception{
        response.setContentType("text/html;charset=utf8");
        System.out.println("================进入请求============");
        System.out.println("midmidmidmidmidmidmidmidmidmdimdimdimdimdimid======================================="+mid);
        OaMeetingCustom meeting = sysCalendarService.queryCalendearById(mid);
        System.out.println(meeting+"=====================================================");
        JSONObject json=new JSONObject();
        json.put("infomation",meeting);
        response.getWriter().write(json.toString());
    }
}
