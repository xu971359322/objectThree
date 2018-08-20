package org.java.service;

import org.java.entity.OaTeamEmail;

import java.util.List;
import java.util.Map;

public interface EmailService {

    public OaTeamEmail selEmailById(String emId);

    public void sendEmail(Object[] people,String emId);

    public void addEmail(OaTeamEmail oaTeamEmail);

    public List<Map<String,Object>> groupEmail(String wid);

    public int shouCount(String wid);

    public List<Map<String,Object>> newEmail(String wid);

    public OaTeamEmail lookEmail(String emId);

    //修改收件箱状态修改为已读
    public void updateSemailType(String smId);

    //查看我的收件箱
    public List<Map<String,Object>> shouEmail(String wid);

    public List<OaTeamEmail> myEmail(String wid,Integer status);


    public void updateEmail(Integer status,String emId);

}

