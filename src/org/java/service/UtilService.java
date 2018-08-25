package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaMeetingCustom;
import org.java.entity.OaTeamEmail;

import java.util.List;
import java.util.Map;

public interface UtilService {
    public Integer getRoleId();

    public void setRoleId(Integer roleId);

    public List<Map<String,Object>> getMeetingAll();

    public List<OaTeamEmail> getEmailAll();

    public List<Map<String,Object>> queryCalendearAllInfo(@Param("mid") Integer mid);
}
