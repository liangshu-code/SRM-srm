package com.ilp3.common.controller;

import com.ilp3.common.utils.ShiroUtils;
import com.ilp3.system.entity.SysUserDO;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	public SysUserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}