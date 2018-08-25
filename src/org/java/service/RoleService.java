package org.java.service;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamRole;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public List<OaTeamRole> getSelectType();

    public void insert(Map<String,Object> map);

    public List<List<Map<String,Object>>> getTeamRoleListBycondition();

    public void addPermission(Map<String,Object> per);
}
