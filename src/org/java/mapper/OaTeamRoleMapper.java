package org.java.mapper;

import org.java.entity.OaTeamRole;

public interface OaTeamRoleMapper {
    int deleteByPrimaryKey(Integer roId);

    int insert(OaTeamRole record);

    int insertSelective(OaTeamRole record);

    OaTeamRole selectByPrimaryKey(Integer roId);

    int updateByPrimaryKeySelective(OaTeamRole record);

    int updateByPrimaryKey(OaTeamRole record);
}