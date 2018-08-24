package org.java.service;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.java.entity.OaTeamReport;
import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

public interface ReportService {

    //通过业务id查询历史审批记录
    public List<Comment> hisComment(String rid);

    //拾取任务
    public void claimTask(String taskId ,String name);

    //查看可拾取任务
    List<Map<String ,Object>> queryGroupTask(String uname);

    //完成任务
    public void overTask(String taskid, OaTeamWorker worker, String comment, String outcome,double money);

    //通过taskId查询历史审批记录
    public List<Comment> findCommentByTask(String taskId);

    //通过taskId查询我的任务
    public OaTeamReport findReportByTask(String taskId);

    //根据名字查询办理的任务
    public List<Task> findTaskByName(String name);

    //开始任务
    public void startProcessInstance(String uname,String rid);

    //修改请假单状态
    public void updateReport(OaTeamReport oaTeamReport);

    //根据主键查询业务单
    public List<OaTeamReport> selReportById(String woId);

    //新增业务单
    public void addReport(OaTeamReport oaTeamReport);

}
