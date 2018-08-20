package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaMeetingCustom;
import org.java.entity.OaMettingplace;

import java.util.List;
import java.util.Map;

public interface SysCalendarService{
    public List<OaMeetingCustom> getList(String start,String end);

    public List<OaMeetingCustom> queryAll(String start,String end);/*start,end,adminName*/

    public List<Map<String,Object>> getDetpPersonList();

    public void addInfo(OaMeetingCustom fullCalendar);

    public List<OaMettingplace> getPlaceAll();

    public OaMeetingCustom queryCalendearById(Integer mid);
}
