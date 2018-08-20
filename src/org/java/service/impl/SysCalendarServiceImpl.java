package org.java.service.impl;

import org.java.entity.OaMeetingCustom;
import org.java.entity.OaMettingplace;
import org.java.mapper.OaMeetingCustomMapper;
import org.java.mapper.OaMettingplaceMapper;
import org.java.service.SysCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD2;

import java.util.List;
import java.util.Map;

@Service("sysCalendarService")
@Transactional
public class SysCalendarServiceImpl implements SysCalendarService{

    @Autowired
    private OaMeetingCustomMapper oaMeetingCustomMapper;

    @Autowired
    private OaMettingplaceMapper oaMettingplaceMapper;

    @Override
    public List<OaMeetingCustom> getList(String start, String end) {
        return oaMeetingCustomMapper.getList(start,end);
    }

    @Override
    public List<OaMeetingCustom> queryAll(String start, String end) {
        return oaMeetingCustomMapper.queryAll(start,end);
    }

    @Override
    public List<Map<String, Object>> getDetpPersonList() {
        return oaMeetingCustomMapper.getDetpPersonList();
    }

    @Override
    public void addInfo(OaMeetingCustom fullCalendar) {
        oaMeetingCustomMapper.addInfo(fullCalendar);
    }

    @Override
    public List<OaMettingplace> getPlaceAll() {
        return oaMettingplaceMapper.getPlaceAll();
    }

    @Override
    public OaMeetingCustom queryCalendearById(Integer mid){
        return oaMeetingCustomMapper.queryCalendearById(mid);
    }
}
