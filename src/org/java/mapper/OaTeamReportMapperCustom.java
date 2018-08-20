package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamReport;

import java.util.List;

public interface OaTeamReportMapperCustom {

    public List<OaTeamReport> selLeaveById(@Param("id") String woId);

}