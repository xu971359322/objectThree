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
	public OaTeamWorker loginInfo(String username, String password){
		OaTeamWorker worker = oaTeamWorkerCustomMapper.loginInfo(username,password);
		System.out.println(worker+"=====================================");
		if(worker!=null){
			return worker;
		}else{
			return null;
		}
	}

	@Override
	public List<OaTeamWorker> userByDeptId(Object[] dept) {
		return oaTeamWorkerCustomMapper.userByDeptId(dept);
	}

	@Override
	public List<Map<String,Object>> one(){
		return oaTeamWorkerCustomMapper.one();
	}
}