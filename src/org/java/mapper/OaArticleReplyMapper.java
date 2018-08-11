package org.java.mapper;

import org.java.entity.OaArticleReply;

public interface OaArticleReplyMapper {
    int deleteByPrimaryKey(Integer bbsReplyId);

    int insert(OaArticleReply record);

    int insertSelective(OaArticleReply record);

    OaArticleReply selectByPrimaryKey(Integer bbsReplyId);

    int updateByPrimaryKeySelective(OaArticleReply record);

    int updateByPrimaryKey(OaArticleReply record);
}