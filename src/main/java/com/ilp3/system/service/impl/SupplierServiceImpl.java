package com.ilp3.system.service.impl;

import com.ilp3.system.dao.SupplierMapper;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<SupplierDo> supplierList() {
        List<SupplierDo> list = supplierMapper.list();
        return list;
    }
}
