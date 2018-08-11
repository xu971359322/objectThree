package org.java.mapper;

import org.java.entity.OaDocument;

public interface OaDocumentMapper {
    int deleteByPrimaryKey(Integer doId);

    int insert(OaDocument record);

    int insertSelective(OaDocument record);

    OaDocument selectByPrimaryKey(Integer doId);

    int updateByPrimaryKeySelective(OaDocument record);

    int updateByPrimaryKey(OaDocument record);
}