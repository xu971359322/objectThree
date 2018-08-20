package org.java.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private RepositoryService repositoryService;// 部署流程服务

    @Autowired
    private RuntimeService runtimeService;// 运行时服务

    @Autowired
    private TaskService taskService;

    //部署流程定义
    @RequestMapping("/deployed")
    public String deployed(@RequestParam("name")String name,
                           @RequestParam("file") CommonsMultipartFile file) throws Exception{

        InputStream inputStream = file.getInputStream();
        ZipInputStream zipInputStream =new ZipInputStream(inputStream);
        repositoryService.createDeployment()
                .name(name)
                .addZipInputStream(zipInputStream)
                .deploy();
        System.out.println("部署成功");

        return "redirect:queryProcessDefinition.do";
    }

    /**
     * 查看流程定义
     *
     * @return
     */
    @RequestMapping("/queryProcessDefinition.do")
    public String queryProcessDefinition(Model model,String processKey) {

        // 创建流程定义的查询对象
        ProcessDefinitionQuery query = repositoryService
                .createProcessDefinitionQuery();

        // 设置要查询的流程定义的key--------------实际就是bpmn文件的id名称
        query.processDefinitionKey(processKey);

        // 查询所有的流程定义
        List<ProcessDefinition> list = query.list();

        model.addAttribute("list", list);

        return "/flow/showProcessDefinition";
    }

    //查看流程图或者bpmn文件
    @RequestMapping("/showResources")
    public void showResources(String processDefinitionId, String type,HttpServletResponse res)throws Exception{


        ProcessDefinitionQuery query = repositoryService
                .createProcessDefinitionQuery();

        // 根据流程定义 的id,查询出某一个具体的流程定义
        ProcessDefinition pd = query.processDefinitionId(processDefinitionId)
                .singleResult();

        // 根据流程定义,获得该流程的部署ID
        String deploymentId = pd.getDeploymentId();

        // 根据type类型，从流程定义中获得资源的名称: xxx.bpmn或者 xxx.png
        String resourceName = "";
        if (type.equals("bpmn")) {
            resourceName = pd.getResourceName();// 得到bpmn文件名称
        } else {
            resourceName = pd.getDiagramResourceName();// png的文件名
        }
        // 通过repositoryService，根据部署id,以及资源的名称，查询出指定的资源，把信息读入到输入 流中
        InputStream in = repositoryService.getResourceAsStream(deploymentId,
                resourceName);

        // 把输入流的内容，输出显示到客户端浏览器
        byte[] b = new byte[8192];// 缓冲区
        int len = 0;// 保存实际写入缓冲区的数据长度
        while ((len = in.read(b, 0, 8192)) != -1) {
            res.getOutputStream().write(b, 0, len);// 把数据输出到客户端
        }
        in.close();
    }

    //查看进行流程图
    @RequestMapping("/queryActiveMap")
    public String queryActiveMap(String taskId, Model model) {

        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();

        String processInstanceId = task.getProcessInstanceId();
        // 根据流程实例id,查询出它对应的流程实例
        ProcessInstanceQuery query = runtimeService
                .createProcessInstanceQuery();
        // 得到流程实例
        ProcessInstance instance = query.processInstanceId(processInstanceId)
                .singleResult();

        // 根据流程实例，得到流程定义ID--------processDefinitionId
        String processDefinitionId = instance.getProcessDefinitionId();

        // 把processDefinitionId存放在Model中
        model.addAttribute("processDefinitionId", processDefinitionId);

        // 通过repositoryServicet根据processDefinitionId得到流程定义实体processDefinitionEntity(当前流程图在内存中的结构)
        ProcessDefinitionEntity entity = (ProcessDefinitionEntity) repositoryService
                .getProcessDefinition(processDefinitionId);

        // 获得当前流程实例执行的任务阶段在内存中的结构--ActivityImpl
        String activityId = instance.getActivityId();// 获得当前执行任务id

        // 从当前流程图在内存中的结构processDefinitionEntity，根据activityId取得当前指任务在 内存中的结构
        ActivityImpl act = entity.findActivity(activityId);

        // 取得当前任务阶段对应的图的坐标:x,y,width,height
        int x = act.getX();
        int y = act.getY();
        int width = act.getWidth();
        int height = act.getHeight();

        //把这四个值，存在model中，用于显示红色的边框
        model.addAttribute("x",x);
        model.addAttribute("y",y);
        model.addAttribute("width",width);
        model.addAttribute("height",height);

        System.out.println(x+"   "+y+"   "+width+"  "+height);

        return "/flow/showActiveMap";//到页面显示流程图
    }

    //删除流程定义
    @RequestMapping("/delProcessDefinition")
    public String delProcessDefinition(String id){
        System.out.println("del");

        repositoryService.deleteDeployment(id, true);

        return "redirect:queryProcessDefinition";

    }

}
