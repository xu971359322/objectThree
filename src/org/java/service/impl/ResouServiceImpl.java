package org.java.service.impl;

import org.java.entity.OaFile;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaResouMapper;
import org.java.mapper.OaTeamWorkerMapper;
import org.java.service.ResouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class ResouServiceImpl implements ResouService {

    @Autowired
    private OaResouMapper oaResouMapper;

    @Autowired
    private OaTeamWorkerMapper oaTeamWorkerMapper;


    @Override
    public List<OaTeamWorker> wordUserAll() {
        List<OaTeamWorker> list = oaTeamWorkerMapper.oaWorkerAll();
        return list;
    }

    @Override
    public void resouAdd(Map<String, Object> m) {
        oaResouMapper.oaResouAdd(m);
    }

    @Override
    public List<OaFile> oaReouAll() {
        List<OaFile> list = oaResouMapper.oaReouAll();
        return list;
    }


}
