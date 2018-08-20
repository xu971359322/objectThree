package org.java.service.impl;

import java.util.List;
import java.util.Map;

import org.java.entity.OaTeamRole;
import org.java.entity.OaTeamWorker;
import org.java.mapper.OaTeamWorkerCustomMapper;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private OaTeamWorkerCustomMapper oaTeamWorkerCustomMapper;

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
	public List<Map<String,Object>> one(){
		return oaTeamWorkerCustomMapper.one();
	}
}