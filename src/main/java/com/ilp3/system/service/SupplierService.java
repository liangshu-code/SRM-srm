package com.ilp3.system.service;

import com.ilp3.system.entity.SupplierDo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SupplierService {
      List<SupplierDo> supplierList();
}
