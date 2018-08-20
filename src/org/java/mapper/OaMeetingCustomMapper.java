package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaMeetingCustom;

import java.util.List;
import java.util.Map;

public interface OaMeetingCustomMapper {
    public List<OaMeetingCustom> getList(@Param("start") String start, @Param("end") String end);

    public List<OaMeetingCustom> queryAll(@Param("start") String start, @Param("end") String end);//*start,end,adminName*/

    public void addInfo(OaMeetingCustom custom);

    public List<Map<String,Object>> getDetpPersonList();

    public OaMeetingCustom queryCalendearById(@Param("mid") Integer mid);

    public List<OaMeetingCustom> getMeetingAll();
}