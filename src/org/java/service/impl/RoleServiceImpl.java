package org.java.service.impl;

import org.java.entity.OaTeamRole;
import org.java.mapper.OaTeamRoleMapper;
import org.java.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private OaTeamRoleMapper OaTeamRoleMapper;

    @Override
    public List<OaTeamRole> getSelectType() {
        return OaTeamRoleMapper.getSelectType();
    }
}
