package org.java.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.java.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{

		String principal = (String) token.getPrincipal();//得到用户凭证

		Map<String,Object> user = sysUserService.loginInfo(principal);//到数据库判断用户名是否存在

		if(user==null){
			return null;
		}

		String salt = "accp";
		
		//返回正确密码
		String pwd =(String) user.get("wo_loginPwd");//如果用户名存在，就从返回的map中，得到用户的正确密码
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd,ByteSource.Util.bytes(salt),"myRealm");
		
		return info;
	}
}
