package org.java.service;

import org.java.entity.OaTeamRole;
import org.java.entity.OaTeamWorker;

import java.util.List;
import java.util.Map;

public interface SysUserService {

	public OaTeamWorker loginInfo(String username,String password);

	/*public List<Map<String,Object>> getMenus(Integer roleId);

	public List<String> getPermissions(Integer userId);*/

	List<Map<String,Object>> one();
}
