package org.java.service.impl;

import org.java.entity.OaMeetingCustom;
import org.java.entity.OaTeamEmail;
import org.java.mapper.OaMeetingCustomMapper;
import org.java.mapper.OaTeamEmailMapperCustom;
import org.java.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("utilService")
public class UtilServiceImpl implements UtilService{

    @Autowired
    private OaTeamEmailMapperCustom oaTeamEmailMapperCustom;

    @Autowired
    private OaMeetingCustomMapper oaMeetingCustomMapper;

    protected Integer roleId;

    @Override
    public Integer getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(Integer roleId) {
        this.roleId=roleId;
    }

    @Override
    public List<Map<String,Object>> getMeetingAll() {
        return oaMeetingCustomMapper.getMeetingAll();
    }

    @Override
    public List<OaTeamEmail> getEmailAll() {
        return oaTeamEmailMapperCustom.getEmailAll();
    }

    @Override
    public List<Map<String, Object>> queryCalendearAllInfo(Integer mid) {
        return oaMeetingCustomMapper.queryCalendearAllInfo(mid);
    }
}
