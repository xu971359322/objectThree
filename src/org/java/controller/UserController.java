package org.java.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    @Qualifier("sysUserService")
    private SysUserService sysUserService;

    @RequestMapping("/load")
    public String first(){

        //得到主体
        Subject subject = SecurityUtils.getSubject();

        //从主体中，得到认证成功时，存放的"用户凭证"
        Map<String,Object> user =(Map<String, Object>) subject.getPrincipal();

        //存放用户信息
        session.setAttribute("worker",user);

     /*   //存放菜单
        List<Map<String,Object>> menus = (List<Map<String, Object>>) user.get("menus");
        System.out.println(menus.size()+">>>>>>>>>>>");
        model.addAttribute("menus",menus);*/
        System.out.println("1111111111111111111111122222222222222222222222222222222222333333333333333333333333333333333");
        return "/main";
    }


    @RequestMapping("/loginInfo")
    public String loginInfo() throws Exception {
        System.out.println("======================================loginController===============================================");

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
}