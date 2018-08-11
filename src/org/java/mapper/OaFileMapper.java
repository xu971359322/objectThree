package org.java.mapper;

import org.java.entity.OaFile;

public interface OaFileMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(OaFile record);

    int insertSelective(OaFile record);

    OaFile selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(OaFile record);

    int updateByPrimaryKey(OaFile record);
}