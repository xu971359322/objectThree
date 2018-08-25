package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamRole;

import java.util.List;
import java.util.Map;

public interface OaTeamRoleCustomMapper{
    public void insert(Map<String,Object> map);

    public List<Map<String,Object>> getTeamRoleListBycondition();

    public void addPermission(Map<String,Object> per);
}