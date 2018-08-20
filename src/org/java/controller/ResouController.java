package org.java.controller;

import org.activiti.spring.annotations.UserId;
import org.java.entity.OaFile;
import org.java.entity.OaTeamWorker;
import org.java.service.ResouService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.*;

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
        OaTeamWorker user = (OaTeamWorker) session.getAttribute("worker");
        session.setAttribute("resouUser",user);
        session.setAttribute("resouUserList",list);
        return "/resource/docUp";
    }

    //文件上传
    @RequestMapping("/FileUp")
    public String FileUp(@RequestParam Map<String,Object> m,
                         @RequestParam("fName") CommonsMultipartFile File,
                         @RequestParam("user") String [] array ) throws Exception{
        OaTeamWorker user = (OaTeamWorker) session.getAttribute("worker");

        System.out.println(array.length);

        if (m==null){
            m.put("wId",user.getWoId());
            m.put("f_name",File.getOriginalFilename());
            m.put("f_time",new Date());
            m.put("f_status",0);
            m.put("sel_uid",user.getWoId());
            m.put("fLenth",File.getSize());
            m.put("down",0);
            resouService.resouAdd(m);
        }else{
            for(int i = 0;i<array.length;i++){
                m.put("wId",user.getWoId());
                m.put("f_name",File.getOriginalFilename());
                m.put("f_time",new Date());
                m.put("f_status",0);
                m.put("sel_uid",array[i]);
                m.put("fLenth",File.getSize());
                m.put("down",0);
                resouService.resouAdd(m);
            }
        }


        String path = cxt.getRealPath("file");

        String fname = File.getOriginalFilename();

        File newFile = new File(path,fname);

        File.getFileItem().write(newFile);

        return "redirect:resouAll.do";
    }

    @RequestMapping("/resouAll")
    public String resouAll(){
        List<OaFile> list = resouService.oaReouAll();
        List<OaTeamWorker> listUser = resouService.wordUserAll();
        List<Map<String,Object>> listM = new ArrayList<Map<String,Object>>();
        for (int i = 0;i<list.size();i++){
            Map<String,Object> map = new HashMap<String, Object>();
            OaFile file = list.get(i);
            for (OaTeamWorker user :listUser){
                if(file.getWoId().equals(user.getWoId())){
                    String  name = user.getWoName();
                    map.put("woname",name);
                }
            }
            map.put("fid",i);
            map.put("fname",file.getfName());
            map.put("type",file.getfType());
            if(file.getfLenth()>(1024*1024*1024)){
                map.put("lenth",file.getfLenth()/(1024*1024*1024)+"G");
            }else if(file.getfLenth()>(1024*1024)){
                map.put("lenth",file.getfLenth()/(1024*1024)+"M");
            }else if(file.getfLenth()>1024){
                map.put("lenth".toString(),file.getfLenth()/1024+"KB");
            }else if(file.getfLenth()<1024){
                map.put("lenth",file.getfLenth()/1024+"B");
            }
            map.put("count",file.getFdownCount());
            map.put("ftime",file.getfTime());
            listM.add(map);
        }

        session.setAttribute("resouShowAllList",listM);
        return "/resource/FileShowAll";
    }

}
