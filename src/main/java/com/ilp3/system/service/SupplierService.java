package com.ilp3.system.service;

import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.entity.TResult;



import java.util.List;
import java.util.Map;

public interface SupplierService {
       List<SupplierDo> List(Map<String, Object> map);

       int count(Map<String, Object> map);

       int supadd(SupplierDo supplierDo);

       int remove(Long id);

       SupplierDo get(Long id);

       int update(SupplierDo supplierDo);

       TResult tyList(int id);
}
