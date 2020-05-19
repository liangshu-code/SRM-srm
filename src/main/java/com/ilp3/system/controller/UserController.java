package com.ilp3.system.controller;

import com.ilp3.common.controller.BaseController;
import com.ilp3.common.utils.MD5Utils;
import com.ilp3.common.utils.PageUtils;
import com.ilp3.common.utils.Query;
import com.ilp3.common.utils.R;
import com.ilp3.system.entity.RoleDO;
import com.ilp3.system.entity.SysUserDO;
import com.ilp3.system.service.RoleService;
import com.ilp3.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/srm/user")
@Controller
public class UserController extends BaseController {
	@Autowired
    UserService userService;
	@Autowired
    RoleService roleService;

	@RequiresPermissions("srm:user:user")
	@GetMapping("")
	String user(Model model) {
		return "srm/user/user";
	}

	@GetMapping("/list")
	@ResponseBody
    PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysUserDO> sysUserList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtil = new PageUtils(sysUserList, total);
		return pageUtil;
	}

	@RequiresPermissions("srm:user:add")
	//@Log("添加用户")
	@GetMapping("/add")
	String add(Model model) {
		List<RoleDO> roles = roleService.list();
		model.addAttribute("roles", roles);
		return "srm/user/add";
	}

	@RequiresPermissions("srm:user:edit")
	//@Log("编辑用户")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		SysUserDO userDO = userService.get(id);
		model.addAttribute("user", userDO);
		List<RoleDO> roles = roleService.list(id);
		model.addAttribute("roles", roles);
		return "srm/user/edit";
	}

	@RequiresPermissions("srm:user:add")
	//@Log("保存用户")
	@PostMapping("/save")
	@ResponseBody
    R save(SysUserDO user) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		if (userService.save(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("srm:user:edit")
//	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
    R update(SysUserDO user) {
		// return R.error(1, "演示系统不允许修改");
		if (userService.update(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("srm:user:remove")
	//@Log("删除用户")
	@PostMapping("/remove")
	@ResponseBody
    R remove(Long id) {
		// return R.error("演示系统不允许删除");
		if (userService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@RequiresPermissions("srm:user:batchRemove")
	//@Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
    R batchRemove(@RequestParam("ids[]") Long[] userIds) {
		// return R.error("演示系统不允许删除");
		List<Long> Ids = Arrays.asList(userIds);
		int r = userService.batchremove(Ids);
		System.out.println(r);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// Query query = new Query(params);
		return !userService.exit(params);// 存在，不通过，false
	}

	@RequiresPermissions("srm:user:resetPwd")
	//@Log("请求更改用户密码")
	@GetMapping("/resetPwd/{id}")
	String resetPwd(@PathVariable("id") Long userId, Model model) {

		SysUserDO userDO = new SysUserDO();
		userDO.setUserId(userId);
		model.addAttribute("user", userDO);
		return "srm/user/reset_pwd";
	}

	//@Log("提交更改用户密码")
	@PostMapping("/resetPwd")
	@ResponseBody
    R resetPwd(SysUserDO user) {
		if (1L == user.getUserId()) {
			return R.error("演示系统不允许修改管理员密码");
		}
		user.setPassword(MD5Utils.encrypt(userService.get(user.getUserId()).getUsername(), user.getPassword()));
		if (userService.resetPwd(user) > 0) {
			return R.ok();
		}
		return R.error();
	}

}
