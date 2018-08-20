package org.java.controller;

import org.activiti.engine.impl.bpmn.helper.ScopeUtil;
import org.java.util.EmailList;
import org.java.util.MailTest;
/*import org.java.util.SendEmailUtil;*/
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/qq")
public class QQEmailController extends BaseController{

    @Autowired
    private MailTest mailTest;

    @RequestMapping("/detailEmail")
    public String detailEmail(String id){
        List<Map<String, Object>> list = EmailList.getEmailList().getList();
        String content="";
        for (Map<String, Object> one : list) {
            if(one.get("id").toString().equals(id)){
                content =one.get("content").toString();
                break;
            }
        }
        System.out.println(content);
        request.setAttribute("content",content);
        return "/xu/qqEmail/detail";
    }


    @RequestMapping("lookQQEmail")
    public String lookQQEmail()throws Exception{
        List<Map<String, Object>> list = EmailList.getEmailList().getList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for(int i =0;i<list.size()-1;i++){
            for(int j=0;j<list.size()-i-1;j++){
                Date one =format.parse(list.get(j).get("time").toString());
                Date two =format.parse(list.get(j+1).get("time").toString());
                if(one.getTime()<two.getTime()){
                    Map<String,Object> empty =list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,empty);
                }
            }
        }
        request.setAttribute("list",list);
        System.out.println(list.size());
        return "/xu/qqEmail/qqEmail";
    }

    //加载我的QQ邮箱
    @RequestMapping("/load")
    public String load(){
        EmailList.getEmailList().setList(new ArrayList<Map<String,Object>>());
        mailTest.selectEmail();
        return "/xu/qqEmail";
    }

    //发送邮件
    @RequestMapping("addEmail")
    public String addEmail(String[] people ,String title,String content,String email){
        String[] arr =new String[people.length+1];

        if(people.length>0){
            arr=people;
        }
        if(email !=null && !email.equals("")){
            arr[people.length] =email;
        }

        System.out.println(title+"  "+content);
        for (String s : people) {
            System.out.println("people:"+s);
        }
        for (String s : arr) {
            System.out.println("arr:"+s);
        }
        //SendEmailUtil.sendSimpleMail(arr,content,title);
        request.setAttribute("err","发送成功");
        return "/xu/qqEmail";
    }

    @Test
    public void show() throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date one =format.parse("2017-5-5");
        Date two =format.parse("2017-5-6");
        if(one.getTime()<two.getTime()){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
