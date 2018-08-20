package org.java.service.impl;

import org.java.entity.OaTeamEmail;
import org.java.entity.OaTeamSemail;
import org.java.mapper.OaTeamEmailMapper;
import org.java.mapper.OaTeamEmailMapperCustom;
import org.java.mapper.OaTeamSemailMapper;
import org.java.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private OaTeamEmailMapper oaTeamEmailMapper;

    @Autowired
    private OaTeamEmailMapperCustom oaTeamEmailMapperCustom;

    @Autowired
    private OaTeamSemailMapper oaTeamSemailMapper;

    @Override
    public OaTeamEmail selEmailById(String emId) {
        return oaTeamEmailMapper.selectByPrimaryKey(emId);
    }

    @Override
    public void sendEmail(Object[] people,String emId) {
        for (Object person : people) {
            OaTeamSemail semail =new OaTeamSemail();
            semail.setSeTime(new Date());
            semail.setWoId(person.toString());
            semail.setSeStatus(0);
            semail.setEmId(emId);
            oaTeamSemailMapper.insertSelective(semail);
        }
    }

    @Override
    public void addEmail(OaTeamEmail oaTeamEmail) {
        oaTeamEmailMapper.insertSelective(oaTeamEmail);
    }

    @Override
    public void updateEmail(Integer status, String emId) {
        OaTeamEmail oaTeamEmail = new OaTeamEmail();
        oaTeamEmail.setEmId(emId);
        oaTeamEmail.setEmStauts(status);
        oaTeamEmailMapper.updateByPrimaryKeySelective(oaTeamEmail);
    }

    @Override
    public List<OaTeamEmail> myEmail( String wid,Integer status) {
        System.out.println(wid+"    "+status);
        return oaTeamEmailMapperCustom.myEmail(wid,status);
    }

    @Override
    public List<Map<String, Object>> shouEmail(String wid) {

        return oaTeamEmailMapperCustom.shouEmail(wid);
    }

    @Override
    public void updateSemailType(String seId) {
        OaTeamSemail oaTeamSemail =new OaTeamSemail();
        oaTeamSemail.setSeId(Integer.parseInt(seId));
        oaTeamSemail.setSeStatus(1);
        oaTeamSemailMapper.updateByPrimaryKeySelective(oaTeamSemail);
    }

    @Override
    public int shouCount(String wid) {
        return oaTeamEmailMapperCustom.shouCount(wid);
    }

    @Override
    public OaTeamEmail lookEmail(String emId) {
        return oaTeamEmailMapperCustom.lookEmail(emId);
    }

    @Override
    public List<Map<String, Object>> newEmail(String wid) {
        return oaTeamEmailMapperCustom.newEmail(wid);
    }

    @Override
    public List<Map<String, Object>> groupEmail(String wid) {
        return oaTeamEmailMapperCustom.groupEmail(wid);
    }
}
