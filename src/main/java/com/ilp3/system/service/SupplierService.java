package com.ilp3.system.service;

import com.ilp3.system.entity.SupplierDo;


import java.util.List;
import java.util.Map;

public interface SupplierService {
       List<SupplierDo> List(Map<String, Object> map);
       int count(Map<String, Object> map);
      List<SupplierDo> AllList(int id);
}
