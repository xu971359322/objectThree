package org.java.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.java.entity.OaTeamRole;
import org.java.service.SysUserService;
import org.java.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class CustomRealm extends AuthorizingRealm{
	private final String SALT_INFO = "accp";
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private UtilService utilService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{

		String principal = (String) token.getPrincipal();//得到用户凭证

		Map<String,Object> user = sysUserService.loginInfo(principal);//到数据库判断用户名是否存在,utilService.getRoleId()
		/*if(user!=null&&!"".equals(user)){
			System.out.println(user+"=================================================");
			System.out.println(user.get("wo_role")+"=================================================");
			user=sysUserService.loginInfo(principal, Integer.parseInt(user.get("wo_role").toString()));
		}else if(user==null){
			return null;
		}*/
		if(user==null){
			return null;
		}
		String pwd =(String) user.get("wo_loginPwd");//如果用户名存在，就从返回的map中，得到用户的正确密码,//返回正确密码

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd,ByteSource.Util.bytes(SALT_INFO),"myRealm");

		return info;
	}
}
