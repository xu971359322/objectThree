package org.java.controller;

import org.java.entity.OaTeamRole;
import org.java.service.RoleService;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController extends BaseController{
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/getWorkerList")
    public String getWorkerList(Model model){
        List<Map<String, Object>> workerList = sysUserService.getWorkerList();
        model.addAttribute("workerList",workerList);
        return "/pjsp/assignManger";
    }

    @RequestMapping("/addRole")
    public String addRole(Model model, @RequestParam Map<String,Object> m,@RequestParam Map<String,Object> per) {
        Map map = request.getParameterMap();
        String[] items = (String[])map.get("permission");
        System.out.println("==========================");
        for (String item : items) {
            System.out.println(item+" , ");
        }
        System.out.println("==========================");
        m.put("roleAvailable", 1);
        roleService.insert(m);

        for (String item : items) {
            per.put("ro_id",m.get("ro_id"));
            per.put("permission_id",item);
            roleService.addPermission(per);
        }

        List<OaTeamRole> roleList = (List<OaTeamRole>) session.getAttribute("roleList");
        roleList = roleService.getSelectType();
        session.setAttribute("roleList", roleList);
        return "/pjsp/roleManger";
    }

    @RequestMapping("/delRoleInfo/{roId}")
    public String delRoleInfo(Model model,@PathVariable("roId") Integer roId){
        List<OaTeamRole> roleList = (List<OaTeamRole>) session.getAttribute("roleList");
        roleList = roleService.getSelectType();
        session.setAttribute("roleList", roleList);
        return "/pjsp/roleManger";
    }

    @RequestMapping("/getTeamRoleListBycondition")
    public String getTeamRoleListBycondition(Model model){
        String [] typeSystem={"personal","email","meeting","resource","company","check","system"};
        List<List<Map<String,Object>>> teamRoleListBycondition = roleService.getTeamRoleListBycondition();
        model.addAttribute("teamRoleListBycondition",teamRoleListBycondition);
        return "/pjsp/addRoleInfo";
    }
}
