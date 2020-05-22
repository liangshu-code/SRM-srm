package com.ilp3.system.dao;

import com.ilp3.system.entity.Achievements;

import com.ilp3.system.entity.AchievementsDetail;
import com.ilp3.system.entity.MenuDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.List;

public interface AchieveMapper {
    @Select("SELECT * FROM achievements where achievements_id =(select achievements_id from achievements where supplier_id=#{id}) ")
    Achievements getAchieve(Integer id);



    @Select("SELECT * from achievements")
    List<Achievements> list();

    @Insert("insert srm_menu(parent_id,name,url,perms,type) values(#{parentId},#{name},#{url},#{perms},#{type})")
    int save(AchievementsDetail ad);

    @Update("UPDATE srm_menu SET  name=#{name}, url=#{url},  icon=#{icon},type=#{type},perms=#{perms} WHERE menu_id=#{menuId}")
    int update(MenuDO menu);
    @Update("UPDATE achievements SET  totalcount=#{totalcount} WHERE supplier_id=#{supplierId}")
    void UpdateTotal(Achievements achievements);
}
