package org.java.service;

import org.java.entity.OaTeamReport;

import java.util.List;

public interface ReportService {

    //开始任务
    public void startProcessInstance(String uname,String rid);

    //修改请假单状态
    public void updateReport(OaTeamReport oaTeamReport);

    //根据主键查询业务单
    public List<OaTeamReport> selReportById(String woId);

    //新增业务单
    public void addReport(OaTeamReport oaTeamReport);

}
