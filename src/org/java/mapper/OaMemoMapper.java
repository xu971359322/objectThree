package org.java.mapper;

import org.java.entity.OaMemo;

public interface OaMemoMapper {
    int deleteByPrimaryKey(Integer meId);

    int insert(OaMemo record);

    int insertSelective(OaMemo record);

    OaMemo selectByPrimaryKey(Integer meId);

    int updateByPrimaryKeySelective(OaMemo record);

    int updateByPrimaryKey(OaMemo record);
}