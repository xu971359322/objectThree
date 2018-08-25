package org.java.controller;


import org.apache.commons.io.FileUtils;
import org.java.entity.OaArticleType;
import org.java.entity.OaFile;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaArticleTypeXMapper;
import org.java.service.ResouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

//资源管理Controller
@Controller
@RequestMapping("/resou")
public class ResouController extends BaseController {

    @Autowired
    private ResouService resouService;

    @Autowired
    private ServletContext cxt;


    @Autowired
    private OaArticleTypeXMapper  OaArticleTypeXMapper;

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
                         @RequestParam("hidUser") String hidUser,
                         @RequestParam("hidUser2") String hidUser2

                         ) throws Exception{
        OaTeamWorker user = (OaTeamWorker) session.getAttribute("worker");

        String [] array = hidUser.split(",");

        if (hidUser2.equals("1")&&array[0].equals("")) {
            System.out.println("判断1");
            m.put("wId", user.getWoId());
            m.put("f_name", File.getOriginalFilename());
            m.put("f_time", new Date());
            m.put("f_status", 0);
            m.put("sel_uid", user.getWoId());
            m.put("fLenth", File.getSize());
            m.put("down", 0);
            m.put("f_record", 0);
            resouService.resouAdd(m);
        }else if (hidUser2.equals("1")&&!array[0].equals("")) {
            System.out.println("判断2");
            for(int i = 0;i<array.length;i++){
                m.put("wId",user.getWoId());
                m.put("f_name",File.getOriginalFilename());
                m.put("f_time",new Date());
                m.put("f_status",0);
                m.put("sel_uid",array[i]);
                m.put("fLenth",File.getSize());
                m.put("down",0);
                m.put("f_record", 0);
                resouService.resouAdd(m);
            }
        }
        else{
            m.put("wId", user.getWoId());
            m.put("f_name", File.getOriginalFilename());
            m.put("f_time", new Date());
            m.put("f_status", 0);
            m.put("sel_uid", "");
            m.put("fLenth", File.getSize());
            m.put("down", 0);
            m.put("f_record", 0);
            resouService.resouAdd(m);
        }


        String path = cxt.getRealPath("file");

        String fname = File.getOriginalFilename();

        File newFile = new File(path,fname);

        File.getFileItem().write(newFile);

        return "redirect:resouAll.do";
    }

    //显示所有文件
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
            map.put("fileId",file.getfId());
            map.put("fname",file.getfName());
            map.put("type",file.getfType());
            map.put("lenth",fileLenth(file.getfLenth()));
            map.put("count",file.getFdownCount());
            map.put("ftime",file.getfTime());
            listM.add(map);
        }

        session.setAttribute("resouShowAllList",listM);
        return "/resource/fileShowAll";
    }

    //加入垃圾箱
    @RequestMapping("/deleteFile")
    public String  file(@RequestParam("fileId") String fileId){
        resouService.deleteFile(fileId);
        return "redirect:resouAll.do";
    }

    //文件下载
    @RequestMapping("/downFile")
    public ResponseEntity<byte[]> downFile(@RequestParam("fileId") String id) throws IOException{
            //获得文件路径
            String path = cxt.getRealPath("file");
            //根据编号查询对象
            OaFile item = resouService.selectFile(id);
            //拼出文件完整路径
            path = path+"/"+item.getfName();
            //获取文件
            File file=new File(path);
            HttpHeaders headers = new HttpHeaders();
            String fileName=new String(item.getfName().getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            //下载次数+1
            resouService.downFileCount(id);

            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
    }

    //我的文档
    @RequestMapping("/myWord")
    public String myWord(){
        OaTeamWorker user2 = (OaTeamWorker) session.getAttribute("worker");
        List<OaFile> list = resouService.myWord(user2.getWoId());

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
            map.put("fileId",file.getfId());
            map.put("fname",file.getfName());
            map.put("type",file.getfType());
            map.put("lenth",fileLenth(file.getfLenth()));
            map.put("count",file.getFdownCount());
            map.put("record",file.getF_record());
            map.put("ftime",file.getfTime());
            listM.add(map);
        }

        request.setAttribute("myWordList",listM);
        return "/resource/myWordAll";
    }

    @RequestMapping("/cancelFile")
    public String cancelFile(@RequestParam("fileId") String fileId){
        resouService.cancelFile(fileId);
        return "redirect:myWord.do";
    }

    @RequestMapping("/cancelFile2")
    public String cancelFile2(@RequestParam("fileId") String fileId){
        resouService.cancelFile2(fileId);
        return "redirect:myWord.do";
    }

    @RequestMapping("/dustbin")
    public String dustbin(){

        List<OaFile> list = resouService.dustbin();
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
            map.put("fileId",file.getfId());
            map.put("fname",file.getfName());
            map.put("type",file.getF_dustbin());
            map.put("lenth",fileLenth(file.getfLenth()));
            map.put("count",file.getFdownCount());
            map.put("ftime",file.getfTime());
            listM.add(map);
        }
        request.setAttribute("dustbinListAll",listM);
        return "/resource/fileDustbin";
    }

    @RequestMapping("/dustbinRecover")
    public String dustbinRecover(@RequestParam("fileId") String fileId){

        resouService.dustbinRecover(fileId);
        return "redirect:dustbin.do";
    }

    @RequestMapping("/selShowAll")
    public String selShowAll(){
        OaTeamWorker user2 = (OaTeamWorker) session.getAttribute("worker");
        List<OaFile> list = resouService.selShowAll(user2.getWoId());
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
            map.put("fileId",file.getfId());
            map.put("fname",file.getfName());
            map.put("type",file.getfType());
            map.put("lenth",fileLenth(file.getfLenth()));
            map.put("count",file.getFdownCount());
            map.put("ftime",file.getfTime());
            listM.add(map);
        }

        session.setAttribute("resouSelList",listM);

        return "/resource/fileSelAll";
    }

    public String fileLenth(Integer lenth){
        if(lenth>(1024*1024*1024)){
            return lenth/(1024*1024*1024)+"G";
        }else if(lenth>(1024*1024)){
            return lenth/(1024*1024)+"M";
        }else if(lenth>1024){
            return lenth/1024+"KB";
        }else{
            return lenth/1024+"B";
        }

    }




    /*
    *
    *
    *
    * 论坛
    *
    *
    * */

    @RequestMapping("/artile")
    public String artileShowAll(){
        List<Map<String,Object>> listType = resouService.articleShowAll();
        System.out.println("进入");
        request.setAttribute("articleList",listType);
        return "/resource/artileShow";
    }











}
