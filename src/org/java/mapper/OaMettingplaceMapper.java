package org.java.mapper;

import org.java.entity.OaMettingplace;

public interface OaMettingplaceMapper {
    int deleteByPrimaryKey(Integer mpId);

    int insert(OaMettingplace record);

    int insertSelective(OaMettingplace record);

    OaMettingplace selectByPrimaryKey(Integer mpId);

    int updateByPrimaryKeySelective(OaMettingplace record);

    int updateByPrimaryKey(OaMettingplace record);
}