package org.java.mapper;

import org.java.entity.OaTeamEmail;

public interface OaTeamEmailMapper {
    int deleteByPrimaryKey(String emId);

    int insert(OaTeamEmail record);

    int insertSelective(OaTeamEmail record);

    OaTeamEmail selectByPrimaryKey(String emId);

    int updateByPrimaryKeySelective(OaTeamEmail record);

    int updateByPrimaryKeyWithBLOBs(OaTeamEmail record);

    int updateByPrimaryKey(OaTeamEmail record);
}