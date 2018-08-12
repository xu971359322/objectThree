package org.java.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OaTeamWorkerCustomMapper{
    /**
     * 根据姓名，查找用户信息，如果存在返回list，list中有map，如果不存在，list中没有数据
     * @param username
     * @return
     */
    public List<Map<String,Object>> loginInfo(@Param("username") String username);
}
