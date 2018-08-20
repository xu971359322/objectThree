package org.java.service;

import java.util.List;
import java.util.Map;

public interface SysUserService {

	public abstract Map<String,Object> loginInfo(String username);
	
	/*public List<Map<String,Object>> getMenus(Integer roleId);

	public List<String> getPermissions(Integer userId);*/
}
