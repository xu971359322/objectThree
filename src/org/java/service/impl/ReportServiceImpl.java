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
import org.apache.ibatis.jdbc.Null;
import org.java.entity.OaTeamReport;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaTeamReportMapper;
import org.java.mapper.OaTeamReportMapperCustom;
import org.java.mapper.OaTeamWorkerCustomMapper;
import org.java.mapper.OaTeamWorkerMapper;
import org.java.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OaTeamReportMapper oaTeamReportMapper;

    @Autowired
    private OaTeamWorkerMapper oaTeamWorkerMapper;

    @Autowired
    private OaTeamReportMapperCustom oaTeamReportMapperCustom;

    @Autowired
    private OaTeamWorkerCustomMapper oaTeamWorkerCustomMapper;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Override
    public List<Comment> hisComment(String rid) {
        //business

        List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery()
                .processInstanceBusinessKey(rid)
                .list();
        String id ="";
        for (HistoricTaskInstance hti : list) {
            id=hti.getProcessInstanceId();
//            System.out.println(hti.getProcessInstanceId());
//            System.out.println(hti.getName());
//            System.out.println(hti.getAssignee());
//            System.out.println(hti.getClaimTime());
//            System.out.println(hti.getDurationInMillis());
//            System.out.println("-------------------------");
        }

        List<Comment> comment = taskService.getProcessInstanceComments(id);



//        String psid = hti.getProcessInstanceId();
//
//        System.out.println("历史id"+psid);

        return comment;
    }

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
    public List<Map<String, Object>> queryGroupTask(String uname) {
        List<Task> list = taskService.createTaskQuery()
                .taskCandidateUser(uname)
                .list();//设置要查询的候选人

        //查询出业务数据
        List<Map<String,Object>> tasklist = new ArrayList<Map<String,Object>>();

        for (Task t:list){
            //获得流程实例 的id
            String processInstanceId = t.getProcessInstanceId();

            //根据processInstanceId获得业务数据
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(processInstanceId)
                    .singleResult();
            String businessKey = processInstance.getBusinessKey();

            OaTeamReport report = oaTeamReportMapper.selectByPrimaryKey(businessKey);

            Map<String,Object> map = new HashMap<String, Object>();

            OaTeamWorker oaTeamWorker = oaTeamWorkerMapper.selectByPrimaryKey(report.getWoId());


            map.put("taskId",t.getId());//任务id
            map.put("taskName",t.getName());//任务名称
            map.put("createTime",t.getCreateTime());// 创建时间
            map.put("report",report);
            map.put("name",oaTeamWorker.getWoName());

            tasklist.add(map);

        }

        return tasklist;
    }

    @Override
    public void overTask(String taskid, OaTeamWorker worker, String comment, String outcome,double money) {
        Task task = taskService.createTaskQuery()
                .taskId(taskid)
                .singleResult();

        //得到流程实例id
        String processInstanceId = task.getProcessInstanceId();

        String businessKey1 = getBusinessKey(taskid);

        OaTeamReport report1 = oaTeamReportMapper.selectByPrimaryKey(businessKey1);

        money =report1.getReMoney();

        //向comment表中添加数据
        Authentication.setAuthenticatedUserId(worker.getWoName());//添加当前任务审核人
        taskService.addComment(taskid,processInstanceId,comment);

        Map<String, Object> variables =new HashMap<String, Object>();

        //判断是否同意
        variables.put("outcome",outcome);

        //当他是员工
        if(worker.getWoRole()==5&&worker.getWoDeptid()!=2){
            //查询部门经理
            List<OaTeamWorker> manage = oaTeamWorkerCustomMapper.selDeptManage(worker.getWoDeptid());

            String users =getUsers(manage);

            variables.put("users",users);

            System.out.println(users);

        }

        //当时经理提交
        if(worker.getWoRole()==4){
            System.out.println("经理提交");
            if(money == 0){
                variables.put("money",0);
                List<OaTeamWorker> oaTeamWorkers = oaTeamWorkerCustomMapper.selManageByIdenty(2);
                String users =getUsers(oaTeamWorkers);
                variables.put("user",users);
            }else{
                //财务部
                List<OaTeamWorker> oaTeamWorkers = oaTeamWorkerCustomMapper.selDeptEmployee(2);

                String users =getUsers(oaTeamWorkers);

                variables.put("users",users);
                variables.put("money",money);
            }
        }
        taskService.complete(taskid,variables);

        //判断任务是否结束
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        if(pi==null){
            HistoricProcessInstance hpi = historyService.createHistoricProcessInstanceQuery()
                    .processInstanceId(processInstanceId)
                    .singleResult();

            String businessKey = hpi.getBusinessKey();
            OaTeamReport report = oaTeamReportMapper.selectByPrimaryKey(businessKey);

            //修改状态
            report.setReStatus(2);

            oaTeamReportMapper.updateByPrimaryKeySelective(report);

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
    public OaTeamReport findReportByTask(String taskId) {

        String businessKey = getBusinessKey(taskId);//得到业务表id

        return oaTeamReportMapper.selectByPrimaryKey(businessKey);
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
            if(aaa.equals("report")){
                list2.add(task);
            }

        }
        return list2;
    }

    @Override
    public void startProcessInstance(String uname, String reportId) {
        String key ="report";
        Map<String, Object> map =new HashMap<>();
        map.put("user",uname);
        runtimeService.startProcessInstanceByKey(key,reportId,map);
    }

    @Override
    public void updateReport(OaTeamReport oaTeamReport) {
        oaTeamReportMapper.updateByPrimaryKeySelective(oaTeamReport);
    }

    @Override
    public List<OaTeamReport> selReportById(String woId) {
        return  oaTeamReportMapperCustom.selReportById(woId);
    }

    @Override
    public void addReport(OaTeamReport oaTeamReport) {
        oaTeamReportMapper.insertSelective(oaTeamReport);
    }


    //通过taskId得到业务主键id
    public  String getBusinessKey(String taskId){
        //得到任务
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();

        //通过任务得到流程实例ID
        String processInstanceId = task.getProcessInstanceId();

        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        String businessKey = processInstance.getBusinessKey();

        return businessKey;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
