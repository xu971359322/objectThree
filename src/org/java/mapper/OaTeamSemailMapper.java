package org.java.mapper;

import org.java.entity.OaTeamSemail;

public interface OaTeamSemailMapper {
    int deleteByPrimaryKey(Integer seId);

    int insert(OaTeamSemail record);

    int insertSelective(OaTeamSemail record);

    OaTeamSemail selectByPrimaryKey(Integer seId);

    int updateByPrimaryKeySelective(OaTeamSemail record);

    int updateByPrimaryKey(OaTeamSemail record);
}