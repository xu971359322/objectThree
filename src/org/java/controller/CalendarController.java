package org.java.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.java.entity.OaMeetingCustom;
import org.java.entity.OaMettinguser;
import org.java.service.SysCalendarService;
import org.java.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/calendar")
public class CalendarController extends BaseController{

    @Autowired
    @Qualifier("sysCalendarService")
    private SysCalendarService sysCalendarService;

    @Autowired
    private UtilService utilService;


    @RequestMapping(value = "/doList", method = RequestMethod.POST)
    public void doList(HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf8");
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        List<OaMeetingCustom> mapList =sysCalendarService.getList(start,end);
        JSONArray datas = JSONArray.fromObject(mapList);
        response.getWriter().print(datas.toString());
    }

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
    public void fullCalendar(HttpServletResponse response,
                             @RequestParam(value = "meetingName") String meetingName,
                             @RequestParam(value = "start") Date start,
                             @RequestParam(value = "end") Date end,
                             @RequestParam(value = "colorInfo") String colorInfo,
                             @RequestParam(value = "allDay") Boolean allDay,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "remark") String remark,
                             @RequestParam(value = "mpId") Integer mpId,
                             @RequestParam(value = "mstate") Integer mstate,
                             @RequestParam(value = "meetingType") Integer meetingType,
                             @RequestParam(value = "infoIds") String infoIds) throws IOException, ParseException {

        response.setContentType("text/html;charset=utf8");
        Map<String,Object> worker=(Map<String,Object>) session.getAttribute("worker");
        String adminId=worker.get("wo_id").toString();

       /* String[] array = { eightColor, tenColor, thirteenColor, fifteenColor };
        for (int i = 0; i < array.length; i++) {
            UpdateStatement(array[i], i, adminId,meetingName, start,end, eightColor, tenColor, thirteenColor, fifteenColor,allDay,content);
        }*/

        UpdateStatement(1, adminId,meetingName, start,end, colorInfo,allDay,content,mpId,mstate,meetingType,remark,infoIds);
    }



    @RequestMapping(value = "/fullCalendarUpdate", method = RequestMethod.POST)
    public void fullCalendarUpdate(HttpServletResponse response,
                             @RequestParam(value = "meetingNameChange") String meetingNameChange,
                             @RequestParam(value = "startChange") Date startChange,
                             @RequestParam(value = "endChange") Date endChange,
                             @RequestParam(value = "colorInfoChange") String colorInfoChange,
                             @RequestParam(value = "allDayChange") Boolean allDayChange,
                             @RequestParam(value = "contentChange") String contentChange,
                             @RequestParam(value = "remarkChange") String remarkChange,
                             @RequestParam(value = "mpIdChange") Integer mpIdChange,
                             @RequestParam(value = "mstateChange") Integer mstateChange,
                             @RequestParam(value = "meetingTypeChange") Integer meetingTypeChange,
                             @RequestParam(value = "infoIdsChange") String infoIdsChange,
                             @RequestParam(value = "mIdInfomation") Integer mIdInfomation) throws IOException, ParseException {

        response.setContentType("text/html;charset=utf8");
/*        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>+++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(meetingNameChange+"==="+meetingTypeChange + "==" + startChange + "==" + endChange + "===" + colorInfoChange + "==" + mIdInfomation);*/
        OaMettinguser oaMettinguser=new OaMettinguser();
        Map<String,Object> worker=(Map<String,Object>) session.getAttribute("worker");
        String adminId=worker.get("wo_id").toString();
        Map<String,Object> updateMap=new HashMap<String, Object>();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sDate = sf.format(startChange);
        String eDate = sf.format(endChange);
        updateMap.put("meetingNameChange",meetingNameChange);
        updateMap.put("sDate",sDate);
        updateMap.put("eDate",eDate);
        updateMap.put("colorInfoChange",colorInfoChange);
        updateMap.put("allDayChange",allDayChange);
        updateMap.put("contentChange",contentChange);
        updateMap.put("remarkChange",remarkChange);
        updateMap.put("mpIdChange",mpIdChange);
        updateMap.put("mstateChange",mstateChange);
        updateMap.put("meetingTypeChange",meetingTypeChange);
        updateMap.put("infoIdsChange",infoIdsChange);
        updateMap.put("mIdInfomation",mIdInfomation);
        String [] newInfoId=infoIdsChange.split(",");
        System.out.println(newInfoId.length+"=================");
        List<Map<String, Object>> mIdPerson = sysCalendarService.updateMeetingInfo(updateMap);
        for (Map<String, Object> map : mIdPerson) {
            System.out.println(map);
        }
        /*System.out.println("============================="+mIdPerson.size()+"====="+mIdInfomation+"=="+newInfoId);*/
        if(mIdPerson==null||mIdPerson.size()==0){
            if(newInfoId!=null||newInfoId.length!=0){
                for(int k=0;k<newInfoId.length;k++){
                    if(newInfoId[k]!="") {
                        oaMettinguser.setmId(mIdInfomation);
                        oaMettinguser.setWoId(newInfoId[k]);
                        sysCalendarService.insert(oaMettinguser);
                        System.out.println("--------一次--------");
                    }
                }
            }
        }/*else if(mIdPerson!=null && mIdPerson.size()!=0){
            System.out.println("不是空的");
            for (int i=0;i<mIdPerson.size();i++){
                for(int k=0;k<newInfoId.length;k++) {
                    if(newInfoId[k]!="") {
                        System.out.println(newInfoId[k]+"````````````````"+mIdPerson.get(i).get("wo_id").toString());
                        if (!mIdPerson.get(i).get("wo_id").toString().equals(newInfoId[k])) {
                            Map<String,Object> mettinguser = sysCalendarService.selectInfoByMidAndWoId(mIdInfomation,newInfoId[k]);
                            System.out.println(mettinguser+"===================="+mIdInfomation);
                            if (mettinguser == null) {
                          *//*  oaMettinguser.setmId(mIdInfomation);
                            oaMettinguser.setWoId(newInfoId[k]);
                            sysCalendarService.insert(oaMettinguser);*//*
                                System.out.println("======添加成功-------");
                            } else{
                            *//*sysCalendarService.deleteInfoByMidAndWoId(mIdInfomation,mIdPerson.get(i).get("wo_id").toString());*//*
                                System.out.println("======删除成功-------");
                            }
                        }
                    }
                }
*//*                for (){

                }*//*
            }
        }*/
    }


    private void UpdateStatement(Integer i, String adminId,
                                 String titleName, Date start, Date end,
                                 String colorInfo,Boolean allDay,String content,Integer mpId,Integer mstate,Integer meetingType,String remark,String wo_id) {
        OaMeetingCustom fullCalendar = new OaMeetingCustom();
        OaMettinguser oaMettinguser=new OaMettinguser();
        if (i == 0) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String sDate = sf.format(start);
            String eDate = sf.format(end);
            fullCalendar.setmTitle(titleName);
            fullCalendar.setmContent(content);
            fullCalendar.setmType(meetingType);
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
            fullCalendar.setmTitle(titleName);
            fullCalendar.setmContent(content);
            fullCalendar.setmType(meetingType);
            fullCalendar.setWoId(adminId);
            fullCalendar.setStartTime(sDate);
            fullCalendar.setEndTime(eDate);
            fullCalendar.setIfAllDay(allDay);
            fullCalendar.setColorInfo(colorInfo);
            fullCalendar.setMpId(mpId);//地点
            fullCalendar.setMstate(mstate);
            fullCalendar.setMremark(remark);
            sysCalendarService.addInfo(fullCalendar);
            oaMettinguser.setmId(fullCalendar.getmId());
            String [] newInfoId=wo_id.split(",");
            for(int k=0;k<newInfoId.length;k++){
                if(newInfoId[k]!=""){
                    oaMettinguser.setWoId(newInfoId[k]);
                    sysCalendarService.insert(oaMettinguser);
                }
            }
        }
    }

    @RequestMapping(value = "/queryCalendearById", method = RequestMethod.POST)
    public void queryCalendearById(HttpServletResponse response,@RequestParam("mid") Integer mid) throws Exception{
        response.setContentType("text/html;charset=utf8");
        OaMeetingCustom meeting = sysCalendarService.queryCalendearById(mid);
       /* System.out.println(meeting+"=====================================================");*/
        JSONObject json=new JSONObject();
        json.put("infomation",meeting);
        response.getWriter().write(json.toString());
    }

    @RequestMapping(value = "/fullCalendarEdit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> fullCalendarEdit(@RequestParam("mid") Integer mid) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        OaMeetingCustom meeting = sysCalendarService.queryCalendearById(mid);
        /*System.out.println(meeting+"=====================================================");*/
        map.put("meeting",meeting);
        List<Map<String, Object>> queryCalendearAllInfo = utilService.queryCalendearAllInfo(mid);
        map.put("queryCalendearAllInfo",queryCalendearAllInfo);
/*        for (Map<String, Object> info : queryCalendearAllInfo) {
            System.out.println(info);
        }*/
        //sysCalendarService.deleteInfoByMid(mid);
        return map;
    }

    @RequestMapping(value = "/fullCalendarDetele", method = RequestMethod.POST)
    public void fullCalendarDetele(@RequestParam(value = "mIdInfomation") Integer mIdInfomation) throws Exception{
        System.out.println("fullCalendarDetele=====================================================");
        sysCalendarService.deleteInfoByMid(mIdInfomation);
    }
}
