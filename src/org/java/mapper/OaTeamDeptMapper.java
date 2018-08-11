package org.java.mapper;

import org.java.entity.OaTeamDept;

public interface OaTeamDeptMapper {
    int deleteByPrimaryKey(Integer deId);

    int insert(OaTeamDept record);

    int insertSelective(OaTeamDept record);

    OaTeamDept selectByPrimaryKey(Integer deId);

    int updateByPrimaryKeySelective(OaTeamDept record);

    int updateByPrimaryKey(OaTeamDept record);
}