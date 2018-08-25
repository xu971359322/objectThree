package org.java.service.impl;

import org.java.entity.OaTeamRole;
import org.java.mapper.OaTeamRoleCustomMapper;
import org.java.mapper.OaTeamRoleMapper;
import org.java.service.RoleService;
import org.java.util.SimpleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private OaTeamRoleMapper oaTeamRoleMapper;

    @Autowired
    private OaTeamRoleCustomMapper oaTeamRoleCustomMapper;



    @Override
    public List<OaTeamRole> getSelectType() {
        return oaTeamRoleMapper.getSelectType();
    }

    @Override
    public void insert(Map<String, Object> map) {
        oaTeamRoleCustomMapper.insert(map);
    }

    @Override
    public List<List<Map<String,Object>>> getTeamRoleListBycondition() {
        String [] typeSystem={"personal","email","meeting","resource","company","check","system"};

        List<Map<String,Object>> personalList=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> emailList=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> meetingList=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> resourceList=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> companyList=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> checkList=new ArrayList<Map<String,Object>>();
        List<Map<String,Object>> systemList=new ArrayList<Map<String,Object>>();




        List<List<Map<String, Object>>> allList=new ArrayList<List<Map<String, Object>>>();
        List<Map<String, Object>> teamRoleListBycondition = oaTeamRoleCustomMapper.getTeamRoleListBycondition();
        for (Map<String, Object> map : teamRoleListBycondition) {
            String percode = (String) (map.get("percode")).toString().substring(0, 5);
            if (SimpleUtils.getSimilarityRatio(percode, typeSystem[0]) >= 0.6) {
                Map<String, Object> personal = new HashMap<String, Object>();
                personal.put("id", map.get("id"));
                personal.put("NAME", map.get("NAME"));
                personal.put("TYPE", map.get("TYPE"));
                personal.put("url", map.get("url"));
                personal.put("percode", map.get("percode"));
                personalList.add(personal);
            } else if (SimpleUtils.getSimilarityRatio(percode, typeSystem[1]) >= 0.6) {
                Map<String, Object> email = new HashMap<String, Object>();
                email.put("id", map.get("id"));
                email.put("NAME", map.get("NAME"));
                email.put("TYPE", map.get("TYPE"));
                email.put("url", map.get("url"));
                email.put("percode", map.get("percode"));
                emailList.add(email);
            } else if (SimpleUtils.getSimilarityRatio(percode, typeSystem[2]) >= 0.6) {
                Map<String, Object> meeting = new HashMap<String, Object>();
                meeting.put("id", map.get("id"));
                meeting.put("NAME", map.get("NAME"));
                meeting.put("TYPE", map.get("TYPE"));
                meeting.put("url", map.get("url"));
                meeting.put("percode", map.get("percode"));
                meetingList.add(meeting);
            } else if (SimpleUtils.getSimilarityRatio(percode, typeSystem[3]) >= 0.6) {
                Map<String, Object> resource = new HashMap<String, Object>();
                resource.put("id", map.get("id"));
                resource.put("NAME", map.get("NAME"));
                resource.put("TYPE", map.get("TYPE"));
                resource.put("url", map.get("url"));
                resource.put("percode", map.get("percode"));
                resourceList.add(resource);
            } else if (SimpleUtils.getSimilarityRatio(percode, typeSystem[4]) >= 0.6) {
                Map<String, Object> company = new HashMap<String, Object>();
                company.put("id", map.get("id"));
                company.put("NAME", map.get("NAME"));
                company.put("TYPE", map.get("TYPE"));
                company.put("url", map.get("url"));
                company.put("percode", map.get("percode"));
                companyList.add(company);
            } else if (SimpleUtils.getSimilarityRatio(percode, typeSystem[5]) >= 0.6) {
                Map<String, Object> check = new HashMap<String, Object>();
                check.put("id", map.get("id"));
                check.put("NAME", map.get("NAME"));
                check.put("TYPE", map.get("TYPE"));
                check.put("url", map.get("url"));
                check.put("percode", map.get("percode"));
                checkList.add(check);
            } else if (SimpleUtils.getSimilarityRatio(percode, typeSystem[6]) >= 0.6) {
                Map<String, Object> system = new HashMap<String, Object>();
                system.put("id", map.get("id"));
                system.put("NAME", map.get("NAME"));
                system.put("TYPE", map.get("TYPE"));
                system.put("url", map.get("url"));
                system.put("percode", map.get("percode"));
                systemList.add(system);
            }
        }

        allList.add(personalList);
        allList.add(emailList);
        allList.add(meetingList);
        allList.add(resourceList);
        allList.add(companyList);
        allList.add(checkList);
        allList.add(systemList);

        for (int i = 0; i < allList.size(); i++) {
            List<Map<String, Object>> mapList = allList.get(i);
            for (Map<String, Object> map : mapList) {
                System.out.println(map);
            }
            System.out.println("===========================================");
        }
        return allList;
    }

    @Override
    public void addPermission(Map<String, Object> per){
        oaTeamRoleCustomMapper.addPermission(per);
    }
}
