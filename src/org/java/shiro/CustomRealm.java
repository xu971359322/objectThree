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
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc){
		System.out.println("------------->>正在执行授权操作fffffffffffffffffffffffffffffffffffff");

		//根据用户信息，从数据库取他可以操作的菜单
		Map<String,Object> user = (Map<String, Object>) pc.getPrimaryPrincipal();

		//获得用户id
		/*Integer userId = (Integer) user.get("id");*/
		String userId=user.get("wo_id").toString();
		System.out.println(userId+"=========================");

		//查询数据库，得到用户的所有访问权限
		List<String> list = sysUserService.getPermissions(userId);
		for (String s : list) {
			System.out.println(s+"=====================");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(list);//加载权限

		return info;
		//return null;<property name="unauthorizedUrl" value="/refuse.jsp"/>权限不足的情况
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{

		String principal = (String) token.getPrincipal();//得到用户凭证

		Map<String,Object> user = sysUserService.loginInfo(principal);//到数据库判断用户名是否存在,utilService.getRoleId()

		if(user==null) return null;

		Integer roleId = (Integer) user.get("roleId");//根据用户的角色id加载它的菜单

		List<Map<String,Object>> menus = sysUserService.getMenus(roleId);//查询可以操作的菜单

		user.put("menus",menus);//把菜单，放到用户凭证中

		String pwd =(String) user.get("wo_loginPwd");//如果用户名存在，就从返回的map中，得到用户的正确密码,//返回正确密码

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,pwd,ByteSource.Util.bytes(SALT_INFO),"myRealm");

		return info;
	}
}
