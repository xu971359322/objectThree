package org.java.mapper;

import org.java.entity.OaArticleReply;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface MeetingMapper {

 public List<Map<String,Object>> seleapproval();
 public List<Map<String,Object>>  selemeeting( Integer id);
 public  void updatemeeting(@PathVariable Map<String,Object> m);
 public List<Map<String,Object>> seleratifymeeting();
 public List<Map<String,Object>> selephone(Integer id);
 public List<Map<String,Object>> noratify();
 public void deletemetting(Integer id);
 public List<Map<String,Object>> seleallmeetingroom();
 public List<Map<String,Object>> showonemeetingroom(Integer id);
 public  void updateonemettingroom(@PathVariable Map<String,Object> m);
 public  void addonemeetingroom(@PathVariable Map<String,Object> m);
 public void addinform(Integer id);
 public  void updateinform(@PathVariable Map<String,Object> m);
 public List<Map<String,Object>> selemeeting22(Integer id);

 }