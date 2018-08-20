package org.java.mapper;

import org.java.entity.OaArticleReply;
import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

//资源管理
public interface OaResouMapper {

    public void oaResouAdd(Map<String,Object> m);

    public List<Map<String, Object>> oaReouAll();
}