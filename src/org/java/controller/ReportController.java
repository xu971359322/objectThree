package org.java.controller;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.logging.log4j.core.helpers.UUIDUtil;
import org.java.entity.OaTeamReport;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaTeamWorkerCustomMapper;
import org.java.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private OaTeamWorkerCustomMapper oaTeamWorkerCustomMapper;

    @RequestMapping("hisComment")
    public String hisComment(String id){
        List<Comment> list = reportService.hisComment(id);
        request.setAttribute("list",list);
        return "/xu/report/hisComment";
    }


    //拾取任务
    @RequestMapping("claimTask")
    public String claimTask(String taskId){
        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");

        reportService.claimTask(taskId,user.getWoName());

        return "redirect:queryGroupTask.do";
    }

    //查看组任务
    @RequestMapping("queryGroupTask")
    public String queryGroupTask(){
        System.out.println("queryGroupTask");
        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");
        List<Map<String,Object>> list =reportService.queryGroupTask(user.getWoName());
        request.setAttribute("list",list);
        System.out.println(list.size());
        return "/xu/report/groupTask";
    }

    //完成任务
    @RequestMapping("taskOver")
    public String taskOver(String taskId,String comment,String outcome,double money,Model model){


        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");

        //完成任务
        reportService.overTask(taskId,user,comment,outcome,money);

        return "redirect:findTaskByName.do";
    }

    //查看任务信息
    @RequestMapping("taskProcess")
    public  String taskProcess(String taskId){

        OaTeamReport report = reportService.findReportByTask(taskId);

        List<Comment> list = reportService.findCommentByTask(taskId);

        request.setAttribute("report",report);
        request.setAttribute("list",list);
        request.setAttribute("taskId",taskId);

        return "/xu/report/reportApprover";
    }

    //查看个人任务
    @RequestMapping("findTaskByName")
    public String findTaskByName(){
        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");

        List<Task> list = reportService.findTaskByName(user.getWoName());
        request.setAttribute("list",list);

        return "/xu/report/taskReport";
    }

    //开始文案审批  启动流程实例
    @RequestMapping("startProcess")
    public String startProcess(OaTeamReport report) {
        //System.out.println(report);
        //修改文案状态
        report.setReStatus(1);
        reportService.updateReport(report);

        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");

        //启动流程实例
        reportService.startProcessInstance(user.getWoName(),report.getReId());

        return "redirect:selReportById.do";
    }

    //查询我的业务单
    @RequestMapping("/selReportById")
    public String selReportById(){
        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");
        List<OaTeamReport> list = reportService.selReportById(user.getWoId());
        request.setAttribute("list",list);
        return "/xu/report/myReport";
    }

    //添加业务单
    @RequestMapping("/addReport")
    public String addReport(@RequestParam("title")String title,
                            @RequestParam("content")String content,
                            @RequestParam("money")double money,
                            @RequestParam("file")CommonsMultipartFile file)throws Exception{
        OaTeamWorker user =(OaTeamWorker) session.getAttribute("worker");
        OaTeamReport report = new OaTeamReport();
        report.setWoId(user.getWoId());
        report.setReId(UUIDUtil.getTimeBasedUUID().toString());
        report.setReTitle(title);
        report.setReContent(content);
        report.setReTime(new Date());
        report.setReStatus(0);
        report.setReMoney(money);

        if(file.getOriginalFilename()!=""){
            String path = servletContext.getRealPath("file");
            File newfile =new File(path+"\\"+file.getOriginalFilename());
            file.transferTo(newfile);

            report.setReFile(file.getOriginalFilename());
        }
        reportService.addReport(report);

        return "redirect:selReportById.do";
    }

    //删除文案
    @RequestMapping("/delLeave")
    public String delLeave(String id){

        return "";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
