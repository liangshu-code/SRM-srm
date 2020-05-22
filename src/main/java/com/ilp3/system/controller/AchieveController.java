package com.ilp3.system.controller;
import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.AchievementsDetail;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/achieve")
public class AchieveController {
    @Autowired
    AchieveService achieveService;

    @RequestMapping({"/list"})
    String list(Model model) {
        List<Achievements> list = achieveService.list();
        Achievements ac = list.get(0);
        model.addAttribute("ac", ac);
        return "srm/achieve/list";
    }

    @ResponseBody
    @RequestMapping("/count")
    public List<Achievements> count(Model model, SupplierDo supplierDo) {
        List<Achievements> list = achieveService.list();
        Achievements ac = list.get(0);
        model.addAttribute("achieve", list);
        int quality = ac.getQuality();
        int deliver = ac.getDeliver();
        int complaint = ac.getComplaint();
        int paymentMethod = ac.getPaymentMethod();
        int service = ac.getService();
        int total = quality + deliver + complaint + paymentMethod + service;
        ac.setTotalcount(total);
        achieveService.UpdateTotal(ac);
        System.out.println(ac);
        return list;
    }

    @RequestMapping("/add")
    String add() {
//        List<Achievements> list=achieveService.list();
//        Achievements ac=list.get(0);
//        model.addAttribute("ac",ac);
        return "srm/achieve/add";

    }
    @ResponseBody
    @RequestMapping("/save")
    public void save(AchievementsDetail ad) {
        System.out.println(ad);
       achieveService.save(ad);




    }
}
