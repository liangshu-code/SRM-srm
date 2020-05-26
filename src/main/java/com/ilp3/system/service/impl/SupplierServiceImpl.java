package com.ilp3.system.service.impl;

import com.ilp3.system.dao.SupplierMapper;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.entity.TResult;

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
    public int supadd(SupplierDo supplierDo) {
        return   supplierMapper.add(supplierDo);

    }

    @Override
    public int remove(Long id) {
        return supplierMapper.remove(id);
    }

    @Override
    public SupplierDo get(Long id) {
        return supplierMapper.get(id);
    }

    @Override
    public int update(SupplierDo supplierDo) {
        return supplierMapper.update(supplierDo);
    }

    @Override
    public TResult tyList(int id) {
        return  supplierMapper.tyList(id);
    }

}
