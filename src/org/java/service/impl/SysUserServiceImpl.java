package org.java.service.impl;

import java.util.List;
import java.util.Map;

import org.java.entity.OaTeamRole;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaTeamWorkerCustomMapper;
import org.java.mapper.OaTeamWorkerMapper;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private OaTeamWorkerCustomMapper oaTeamWorkerCustomMapper;

	@Autowired
	private OaTeamWorkerMapper oaTeamWorkerMapper;

	@Override
	public OaTeamWorker selWorkerById(String wid) {
		return oaTeamWorkerMapper.selectByPrimaryKey(wid);
	}

	@Override
	public Map<String, Object> loginInfo(String username) {
		List<Map<String, Object>> list = oaTeamWorkerCustomMapper.loginInfo(username);
		if (list.isEmpty()) {
			return null;
		} else{
			return list.get(0);
		}
	}

	@Override
	public List<Map<String, Object>> getMenus(Integer roleId) {
		return oaTeamWorkerCustomMapper.getMenus(roleId);
	}

	@Override
	public List<OaTeamWorker> userByDeptId(Object[] dept) {
		return oaTeamWorkerCustomMapper.userByDeptId(dept);
	}

	@Override
	public List<String> getPermissions(String userId) {
		return oaTeamWorkerCustomMapper.getPermissions(userId);
	}

	@Override
	public List<Map<String, Object>> getWorkerList() {
		return oaTeamWorkerCustomMapper.getWorkerList();
	}
}