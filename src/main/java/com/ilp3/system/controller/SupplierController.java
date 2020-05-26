package com.ilp3.system.controller;

import com.ilp3.common.utils.PageUtils;
import com.ilp3.common.utils.Query;
import com.ilp3.common.utils.R;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.entity.TResult;
import com.ilp3.system.entity.TianYanDo;
import com.ilp3.system.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @GetMapping("/srm/supplier")
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
    @RequestMapping("/supTy")
    TResult test2(int  id) throws ParseException {
        TResult list = supplierService.tyList(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String EstiblishTime1 =format.format(list.getEstiblishTime());
        Date EstiblishTime =format.parse(EstiblishTime1);
        list.setEstiblishTime(EstiblishTime);
        System.out.println(list);
        return  list;
    }
    @GetMapping("/supaddhtml")
    String add(Model model) {
        return "srm/supplier/add";
    }
    @GetMapping("/supupdatehtml/{id}")
    String edit(Model model, @PathVariable("id") Long id) {
        SupplierDo supplierDo = supplierService.get(id);
        model.addAttribute("supplier", supplierDo);
        return "srm/supplier/edit";
    }
    @ResponseBody
    @RequestMapping("/supadd")
    R test3(SupplierDo supplierDo){
        if (supplierService.supadd(supplierDo) > 0) {
            return R.ok();
        }
     return R.error();
    }
    @PostMapping("/update")
    @ResponseBody
    R update(SupplierDo supplierDo) {
        if (supplierService.update(supplierDo) > 0) {
            return R.ok();
        }
        return R.error();
    }
    @ResponseBody
    @RequestMapping("/remove")
    R test4(long id){
        if (supplierService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

}
