package org.java.service.impl;

import org.java.entity.OaArticleType;
import org.java.entity.OaFile;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaArticleMapper;
import org.java.mapper.OaArticleTypeXMapper;
import org.java.mapper.OaResouMapper;
import org.java.mapper.OaTeamWorkerMapper;
import org.java.service.ResouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class ResouServiceImpl implements ResouService {

    @Autowired
    private OaResouMapper oaResouMapper;

    @Autowired
    private OaTeamWorkerMapper oaTeamWorkerMapper;

    @Autowired
    private OaArticleTypeXMapper OaArticleTypeXMapper;

    @Autowired
    protected org.java.mapper.OaArticleMapper OaArticleMapper;

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

    @Override
    public void deleteFile(String fid) {
        oaResouMapper.deleteFile(fid);
    }

    @Override
    public OaFile selectFile(String fid) {
        return oaResouMapper.selectFile(fid);
    }

    @Override
    public List<OaFile> myWord(String userId) {
        List<OaFile> list = oaResouMapper.myWord(userId);
        return list;
    }
    @Override
    public void downFileCount(String fid){
        oaResouMapper.downFileCount(fid);
    }

    @Override
    public void cancelFile(String fid) {
        oaResouMapper.cancelFile(fid);
    }

    @Override
    public void cancelFile2(String fid) {
        oaResouMapper.cancelFile2(fid);
    }
    @Override
    public List<OaFile> dustbin(){
       return oaResouMapper.dustbin();
    }

    @Override
    public void dustbinRecover(String fid) {
        oaResouMapper.dustbinRecover(fid);
    }
    @Override
    public List<OaFile> selShowAll(String uid){
        return  oaResouMapper.selShowAll(uid);
    }



    /**
     *
     *
     * 论坛
     *
     *
     */
    @Override
    public List<Map<String,Object>> articleShowAll() {

        List<OaArticleType> list = OaArticleTypeXMapper.articleShowAll();

        List<Map<String,Object>> listM = new ArrayList<Map<String,Object>>();
        for (OaArticleType t:list){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",t.getBbsTypeId());
            map.put("typeName",t.getBbsTypeName());
            map.put("count",OaArticleMapper.articleShowAllCount(t.getBbsTypeId()).size());
            listM.add(map);
        }

        return listM;
    }




















}
