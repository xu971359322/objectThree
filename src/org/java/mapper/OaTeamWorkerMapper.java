package org.java.mapper;

import org.java.entity.OaTeamWorker;

import java.util.List;

public interface OaTeamWorkerMapper {
    int deleteByPrimaryKey(String woId);

    int insert(OaTeamWorker record);

    int insertSelective(OaTeamWorker record);

    OaTeamWorker selectByPrimaryKey(String woId);

    int updateByPrimaryKeySelective(OaTeamWorker record);

    int updateByPrimaryKey(OaTeamWorker record);

    List<OaTeamWorker> oaWorkerAll();
}