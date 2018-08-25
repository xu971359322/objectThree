package org.java.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.java.entity.OaMeetingCustom;
import org.java.entity.OaMettingplace;
import org.java.entity.OaTeamEmail;
import org.java.entity.OaTeamRole;
import org.java.service.RoleService;
import org.java.service.SysCalendarService;
import org.java.service.SysUserService;
import org.java.service.UtilService;
import org.java.shiro.CustomRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    @Qualifier("sysUserService")
    private SysUserService sysUserService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @Autowired
    @Qualifier("utilService")
    private UtilService utilService;

    @Autowired
    @Qualifier("sysCalendarService")
    private SysCalendarService sysCalendarService;

    @RequestMapping("/load")
    public String first(Model model){

        Subject subject = SecurityUtils.getSubject();//得到主体

        Map<String,Object> user =(Map<String, Object>) subject.getPrincipal();//从主体中，得到认证成功时，存放的"用户凭证"

        session.setAttribute("worker",user);//存放用户信息

        List<Map<String, Object>> personList = sysCalendarService.getDetpPersonList();
        session.setAttribute("personList",personList);
        List<OaMettingplace> placeAll = sysCalendarService.getPlaceAll();
        session.setAttribute("placeAll",placeAll);


        List<Map<String,Object>> menus = (List<Map<String, Object>>) user.get("menus");//存放菜单
        System.out.println(menus.size()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.>>>>>");
        model.addAttribute("menus",menus);

        return "/main";
    }


    @RequestMapping("/getMainInfo")
    public String getMainInfo(){
        List<Map<String,Object>> meetingAll = utilService.getMeetingAll();
        request.setAttribute("meetingAll",meetingAll);
        List<OaTeamEmail> emailAll = utilService.getEmailAll();
        request.setAttribute("emailAll",emailAll);
        return "/pjsp/programme";
    }

    @RequestMapping("/loginInfo")
    public String loginInfo() throws Exception {

        List<OaTeamRole> roleList = roleService.getSelectType();
        session.setAttribute("roleList",roleList);

        //取消息内容，用于判断是因为没有登录进入的，还是登录失败进入的
        String msg = (String) request.getAttribute("shiroLoginFailure");
        if (msg != null) {
            if (msg.equals("org.apache.shiro.authc.UnknownAccountException")) {
                throw new Exception("用户名不存在");
            } else if (msg.equals("org.apache.shiro.authc.IncorrectCredentialsException")) {
                throw new Exception("密码错误");
            } else {
                System.out.println(msg);
                throw new Exception("产生了其他的异常");
            }
        }
        return "/index";
    }

    @RequestMapping("/exit")
    public String exit() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute("worker");
        List<OaTeamRole> roleList = roleService.getSelectType();
        session.setAttribute("roleList",roleList);
        return "/index";
    }
}