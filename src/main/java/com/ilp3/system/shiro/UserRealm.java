package com.ilp3.system.shiro;

import com.ilp3.common.utils.ShiroUtils;
import com.ilp3.system.dao.UserMapper;
import com.ilp3.system.entity.SysUserDO;
import com.ilp3.system.service.MenuService;
import com.ilp3.system.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	@Lazy
	UserMapper userMapper;
	@Autowired
	@Lazy
    MenuService menuService;
	
	@Autowired
    @Lazy
    RoleService roleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		Long userId = ShiroUtils.getUserId();
		Set<String> perms = menuService.listPerms(userId);
		Set<String> roles = roleService.listRoles(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		info.setRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Map<String, Object> map  = new HashMap<>();
		map.put("username", username);
		String password = new String((char[]) token.getCredentials());

		SysUserDO user = null;

		// 查询用户信息
		List<SysUserDO> list = userMapper.list(map);
		if(list.size() != 0){
			user = list.get(0);
		}


		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}

		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
