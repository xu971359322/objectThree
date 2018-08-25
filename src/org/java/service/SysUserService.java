package org.java.service;

import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

public interface SysUserService {

	public abstract Map<String,Object> loginInfo(String username);
	
	public List<Map<String,Object>> getMenus(Integer roleId);//通过用户角色得到用户对应的菜单

	public List<String> getPermissions(String userId);

	OaTeamWorker selWorkerById(String wid);

	public List<Map<String,Object>> getWorkerList();

	List<OaTeamWorker> userByDeptId(Object[] dept);
}
