package org.java.mapper;

import org.java.entity.OaMettinguser;

public interface OaMettinguserMapper {
    int deleteByPrimaryKey(Integer muId);

    int insert(OaMettinguser record);

    int insertSelective(OaMettinguser record);

    OaMettinguser selectByPrimaryKey(Integer muId);

    int updateByPrimaryKeySelective(OaMettinguser record);

    int updateByPrimaryKey(OaMettinguser record);
}