package com.ilp3.system.dao;


import com.ilp3.system.entity.SupplierDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SupplierMapper {
    @Select("select * from srm_supplier_info")
    List<SupplierDo> list();
}
