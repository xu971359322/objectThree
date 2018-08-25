package org.java.mapper;

import org.java.entity.OaTeamLeavebill;

public interface OaTeamLeavebillMapper {
    int deleteByPrimaryKey(String lbId);

    int insert(OaTeamLeavebill record);

    int insertSelective(OaTeamLeavebill record);

    OaTeamLeavebill selectByPrimaryKey(String lbId);

    int updateByPrimaryKeySelective(OaTeamLeavebill record);

    int updateByPrimaryKey(OaTeamLeavebill record);
}