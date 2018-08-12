package org.java.service.impl;

import java.util.List;
import java.util.Map;
import org.java.mapper.OaTeamWorkerCustomMapper;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private OaTeamWorkerCustomMapper OaTeamWorkerCustomMapper;

	@Override
	public Map<String, Object> loginInfo(String username) {
		List<Map<String, Object>> list = OaTeamWorkerCustomMapper.loginInfo(username);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
}