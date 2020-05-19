package com.ilp3.system.controller;

import com.ilp3.common.controller.BaseController;
import com.ilp3.common.utils.R;
import com.ilp3.system.entity.RoleDO;
import com.ilp3.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/srm/role")
@Controller
public class RoleController extends BaseController {
	String prefix = "srm/role";
	@Autowired
    RoleService roleService;

	@RequiresPermissions("srm:role:role")
	@GetMapping()
	String role() {
		return prefix + "/role";
	}

	@RequiresPermissions("srm:role:role")
	@GetMapping("/list")
	@ResponseBody()
	List<RoleDO> list() {
		List<RoleDO> roles = roleService.list();
		return roles;
	}

	//@Log("添加角色")
	@RequiresPermissions("srm:role:add")
	@GetMapping("/add")
	String add() {
		return prefix + "/add";
	}

	//@Log("编辑角色")
	@RequiresPermissions("srm:role:edit")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		RoleDO roleDO = roleService.get(id);
		model.addAttribute("role", roleDO);
		return prefix + "/edit";
	}

	//@Log("保存角色")
	@RequiresPermissions("srm:role:add")
	@PostMapping("/save")
	@ResponseBody()
    R save(RoleDO role) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (roleService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	//@Log("更新角色")
	@RequiresPermissions("srm:role:edit")
	@PostMapping("/update")
	@ResponseBody()
    R update(RoleDO role) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (roleService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	//@Log("删除角色")
	@RequiresPermissions("srm:role:remove")
	@PostMapping("/remove")
	@ResponseBody()
    R save(Long id) {
		if ("test"==getUsername()) {
			return R.error(1, "演示系统不允许删除,完整体验请部署程序");
		}
		if (roleService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
}
