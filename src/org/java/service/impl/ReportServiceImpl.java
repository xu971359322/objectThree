package org.java.service.impl;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.java.entity.OaTeamReport;
import org.java.mapper.OaTeamReportMapper;
import org.java.mapper.OaTeamReportMapperCustom;
import org.java.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OaTeamReportMapper oaTeamReportMapper;

    @Autowired
    private OaTeamReportMapperCustom oaTeamReportMapperCustom;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Override
    public void startProcessInstance(String uname, String rid) {

    }

    @Override
    public void updateReport(OaTeamReport oaTeamReport) {

    }

    @Override
    public List<OaTeamReport> selReportById(String woId) { return  oaTeamReportMapperCustom.selLeaveById(woId);  }

    @Override
    public void addReport(OaTeamReport oaTeamReport) {
        oaTeamReportMapper.insert(oaTeamReport);
    }
}
