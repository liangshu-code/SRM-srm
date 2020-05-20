package com.ilp3.system.controller;

import com.ilp3.common.utils.PageUtils;
import com.ilp3.common.utils.Query;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @GetMapping("/supplieradd")
    String supplieradd(Model model){
        return "srm/supplier/add.html";
    }
    @GetMapping("/supplier")
    String supplier(Model model){
        return "srm/supplier/supplier.html";
    }
    @ResponseBody
    @RequestMapping("/supplierList")
    PageUtils test1(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        List<SupplierDo> list = supplierService.List(query);
        int total = supplierService.count(query);
        PageUtils pageUtil = new PageUtils(list, total);
        return  pageUtil;
    }
    @ResponseBody
    @RequestMapping("/supplierAllList")
    List<SupplierDo> test2(int  id){
        List<SupplierDo> list = supplierService.AllList(id);
        return  list;
    }


}
