package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamLeavebill;

import java.util.List;

public interface OaTeamLeavebillMapperCustom {

    //根据地查询请假信息
    public List<OaTeamLeavebill> selLeaveById(@Param("id") String id);
}