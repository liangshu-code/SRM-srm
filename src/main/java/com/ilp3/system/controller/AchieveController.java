package com.ilp3.system.controller;
import com.ilp3.common.utils.R;
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
    R save(AchievementsDetail ad) {
        System.out.println(ad);
        Achievements achievements=new Achievements();
        int q1=ad.getQualifiedBatches();
        int q2=ad.getTotalFeedBatches();
        int q3=ad.getMaterialReturn();
        int quality= (int) (((float)(q1/q2*30))+(10-(2*q3)));
        int deliver=(int) (((float)(ad.getDeliveryOnTime()/ad.getTotalFeedBatches()*10)))+(ad.getSubmitInfo())+(5-ad.getOrderReplyInfo());
        int paymentMethod=(ad.getAttitude()+ad.getKnotScore()+ad.getAttitude());
        int complaint=(5-ad.getExReply())+(ad.getExDone());
        int service=ad.getRefuseReply();
        int total = quality + deliver + complaint + paymentMethod + service;
         achievements.setQuality(quality);
         achievements.setDeliver(deliver);
         achievements.setComplaint(complaint);
         achievements.setPaymentMethod(paymentMethod);
         achievements.setService(service);
         achievements.setTotalcount(total);
         achieveService.insertac(achievements);
        if (achieveService.save(ad) > 0) {
            return R.ok();
        }
        return R.error();
    }

    }

