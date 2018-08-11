package org.java.mapper;

import org.java.entity.OaArticleType;

public interface OaArticleTypeMapper {
    int deleteByPrimaryKey(Integer bbsTypeId);

    int insert(OaArticleType record);

    int insertSelective(OaArticleType record);

    OaArticleType selectByPrimaryKey(Integer bbsTypeId);

    int updateByPrimaryKeySelective(OaArticleType record);

    int updateByPrimaryKey(OaArticleType record);
}