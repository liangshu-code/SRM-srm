package com.ilp3.system.dao;

import com.ilp3.system.entity.RoleDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
	@Select("SELECT role_id, role_name, role_sign, gmt_create, gmt_modified FROM srm_role")
	@Results({ @Result(property = "roleId", column = "role_id"), @Result(property = "roleName", column = "role_name") })
	List<RoleDO> listRole();

	@Insert("INSERT INTO srm_role(role_id, role_name, role_sign, gmt_create, gmt_modified)VALUES(#{roleId}, #{roleName}, #{roleSign}, #{gmtCreate}, #{gmtModified})")
	@Options(useGeneratedKeys = true,keyProperty="roleId")
	int save(RoleDO role);
	
	@Delete("DELETE FROM srm_role WHERE role_id=#{id}")
	int remove(Long id);
	
	@Select("SELECT role_id, role_name, role_sign,  gmt_create, gmt_modified FROM srm_role where role_id = #{roleId}")
	@Results({ @Result(property = "roleId", column = "role_id"), @Result(property = "roleName", column = "role_name") })
	RoleDO get(Long id);
	
	@Update("update srm_role set role_name = #{roleName}  where role_id=#{roleId}")
	int update(RoleDO role);

    @Select("select distinct role_name from srm_role sr,srm_user_role sur where sr.role_id = sur.role_id and sur.user_id =#{userId} ")
    List<String> listUserRoles(Long userId);
}
