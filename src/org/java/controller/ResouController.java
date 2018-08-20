package org.java.controller;

import org.activiti.spring.annotations.UserId;
import org.java.entity.OaTeamWorker;
import org.java.service.ResouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

//资源管理Controller
@Controller
@RequestMapping("/resou")
public class ResouController extends BaseController {

    @Autowired
    private ResouService resouService;

    @Autowired
    private ServletContext cxt;

    /**
     * 加载私密分享人
     * @return
     */
    @RequestMapping("/Load")
    public String load(){
        List<OaTeamWorker> list = resouService.wordUserAll();
        session.setAttribute("resouUserList",list);
        return "/resource/docUp";
    }

    //文件上传
    @RequestMapping("/FileUp")
    public String FileUp(@RequestParam Map<String,Object> m,
                         @RequestParam("fName") CommonsMultipartFile File,
                         @RequestParam("user") String [] array ) throws Exception{
        OaTeamWorker user = (OaTeamWorker) session.getAttribute("worker");

        for(int i = 0;i<array.length;i++){
            m.put("wId",user.getWoId());
            m.put("f_name",File.getOriginalFilename());
            m.put("f_time",new Date());
            m.put("f_status",0);
            m.put("sel_uid",array[i]);
            resouService.resouAdd(m);
        }



        String path = cxt.getRealPath("file");

        String fname = File.getOriginalFilename();

        File newFile = new File(path,fname);

        File.getFileItem().write(newFile);

        return "/resouAll.do";
    }

    @RequestMapping("/resouAll")
    public String resouAll(){
        List<Map<String,Object>> list = resouService.oaReouAll();
        System.out.println(list.size());
        return "/resouAll";
    }

}
