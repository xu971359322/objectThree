package org.java.mapper;

import org.java.entity.OaAttendance;

public interface OaAttendanceMapper {
    int deleteByPrimaryKey(Integer atId);

    int insert(OaAttendance record);

    int insertSelective(OaAttendance record);

    OaAttendance selectByPrimaryKey(Integer atId);

    int updateByPrimaryKeySelective(OaAttendance record);

    int updateByPrimaryKey(OaAttendance record);
}