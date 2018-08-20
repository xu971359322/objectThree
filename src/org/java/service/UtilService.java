package org.java.service;

import org.java.entity.OaMeetingCustom;

import java.util.List;

public interface UtilService {
    public Integer getRoleId();

    public void setRoleId(Integer roleId);

    public List<OaMeetingCustom> getMeetingAll();
}
