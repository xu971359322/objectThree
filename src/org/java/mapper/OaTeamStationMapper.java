package org.java.mapper;

import org.java.entity.OaTeamStation;

public interface OaTeamStationMapper {
    int deleteByPrimaryKey(Integer stId);

    int insert(OaTeamStation record);

    int insertSelective(OaTeamStation record);

    OaTeamStation selectByPrimaryKey(Integer stId);

    int updateByPrimaryKeySelective(OaTeamStation record);

    int updateByPrimaryKey(OaTeamStation record);
}