package com.example.demo.controller;

import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;


}
