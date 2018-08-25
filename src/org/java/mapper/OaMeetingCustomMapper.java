package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaMeetingCustom;
import org.java.entity.OaMettinguser;

import java.util.List;
import java.util.Map;

public interface OaMeetingCustomMapper {
    public List<OaMeetingCustom> getList(@Param("start") String start, @Param("end") String end);

    public List<OaMeetingCustom> queryAll(@Param("start") String start, @Param("end") String end);//*start,end,adminName*/

    public void addInfo(OaMeetingCustom custom);

    public List<Map<String,Object>> getDetpPersonList();

    public OaMeetingCustom queryCalendearById(@Param("mid") Integer mid);

    public List<Map<String,Object>> getMeetingAll();

    public List<Map<String,Object>> queryCalendearAllInfo(@Param("mid") Integer mid);

    public void updateMeetingInfo(Map<String,Object> map);

    public Map<String,Object> selectInfoByMidAndWoId(@Param("mId") Integer mId,@Param("woId") String woId);

    public void deleteInfoByMid(@Param("mId") Integer mId);
}