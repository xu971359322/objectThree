package org.java.mapper;

import org.java.entity.OaArticleTopic;

public interface OaArticleTopicMapper {
    int deleteByPrimaryKey(Integer bbsTopicId);

    int insert(OaArticleTopic record);

    int insertSelective(OaArticleTopic record);

    OaArticleTopic selectByPrimaryKey(Integer bbsTopicId);

    int updateByPrimaryKeySelective(OaArticleTopic record);

    int updateByPrimaryKey(OaArticleTopic record);
}