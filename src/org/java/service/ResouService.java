package org.java.service;

import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

public interface ResouService {

    public List<OaTeamWorker> wordUserAll();

    public void resouAdd(Map<String,Object> m);

    public List<Map<String,Object>> oaReouAll();
}