package org.java.service.impl;

import org.java.mapper.MeetingMapper;
import org.java.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private  MeetingMapper meetingMapper;


    public List<Map<String,Object>> selemeeting22(Integer id){
        List<Map<String,Object>>  list=  meetingMapper.selemeeting22(id);
        return  list;
    };

    public  void updateinform( Map<String,Object> m){
        meetingMapper.updateinform(m);
    };

    public void addinform(Integer id){

        meetingMapper.addinform(id);
    };
    public  void addonemeetingroom( Map<String,Object> m){

        meetingMapper.addonemeetingroom(m);
    };
    public  void updateonemettingroom( Map<String,Object> m){
        meetingMapper.updateonemettingroom(m);
    };

    public List<Map<String,Object>> showonemeetingroom(Integer id){
        List<Map<String,Object>>  list=meetingMapper.showonemeetingroom(id);

        return  list;
    };

    public List<Map<String,Object>> seleallmeetingroom(){

        List<Map<String,Object>>  list=meetingMapper.seleallmeetingroom();

        return  list;
    };
    public void deletemetting(Integer id){
        meetingMapper.deletemetting(id);
    };

    public List<Map<String,Object>> noratify(){
        List<Map<String,Object>>  list=meetingMapper.noratify();

        return  list;
    };
    public List<Map<String,Object>> selephone(Integer id){
        List<Map<String,Object>>  list=meetingMapper.selephone(id);

        return  list;
    };
        public List<Map<String,Object>> seleratifymeeting(){

            List<Map<String,Object>>  list=meetingMapper.seleratifymeeting();

        return  list;
    };

    public void updatemeeting(  Map<String,Object> m){
        meetingMapper.updatemeeting(m);
    };
    public List<Map<String,Object>> selemeeting( Integer id){

        List<Map<String,Object>>  list=meetingMapper.selemeeting(id);

        return  list;
    };

    public List<Map<String,Object>> seleapproval(){
        List<Map<String,Object>> list=meetingMapper.seleapproval();
        return  list;
    };


}
