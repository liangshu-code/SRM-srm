package com.ilp3.system.dao;

import com.ilp3.system.entity.MenuDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MenuMapper {
	@Select("SELECT  menu_id, parent_id, name, url, perms, `type`, icon, order_num, gmt_create, gmt_modified FROM srm_menu where menu_id =#{id} order by menu_id")
	MenuDO getMenu(Long id);

	@Select("select distinct m.menu_id , parent_id, name, url, perms, `type`, icon, order_num, gmt_create, gmt_modified from srm_menu m left join srm_role_menu rm on m.menu_id = rm.menu_id left join srm_user_role ur on rm.role_id = ur.role_id where ur.user_id = #{id} and m.type in(0,1) order by m.type,m.menu_id")
	List<MenuDO> listMenuByUserId(Long id);

	@Select("select m.perms from srm_menu m left join srm_role_menu rm on m.menu_id = rm.menu_id left join srm_user_role ur on rm.role_id = ur.role_id where ur.user_id = #{id} ")
	List<String> listUserPerms(Long id);

	@Select("SELECT menu_id, parent_id, name, url, perms, `type`, icon, order_num, gmt_create, gmt_modified FROM srm_menu order by type")
	List<MenuDO> listMenu();

	@Delete("delete from srm_menu where menu_id = #{id}")
	int remove(Long id);

	@Insert("insert srm_menu(parent_id,name,url,perms,type) values(#{parentId},#{name},#{url},#{perms},#{type})")
	int save(MenuDO menu);

	@Update("UPDATE srm_menu SET  name=#{name}, url=#{url},  icon=#{icon},type=#{type},perms=#{perms} WHERE menu_id=#{menuId}")
	int update(MenuDO menu);
}
