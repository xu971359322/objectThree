package org.java.service.impl;

import org.java.mapper.OaTeamEmailMapper;
import org.java.mapper.OaTeamEmailMapperCustom;
import org.java.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("emailService")
public class EmailServiceImpl implements EmailService {

    @Autowired
    private OaTeamEmailMapper oaTeamEmailMapper;

    @Autowired
    private OaTeamEmailMapperCustom oaTeamEmailMapperCustom;

    @Override
    public List<Map<String, Object>> groupEmail(String wid) {

        return oaTeamEmailMapperCustom.groupEmail(wid);
    }
}
