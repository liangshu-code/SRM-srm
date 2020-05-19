package com.ilp3.system.service;

import com.ilp3.common.domain.Tree;
import com.ilp3.system.entity.MenuDO;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @description 系统菜单业务代码
 */
@Service
public interface MenuService {
	Tree<MenuDO> getSysMenuTree(Long id);
	List<Tree<MenuDO>> listMenuTree(Long id);
	Tree<MenuDO> getTree();
	Tree<MenuDO> getTree(Long id);
	List<MenuDO> list();
	int remove(Long id);
	int save(MenuDO menu);
	int update(MenuDO menu);
	MenuDO get(Long id);
	Set<String> listPerms(Long userId);
}
