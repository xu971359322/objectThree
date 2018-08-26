package org.java.service;

import org.java.entity.OaArticleType;
import org.java.entity.OaFile;
import org.java.entity.OaTeamWorker;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ResouService {

    public List<OaTeamWorker> wordUserAll();

    public void resouAdd(Map<String,Object> m);

    public List<OaFile> oaReouAll();

    public void deleteFile(String fid);

    public OaFile selectFile(String fid);

    public List<OaFile> myWord(String userId);

    public void downFileCount(String fid);

    public void cancelFile(String fid);

    public void cancelFile2(String fid);

    public List<OaFile> dustbin();

    public void dustbinRecover(String fid);

    public List<OaFile> selShowAll(String uid);

    /**
     *
     *
     * 论坛
     *
     *
     */


    public List<Map<String,Object>> articleShowAll();

    public List<Map<String,Object>> postType(String tid);










}
