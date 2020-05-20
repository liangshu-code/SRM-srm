package com.ilp3.system.service.impl;

import com.ilp3.system.dao.SupplierMapper;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;


    @Override
    public List<SupplierDo> List(Map<String, Object> map) {
        return supplierMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return supplierMapper.count(map);
    }

    @Override
    public List<SupplierDo> AllList(int id) {
        return supplierMapper.Alllist(id);
    }

}
