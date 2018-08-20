package org.java.mapper;

import org.java.entity.OaTeamReport;

public interface OaTeamReportMapper {
    int deleteByPrimaryKey(String reId);

    int insert(OaTeamReport record);

    int insertSelective(OaTeamReport record);

    OaTeamReport selectByPrimaryKey(String reId);

    int updateByPrimaryKeySelective(OaTeamReport record);

    int updateByPrimaryKeyWithBLOBs(OaTeamReport record);

    int updateByPrimaryKey(OaTeamReport record);
}