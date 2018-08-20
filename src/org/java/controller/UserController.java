package org.java.controller;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamRole;
import org.java.entity.OaTeamWorker;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    @Qualifier("sysUserService")
    private SysUserService sysUserService;

    @RequestMapping("/loginInfo")
    public String loginInfo(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println(username+"========="+password);
        OaTeamWorker worker = sysUserService.loginInfo(username, password);
        if (worker != null) {
            session.setAttribute("worker", worker);
            System.out.println("22222222222222222222222222222222222222222");
            return "/main";
        } else {
            request.setAttribute("err", "密码错误！");
            return "/index";
        }
    }
    @RequestMapping("/demo")
    public String demo() {
        List<Map<String,Object>> one = sysUserService.one();
        for (Map<String,Object> map : one) {
            System.out.println(map+"===========================================================");
        }
        return "/main";
    }

//    @RequestMapping("/exit")
//    public String exit() throws Exception {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        session.removeAttribute("worker");
//        return "/index";
//    }
}