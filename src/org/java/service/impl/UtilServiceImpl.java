package org.java.service.impl;

import org.java.service.UtilService;
import org.springframework.stereotype.Service;

@Service("utilService")
public class UtilServiceImpl implements UtilService{

    protected Integer roleId;

    @Override
    public Integer getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(Integer roleId) {
        this.roleId=roleId;
    }
}
