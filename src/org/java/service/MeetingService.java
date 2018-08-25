package org.java.service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface MeetingService {


    public List<Map<String,Object>> seleapproval();
    public List<Map<String,Object>> selemeeting( Integer id);
    public void updatemeeting(  Map<String,Object> m);
    public List<Map<String,Object>> seleratifymeeting();
    public List<Map<String,Object>> selephone(Integer id);
    public List<Map<String,Object>> noratify();
    public void deletemetting(Integer id);
    public List<Map<String,Object>> seleallmeetingroom();
    public List<Map<String,Object>> showonemeetingroom(Integer id);
    public  void updateonemettingroom( Map<String,Object> m);
    public  void addonemeetingroom( Map<String,Object> m);
    public void addinform(Integer id);
    public  void updateinform( Map<String,Object> m);
    public List<Map<String,Object>> selemeeting22(Integer id);
}
