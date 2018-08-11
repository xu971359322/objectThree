package org.java.mapper;

import org.java.entity.OaMeeting;

public interface OaMeetingMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(OaMeeting record);

    int insertSelective(OaMeeting record);

    OaMeeting selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(OaMeeting record);

    int updateByPrimaryKey(OaMeeting record);
}