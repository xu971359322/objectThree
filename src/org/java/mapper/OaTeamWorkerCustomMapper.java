package org.java.mapper;

import org.apache.ibatis.annotations.Param;
import org.java.entity.OaTeamRole;
import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

public interface OaTeamWorkerCustomMapper{
    /**
     * 根据姓名，查找用户信息，如果存在返回list，list中有map，如果不存在，list中没有数据
     * @param username
     * @return
     */
    OaTeamWorker loginInfo(@Param("username") String username,@Param("password")String password);

    List<Map<String,Object>> one();

    List<OaTeamWorker> userByDeptId(@Param("dept")Object[] dept);
}
