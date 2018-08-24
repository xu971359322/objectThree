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
    public List<Map<String,Object>> loginInfo(@Param("username") String username);/*,@Param("workerRole") Integer workerRole*/
    OaTeamWorker loginInfo(@Param("username") String username,@Param("password")String password);

    List<Map<String,Object>> one();

    List<OaTeamWorker> userByDeptId(@Param("dept")Object[] dept);

    //通过部门查询领导
    public List<OaTeamWorker> selDeptManage(@Param("deptId")Integer deptId);

    //通过身份查询人
    public List<OaTeamWorker> selManageByIdenty(@Param("rid")Integer rid);

    //通过部门查询员工
    public List<OaTeamWorker> selDeptEmployee(@Param("deptId")Integer deptId);
}
