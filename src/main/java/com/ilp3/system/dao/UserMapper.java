package com.ilp3.system.dao;

import com.ilp3.system.entity.SysUserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

	@Select("select `user_id`, `username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name` from srm_user where user_id = #{id}")
	SysUserDO get(Long id);
	
	@Select("<script>" +
	"select * from srm_user " +
			"<where>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  			"</where>"+ 
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<SysUserDO> list(Map<String, Object> param);

	@Select("<script>" +
	"select count(*) from srm_user " +
			"<where>" +
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" +
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" +
		  			"</where>"+
			"</script>")
	int count(Map<String, Object> map);
	
	@Options(useGeneratedKeys = true, keyProperty = "userId")
	@Insert("insert into srm_user (`username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name`)"
	+ "values (#{username}, #{password}, #{email}, #{mobile}, #{status}, #{userIdCreate}, #{gmtCreate}, #{gmtModified}, #{name})")
	int save(SysUserDO obj);
	
	@Update("<script>"+ 
			"update srm_user " + 
					"<set>" + 
		            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"username != null\">`username` = #{username}, </if>" + 
                    "<if test=\"password != null\">`password` = #{password}, </if>" + 
                    "<if test=\"email != null\">`email` = #{email}, </if>" + 
                    "<if test=\"mobile != null\">`mobile` = #{mobile}, </if>" + 
                    "<if test=\"status != null\">`status` = #{status}, </if>" + 
                    "<if test=\"userIdCreate != null\">`user_id_create` = #{userIdCreate}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">`gmt_modified` = #{gmtModified}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
          					"</set>" + 
					"where user_id = #{userId}"+
			"</script>")
	int update(SysUserDO obj);
	
	@Delete("delete from srm_user where user_id =#{userId}")
	int remove(Long user_id);
	
	@Delete("<script>"+ 
			"delete from srm_user where user_id in "+
			"<foreach collection=\"list\" index=\"i\" open=\"(\" separator=\",\" close=\")\" item=\"item\"  >#{item}</foreach>"+
			"</script>")
	int batchRemove(List<Long> list);

	@Select("select `user_id`, `username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name` from srm_user where username = #{username}")
    SysUserDO findByName(String username);
}
