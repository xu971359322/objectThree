package org.java.controller;

import org.java.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/email")
public class EmailController extends BaseController{

    @Autowired
    private EmailService emailService;


    @RequestMapping("/groupEmail")
    public String groupEmail(){
        System.out.println("进入到了controller");
        Map<String,Object> user =(Map<String,Object>)session.getAttribute("worker");
        List<Map<String, Object>> list = emailService.groupEmail(user.get("wo_id").toString());
        request.setAttribute("list",list);
        return "xu/comEmail";
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
