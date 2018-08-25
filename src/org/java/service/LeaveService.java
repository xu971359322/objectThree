package org.java.service;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.java.entity.OaTeamLeavebill;
import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

public interface LeaveService {


    //拾取任务
    public void claimTask(String taskId,String name);

    //根据名字查询所有可以拾取的任务
    public List<Map<String,Object>> queryGroupTask(String name);

    //完成任务
    public void overTask(String taskid, OaTeamWorker worker, String comment, String outcome);

    //根据taskid查询历史流程变量
    public List<Comment> findCommentByTask(String taskId);

    //根据taskid查询请假信息
    public OaTeamLeavebill findLeaveByTask(String taskId);

    //查看个人办理任务
    public List<Task> findTaskByName(String name);

    //开始任务
    public void startProcessInstance(String uname,String lid);

    //修改请假单状态
    public void updateLeave(OaTeamLeavebill leavebill);

    //根基id查询个人请假单
    public List<OaTeamLeavebill> selLeaveById(String id);

    //添加请假单
    public void addLeaveBill(OaTeamLeavebill leavebill);
}
