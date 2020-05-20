package com.ilp3.system.controller;
import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/achieve")
public class AchieveController {
    @Autowired
    AchieveService achieveService;

    @RequestMapping({"/list"})
    String list(Model model){
    return "srm/achieve/list";
}
    @ResponseBody
    @RequestMapping("/count")
    public Achievements count(Model model,SupplierDo supplierDo){
//        int id=supplierDo.getSupplierId();
//        Achievements AcInfo= achieveService.getAchieve(id);
//        model.addAttribute("achieve",AcInfo);
          Achievements a=achieveService.list();
        return a;

  }

}
