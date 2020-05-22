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
    public List<Achievements> count(Model model) {
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

    @RequestMapping("/add1")
    String add1() {
//        List<Achievements> list=achieveService.list();
//        Achievements ac=list.get(0);
//        model.addAttribute("ac",ac);
        return "srm/achieve/add1";
    }

    @RequestMapping("/add2")
    String add2() {
//        List<Achievements> list=achieveService.list();
//        Achievements ac=list.get(0);
//        model.addAttribute("ac",ac);
        return "srm/achieve/add2";
    }

    @RequestMapping("/add3")
    String add3() {
//        List<Achievements> list=achieveService.list();
//        Achievements ac=list.get(0);
//        model.addAttribute("ac",ac);
        return "srm/achieve/add3";
    }

    @RequestMapping("/add4")
    String add4() {
//        List<Achievements> list=achieveService.list();
//        Achievements ac=list.get(0);
//        model.addAttribute("ac",ac);
        return "srm/achieve/add4";
    }

    @RequestMapping("/add5")
    String add5() {
//        List<Achievements> list=achieveService.list();
//        Achievements ac=list.get(0);
//        model.addAttribute("ac",ac);
        return "srm/achieve/add5";
    }


    @ResponseBody
    @RequestMapping("/save")
    public void save(AchievementsDetail ad) {
        System.out.println(ad);
       achieveService.save(ad);
    }
}
