package org.java.service.impl;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.java.entity.OaTeamLeavebill;
import org.java.entity.OaTeamReport;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaTeamLeavebillMapper;
import org.java.mapper.OaTeamLeavebillMapperCustom;
import org.java.mapper.OaTeamWorkerCustomMapper;
import org.java.mapper.OaTeamWorkerMapper;
import org.java.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("leaveService")
@Transactional
public class LeaveServiceImpl implements LeaveService {


    @Autowired
    private OaTeamLeavebillMapper leavebillMapper;

    @Autowired
    private OaTeamLeavebillMapperCustom leavebillMapperCustom;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private OaTeamWorkerMapper oaTeamWorkerMapper;

    @Autowired
    private OaTeamWorkerCustomMapper oaTeamWorkerCustomMapper;



    @Override
    public void claimTask(String taskId, String name) {
        TaskQuery query = taskService.createTaskQuery();

        //设置候选人，判断当前候选人是否有资格拾取
        if(query.taskCandidateUser(name).taskId(taskId).singleResult()!=null){
            taskService.claim(taskId, name);
            System.out.println("拾取成功");
        }else{
            System.out.println("拾取失败");
        }
    }

    @Override
    public List<Map<String, Object>> queryGroupTask(String name) {
        List<Task> list = taskService.createTaskQuery()
                .taskCandidateUser(name)
                .list();//设置要查询的候选人

        //查询出业务数据
        List<Map<String, Object>> tasklist = new ArrayList<Map<String, Object>>();

        for (Task t : list) {
            //获得流程实例 的id
            String processInstanceId = t.getProcessInstanceId();

            //根据processInstanceId获得业务数据
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(processInstanceId)
                    .singleResult();
            String businessKey = processInstance.getBusinessKey();

            //得到请假信息
            OaTeamLeavebill leavebill= leavebillMapper.selectByPrimaryKey(businessKey);

            Map<String, Object> map = new HashMap<String, Object>();

            //得到创建人
            OaTeamWorker oaTeamWorker = oaTeamWorkerMapper.selectByPrimaryKey(leavebill.getWoId());

            map.put("taskId", t.getId());//任务id
            map.put("taskName", t.getName());//任务名称
            map.put("createTime", t.getCreateTime());// 创建时间
            map.put("leavebill", leavebill);
            map.put("name", oaTeamWorker.getWoName());

            tasklist.add(map);
        }

        return tasklist;
    }

    @Override
    public void overTask(String taskid, OaTeamWorker worker, String comment, String outcome) {

        Task task = taskService.createTaskQuery()
                .taskId(taskid)
                .singleResult();

        //得到流程实例id
        String processInstanceId = task.getProcessInstanceId();

        //向comment表中添加数据
        Authentication.setAuthenticatedUserId(worker.getWoName());//添加当前任务审核人
        taskService.addComment(taskid,processInstanceId,comment);

        Map<String, Object> variables =new HashMap<String, Object>();

        variables.put("outcome",outcome);

        //普通员工提交
        if(worker.getWoRole()==5){
            List<OaTeamWorker> manage = oaTeamWorkerCustomMapper.selDeptManage(worker.getWoDeptid());
            String users =getUsers(manage);

            variables.put("users",users);

            System.out.println(users);
        }
        if(worker.getWoRole()==4){
            List<OaTeamWorker> oaTeamWorkers = oaTeamWorkerCustomMapper.selManageByIdenty(2);
            String users =getUsers(oaTeamWorkers);

            variables.put("users",users);

        }

        taskService.complete(taskid,variables);

        //判断任务是否结束
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        //流程已结束 修改流程状态
        if(pi==null){
            //通过历史流程得到BusinessKey
            HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(processInstanceId)
                    .singleResult();

            String businessKey = hpi.getBusinessKey();

            OaTeamLeavebill leavebill = leavebillMapper.selectByPrimaryKey(businessKey);

            leavebill.setLbStatus(2);//1表示在执行  2表示已结束

            leavebillMapper.updateByPrimaryKeySelective(leavebill);
        }

    }

    public String getUsers(List<OaTeamWorker> list){
        String users=list.get(0).getWoName();
        for (int i =1;i<list.size();i++){
            users+=","+list.get(i).getWoName();
        }
        return users;
    }

    @Override
    public List<Comment> findCommentByTask(String taskId) {
        Task task = taskService.createTaskQuery()
            .taskId(taskId)
            .singleResult();

        String processInstanceId = task.getProcessInstanceId();

        List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);

        return list;
    }

    @Override
    public OaTeamLeavebill findLeaveByTask(String taskId) {
        System.out.println("taskId:"+taskId);

        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();

        String processInstanceId = task.getProcessInstanceId();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        String businessKey = processInstance.getBusinessKey();


        System.out.println("businessKey:"+businessKey);

        OaTeamLeavebill leavebill= leavebillMapper.selectByPrimaryKey(businessKey);

        System.out.println(leavebill);

        return leavebill;
    }

    @Override
    public List<Task> findTaskByName(String name) {
        List<Task> list = taskService.createTaskQuery()
                .taskAssignee(name)
                .orderByTaskCreateTime().asc()
                .list();
        List<Task> list2 = new ArrayList<>();
        for (Task task : list) {
            String processDefinitionId = task.getProcessDefinitionId();
            String aaa= processDefinitionId.substring(0,processDefinitionId.indexOf(":"));
            if(aaa.equals("leavebill")){
                list2.add(task);
            }

        }
        return list2;
    }

    @Override
    public void startProcessInstance(String uname, String lid) {

        String key ="leavebill";
        Map<String, Object> map =new HashMap<>();
        map.put("user",uname);

        runtimeService.startProcessInstanceByKey(key,lid,map);

    }

    @Override
    public void updateLeave(OaTeamLeavebill leavebill) {
        leavebillMapper.updateByPrimaryKeySelective(leavebill);
    }

    @Override
    public List<OaTeamLeavebill> selLeaveById(String id) {
        return leavebillMapperCustom.selLeaveById(id);
    }

    @Override
    public void addLeaveBill(OaTeamLeavebill leavebill) {
            leavebillMapper.insertSelective(leavebill);
    }
}
