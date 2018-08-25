package org.java.controller;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.java.entity.OaTeamLeavebill;
import org.java.entity.OaTeamWorker;
import org.java.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/leave")
public class LeaveController extends BaseController {

    @Autowired
    private LeaveService leaveService;


    //拾取任务
    @RequestMapping("claimTask")
    public String claimTask(String taskId){
        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");
        leaveService.claimTask(taskId,worker.getWoName());
        System.out.println();
        return "redirect:queryGroupTask.do";
    }

    //查询可以拾取的任务
    @RequestMapping("queryGroupTask")
    public String queryGroupTask(Model model) {
        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");
        List<Map<String,Object>> list =leaveService.queryGroupTask(worker.getWoName());
        model.addAttribute("list",list);
        System.out.println(list.size());

        return "/xu/leavebill/groupTask";
    }

    //完成任务
    @RequestMapping("taskOver")
    public String taskOver(String taskId,String comment,String outcome,Model model){

        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");

        leaveService.overTask(taskId,worker,comment,outcome);

        return "redirect:findTaskByName.do";
    }

    //查看任务信息
    @RequestMapping("taskProcess")
    public  String taskProcess(String taskId,Model model){

        OaTeamLeavebill leavebill = leaveService.findLeaveByTask(taskId);

        List<Comment> list = leaveService.findCommentByTask(taskId);

        model.addAttribute("taskId",taskId);
        model.addAttribute("leave",leavebill);
        model.addAttribute("list",list);

        return "/xu/leavebill/leaveApprover";
    }

    //查看个人任务
    @RequestMapping("findTaskByName")
    public String findTaskByName(Model model){
        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");

        List<Task> task = leaveService.findTaskByName(worker.getWoName());
        model.addAttribute("list",task);

        System.out.println(task.size());
        return "/xu/leavebill/leaveTask";
    }

    //申请休假  启动流程实例
    @RequestMapping("startProcess")
    public String startProcess(OaTeamLeavebill leavebill) {
        System.out.println("leavebill");
        //修改请假状态
        leavebill.setLbStatus(1);
        leaveService.updateLeave(leavebill);

        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");

        leaveService.startProcessInstance(worker.getWoName(),leavebill.getLbId());

        return "redirect:queryProcessInstance.do";
    }

    //新增请假单
    @RequestMapping("addLeaver")
    public String addLeaver(OaTeamLeavebill leavebill){
        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");

        leavebill.setLbTime(new Date());
        leavebill.setLbStatus(0);
        leavebill.setLbId(UUID.randomUUID().toString());
        leavebill.setWoId(worker.getWoId());

        System.out.println(leavebill);
        leaveService.addLeaveBill(leavebill);
        return "redirect:queryProcessInstance.do";
    }

    //查询个人请假单
    @RequestMapping("queryProcessInstance")
    public String queryProcessInstance(){
        OaTeamWorker worker = (OaTeamWorker) session.getAttribute("worker");

        List<OaTeamLeavebill> list = leaveService.selLeaveById(worker.getWoId());
        request.setAttribute("list",list);

        return  "/xu/leavebill/myLeavebill";
    }
}
