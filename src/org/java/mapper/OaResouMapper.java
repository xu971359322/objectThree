package org.java.mapper;

import org.java.entity.OaArticleReply;
import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

//资源管理
public interface ResouMapper {
    public List<OaTeamWorker> oaWorkerAll();

    public void resouAdd(Map<String,Object> m);
}