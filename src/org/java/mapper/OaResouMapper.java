package org.java.mapper;

import org.java.entity.OaArticleReply;
import org.java.entity.OaFile;
import org.java.entity.OaTeamWorker;

import java.util.Date;
import java.util.List;
import java.util.Map;

//资源管理
public interface OaResouMapper {

    public void oaResouAdd(Map<String,Object> m);

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



}