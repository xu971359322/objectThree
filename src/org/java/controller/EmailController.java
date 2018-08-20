package org.java.controller;

import org.java.entity.OaTeamEmail;
import org.java.entity.OaTeamWorker;
import org.java.service.EmailService;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/email")
public class EmailController extends BaseController{

    @Autowired
    private EmailService emailService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/dateilEmail")
    public String dateilEmail(String emId){
        OaTeamEmail email =emailService.selEmailById(emId);
        request.setAttribute("email",email);
        return "/xu/emailCom/newEmail";
    }

    @RequestMapping("/downFile.do")
    public void downFile(String fileName)throws Exception{
        System.out.println("下载");
        String fname = URLEncoder.encode(fileName, "utf-8");

        //显示下载窗口
        response.setContentType("application/x-msdownload");
        //指定下载面板显示哪些文件信息
        response.setHeader("Content-disposition","attachment;fileName="+fname);

        String path = servletContext.getRealPath("file");
        //创建一个输入流，用于把文件读入到内存
        InputStream in = new FileInputStream(path+fileName);

        //创建一个输出流，用于给请求做出响应-------------返回要下载的文件
        OutputStream out = response.getOutputStream();

        //创建一个字节数组，充当数据缓冲区
        byte[] b = new byte[8192];

        //定义变量，用于保存每一次实际读入到缓冲区的字节长度，如果已经读取到末尾没有内容，将会返回-1
        int len=0;

        while((len=in.read(b,0,8192))!=-1){
            out.write(b,0,len);
        }

        out.flush();
        out.close();
        in.close();
    }

    //查询部门员工
    @RequestMapping("/selPerson.do")
    @ResponseBody
    public List<OaTeamWorker> selPerson(@RequestBody Object[] dept){
        if(dept!=null){
            List<OaTeamWorker> list = sysUserService.userByDeptId(dept);
            System.out.println(list);
            return list;
        }
        return null;
    }

    //新建邮件
    @RequestMapping("/addEmail")
    public String addEmail(@RequestParam("title") String title,
                           @RequestParam("content") String content,
                           @RequestParam("people") String[] people,
                           @RequestParam("level")Integer level,
                           @RequestParam("sub")Integer sub,
            @RequestParam("file") CommonsMultipartFile file) throws  Exception{
        OaTeamWorker user = (OaTeamWorker)session.getAttribute("worker");
        OaTeamEmail e =new OaTeamEmail();
        String emId =UUID.randomUUID().toString();
        e.setEmId(emId);
        e.setEmTitle(title);
        e.setEmInfomation(content);
        e.setEmTime(new Date());
        e.setEmLevel(level);
        e.setEmFile(file.getOriginalFilename());
        e.setWoFid(user.getWoId());

        //有无上传文件
        if(file.getOriginalFilename()!=""){
            String path = servletContext.getRealPath("file");
            File newfile =new File(path+file.getOriginalFilename());

            file.transferTo(newfile);
        }
        //sub 1：发送  2：添加草稿箱
        if(sub==1){
            e.setEmStauts(1);
            emailService.sendEmail(people,emId);
        }else{
            e.setEmStauts(0);

        }
        System.out.println(e);
        emailService.addEmail(e);
        request.setAttribute("remind","发送成功");
        return "forward:groupEmail.do";
    }

    //修改邮件状态
    @RequestMapping("updateEmail")
    public String updateEmail(Integer status,String emId,Integer type){
        System.out.println("email:>>>"+status+" "+emId+"  "+type);
        emailService.updateEmail(status,emId);
        String back ="redirect:myEmail.do?status="+type;
        return back;
    }

    //查看我的email
    @RequestMapping("/myEmail")
    public String myEmail(Integer status){
        OaTeamWorker user = (OaTeamWorker)session.getAttribute("worker");
        List<OaTeamEmail> list = emailService.myEmail(user.getWoId(), status);
        request.setAttribute("list",list);
        return "/xu/emailCom/myEmail";
    }

    //查看邮件详情
    @RequestMapping("lookEmail")
    public String lookEmail(String emId,String seId){

        if(seId!=null){//修改邮件状态为已读
            emailService.updateSemailType(seId);
        }
        OaTeamEmail oaTeamEmail = emailService.lookEmail(emId);

        //找到发件人
        OaTeamWorker worker = sysUserService.selWorkerById(oaTeamEmail.getWoFid());

        request.setAttribute("email",oaTeamEmail);
        request.setAttribute("worker",worker);

        return "/xu/emailCom/detailEmail";
    }

    //收件箱
    @RequestMapping("/shouEmail")
    public String shouEmail(){
        OaTeamWorker user = (OaTeamWorker)session.getAttribute("worker");
        List<Map<String, Object>> list = emailService.shouEmail(user.getWoId());
        request.setAttribute("list",list);
        return "/xu/emailCom/email";
    }

    //查看新邮件
    @RequestMapping("/newEmail")
    public String newEmail(){
        OaTeamWorker user = (OaTeamWorker)session.getAttribute("worker");
        List<Map<String, Object>> list = emailService.newEmail(user.getWoId());
        request.setAttribute("list",list);
        return "/xu/emailCom/email";
    }

    //查看所有邮箱类型
    @RequestMapping("/groupEmail")
    public String groupEmail(){
        OaTeamWorker user = (OaTeamWorker)session.getAttribute("worker");
        List<Map<String, Object>> list = emailService.groupEmail(user.getWoId());
        System.out.println(list);
        request.setAttribute("shou",emailService.shouCount(user.getWoId()));
        request.setAttribute("list",list);
        return "/xu/comEmail";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
