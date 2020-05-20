package com.ilp3.system.dao;
import com.ilp3.system.entity.SupplierDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SupplierMapper {
    @Select("<script>" +
            "select * from supplier_info"+
            "<if test=\"offset != null and limit != null\">"+
            "limit #{offset}, #{limit}" +
            "</if>"+
            "</script>")
    List<SupplierDo> list(Map<String,Object> param);
    @Select("select * from supplier_info where supplier_id=id")
    List<SupplierDo> Alllist(int id);
    @Select("select count(*) from supplier_info")
    int count(Map<String, Object> map);
}
