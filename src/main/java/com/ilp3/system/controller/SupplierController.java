//package com.ilp3.system.controller;
//
//import com.ilp3.system.entity.SupplierDo;
//import com.ilp3.system.service.SupplierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//public class SupplierController {
//    @Autowired
//    SupplierService supplierService;
//    @GetMapping("/supplier")
//    String supplier(Model model){
//        return "Supplier/supplier.html";
//    }
//    @ResponseBody
//    @RequestMapping("/supplierLIst")
//    List<SupplierDo> test1(Model model){
//        List<SupplierDo> list = SupplierService.supplierList();
//        return  list;
//
//    }
//
//}
