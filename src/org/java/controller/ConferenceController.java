package org.java.controller;

import org.java.service.impl.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;


@RequestMapping("/zw")
@Controller
public class ConferenceController extends  BaseController {














    //发邮件-----------------------------------------------------


    public static void sendMail(String email, String emailMsg,String content) throws Exception {

        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）

        // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,

        //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。

        String myEmailAccount = "2991722289@qq.com";

        String myEmailPassword = "ttjzxyackvumddce";



        // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
        //   smtp.qq.com
        // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com

        String myEmailSMTPHost = "smtp.qq.com";



        // 收件人邮箱（替换为自己知道的有效邮箱）

        String receiveMailAccount = email;

        // 1. 创建参数配置, 用于连接邮件服务器的参数配置

        Properties props = new Properties();                    // 参数配置

        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）

        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址

        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证



        // 2. 根据配置创建会话对象, 用于和邮件服务器交互

        Session session = Session.getDefaultInstance(props);

        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log



        // 3. 创建一封邮件

        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount,content);



        // 4. 根据 Session 获取邮件传输对象

        Transport transport = session.getTransport();



        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错

        //

        //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,

        //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误

        //           类型到对应邮件服务器的帮助网站上查看具体失败原因。

        //

        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:

        //           (1) 邮箱没有开启 SMTP 服务;

        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;

        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;

        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;

        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。

        //

        //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。

        transport.connect(myEmailAccount, myEmailPassword);



        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人

        transport.sendMessage(message, message.getAllRecipients());



        // 7. 关闭连接

        transport.close();

    }

    /**

     * 创建一封只包含文本的简单邮件

     *

     * @param session 和服务器交互的会话

     * @param sendMail 发件人邮箱

     * @param receiveMail 收件人邮箱

     * @return

     * @throws Exception

     */

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String content) throws Exception {

        // 1. 创建一封邮件

        MimeMessage message = new MimeMessage(session);



        // 2. From: 发件人

        message.setFrom(new InternetAddress(sendMail, "大连驰敖", "UTF-8"));



        // 3. To: 收件人（可以增加多个收件人、抄送、密送）

        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));



        // 4. Subject: 邮件主题

        message.setSubject("大连驰敖开会提醒", "UTF-8");



        // 5. Content: 邮件正文（可以使用html标签）

        message.setContent(  content, "text/html;charset=UTF-8");



        // 6. 设置发件时间

        message.setSentDate(new Date());



        // 7. 保存设置

        message.saveChanges();



        return message;

    }

    //---------------------------------------------------

    //-------------------------------会议室
    //    添加单个会议室 跳转所有会议室界面
    @RequestMapping("/addonemeetingroom")
    public  String  addonemeetingroom(){
        Integer people=Integer.parseInt(request.getParameter("people"));
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String facility=request.getParameter("facility");
        String place=request.getParameter("place");
        Map<String,Object> m=new HashMap<String, Object>();
        m.put("people",people);
        m.put("title",title);
        m.put("content",content);
        m.put("facility",facility);
        m.put("place",place);
        meetingService.addonemeetingroom(m);
        showallmeeting();
        return "/zwz/showallmeeting";
    }

     //    修改单个会议室 跳转修改会议室界面
    @RequestMapping("/updateonemettingroom")
    public  String  updateonemettingroom(){
        Integer id=Integer.parseInt(request.getParameter("id"));
        Integer people=Integer.parseInt(request.getParameter("people"));
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String facility=request.getParameter("facility");
        String place=request.getParameter("place");
        Map<String,Object> m=new HashMap<String, Object>();
        m.put("id",id);
        m.put("people",people);
        m.put("title",title);
        m.put("content",content);
        m.put("facility",facility);
        m.put("place",place);
        meetingService.updateonemettingroom(m);
        showallmeeting();
        return "/zwz/showallmeeting";
    }

    //    查询单个会议室 跳转修改会议室界面
    @RequestMapping("/showonemeetingroom")
    public  String  showonemeetingroom(){
        Integer id= Integer.parseInt(request.getParameter("id"));
        List<Map<String,Object>> list= meetingService.showonemeetingroom(id);
        session.setAttribute("nemeetingroom",list);
        return "/zwz/showonemeetingroom";
    }

    //    查询所有会议室 跳转会议室界面
    @RequestMapping("/showallmeeting")
    public  String  showallmeeting(){
        List<Map<String,Object>> list= meetingService.seleallmeetingroom();
        session.setAttribute("allmeetingroomlist",list);
        return "/zwz/showallmeeting";
    }

    //-----------------------------会议
//    删除未批准的会议
    @RequestMapping("/deletemetting")
    public  String  deletemetting(){
        Integer id=Integer.parseInt(request.getParameter("id"));
        meetingService.deletemetting(id);
        showfinishmeeting();
        return "/zwz/finishmeeting";
    }

    //    显示所有未批准会议
    @RequestMapping("/showfinishmeeting")
    public  String  showfinishmeeting(){
        List<Map<String,Object>> list= meetingService.noratify();
        session.setAttribute("noratifylist",list);
        return "/zwz/finishmeeting";
    }

    //    通知人 来开会 发短信
    @RequestMapping("/informman")
    public  String  informman(){
        String yx=request.getParameter("mailbox");
        String dx=request.getParameter("message");

        Integer iid=Integer.parseInt(request.getParameter("iid"));
        Integer id= Integer.parseInt(request.getParameter("id"));

        List<Map<String,Object>> list= meetingService.selephone(id);
        List<Map<String,Object>> list2= meetingService.selemeeting(id);
        Map<String,Object>  m=list2.get(0);

        int w1=0;
        int w2=0;
//        邮箱
        if(yx!=null){
            w1=1;
            String sj1=m.get("begintime").toString();
            String sj2=m.get("endtime").toString();
            String smsText = "请于："+sj1.substring(0,sj1.length()-5)+"，到["+m.get("place")+m.get("mptitle")+"]参加："+m.get("title")+"会议。"+"结束时间"+sj2.substring(0,sj2.length()-5);


            List<String> email=new ArrayList<String>();
            for (int i=0;i<list.size();i++){
                email.add(list.get(i).get("email").toString());
            }

            try {

                for (String z : email) {
                    sendMail(z, "ww",smsText);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //发短信-------------------------------------------------------
        if(dx!=null){
            w2=1;
            //用户名
            String Uid = "zwz111";

            //接口安全秘钥
            String Key = "d41d8cd98f00b204e981";

            //手机号码，多个号码如13800000000,13800000001,13800000002
            String smsMob = "";

            for (int i=0;i<list.size();i++){
                if(list.size()-1>i){
                    smsMob+=list.get(i).get("phone")+",";
                }else{
                    smsMob+=list.get(i).get("phone");
                }

            }
            String sj1=m.get("begintime").toString();
            String sj2=m.get("endtime").toString();
            String smsText = "请于："+sj1.substring(0,sj1.length()-5)+"，到["+m.get("place")+m.get("mptitle")+"]参加："+m.get("title")+"会议。"+"结束时间"+sj2.substring(0,sj2.length()-5);

            //--------------------------------------------------------------------------以下是发短信

            HttpClientUtil client = HttpClientUtil.getInstance();

            //UTF发送
            int result = client.sendMsgUtf8(Uid,Key,smsText,smsMob);
            if(result>0){
                System.out.println("UTF8成功发送条数=="+result);
            }else{
                System.out.println(client.getErrorMsg(result));
            }
        }

        Map<String,Object> mmw=new HashMap<String,Object>();
        mmw.put("iid",iid);
        mmw.put("email",w1);
        mmw.put("phone",w2);

        meetingService.updateinform(mmw);



        seleratifymeeting();

        return "/zwz/ratifymeeting";
    }

    //    显示单个已批准会议 ---跳转通知单个会议
       @RequestMapping("/informmeeting")
    public  String  informmeeting(){
           Integer id= Integer.parseInt(request.getParameter("id"));
           List<Map<String,Object>> list= meetingService.selemeeting(id);
           System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwww");
           System.out.println(list.size());
           session.setAttribute("list",list);
        return "/zwz/informmeeting";
    }

    //    显示所有已批准会议
    @RequestMapping("/seleratifymeeting")
    public  String  seleratifymeeting(){
        List<Map<String,Object>> list= meetingService.seleratifymeeting();
        session.setAttribute("ratifylist",list);
        return "/zwz/ratifymeeting";
    }

    //处理会议 如果同意就向通知表添加一条数据
    @RequestMapping("updatemetting")
    public  String updatemetting(String ratify,String suggest,String id){
        Map<String,Object> m=new HashMap<String, Object>();
        m.put("id",id);
        m.put("typee",ratify);
        m.put("comment",suggest);
        if(ratify.equals("1")){
            meetingService.addinform(Integer.parseInt(id));
        }
    meetingService.updatemeeting(m);
        showapproval();
        return "/zwz/showapproval";
    }

    //    显示单个待批准会议
    @RequestMapping("/showmeeting")
    public  void showmeeting(){
      Integer id= Integer.parseInt(request.getParameter("id"));
        List<Map<String,Object>> list= meetingService.selemeeting22(id);
        session.setAttribute("list",list);
    }

//    显示所有待批准会议‘
    @RequestMapping("/showapproval")
    public  String showapproval(){
        List<Map<String,Object>> list= meetingService.seleapproval();
        session.setAttribute("awaitratify",list);
        return "/zwz/showapproval";
    }




}
