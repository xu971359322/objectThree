package org.java.service;

import org.java.entity.OaMeetingCustom;
import org.java.entity.OaTeamEmail;

import java.util.List;

public interface UtilService {
    public Integer getRoleId();

    public void setRoleId(Integer roleId);

    public List<OaMeetingCustom> getMeetingAll();

    public List<OaTeamEmail> getEmailAll();
}
