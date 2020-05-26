package com.ilp3.system.controller;
import com.ilp3.common.utils.R;
import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.AchievementsDetail;
import com.ilp3.system.entity.MenuDO;
import com.ilp3.system.entity.SupplierDo;
import com.ilp3.system.service.AchieveDetailService;
import com.ilp3.system.service.AchieveService;
import com.ilp3.system.util.chievementinit;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/achieve")
public class AchieveController {
    @Autowired
    AchieveService achieveService;
    @Autowired
    AchieveDetailService achieveDetailService;

    @RequestMapping({"/list"})
    String list(@RequestParam(name = "supplierId") String supplierId, HttpSession session){
        int supplierid = Integer.parseInt(supplierId);
       int list=achieveService.count(supplierid);
          if(list==0) {
          chievementinit achievements = new chievementinit();
          for (Achievements achievement : achievements.listAc()) {
              achievement.setSupplierId(supplierid);
              achieveService.insertinit(achievement);
          }

      }
    return "srm/achieve/list";

}
    @ResponseBody
    @GetMapping("/count/{supplierId}")
    public List<Achievements> count(@PathVariable("supplierId") String supplierId){
        int i = Integer.parseInt(supplierId);
        List<Achievements> list=achieveService.list(i);
          return list;
  }
  @RequestMapping("/add1/{achievementsId}")
    String addpage1(Model model,@PathVariable("achievementsId") String achievementsId){

      int j = Integer.parseInt(achievementsId);
      model.addAttribute("AID",j);


        return "srm/achieve/add1";
    }
    @ResponseBody
    @PostMapping("/save")
     R update( AchievementsDetail achievementsDetail,String achievementsId,double weight,double weight1) {
        int j = Integer.parseInt(achievementsId);
        int k=j+1;
        int l=j+2;
        double q1=achievementsDetail.getQualifiedBatches();
        double q2=achievementsDetail.getTotalFeedBatches();
        int q3=achievementsDetail.getMaterialReturn();
List<Achievements> achievements= new ArrayList<>();
       Achievements achievements1 =achieveService.selectweight(k);
        Achievements achievements2 =achieveService.selectweight(l);
        Achievements achievements3 =achieveService.selectweight(j);
       int score1 =(int)((q1/q2)*100);
       int total1= (int) (score1*weight);
       int total2=(10-2*q3);
       int score2=(int)(total2/weight1);
       int total0=total1+total2;
       int score0= (int) (total0/(weight+weight1));
       double weight0=weight+weight1;
       achievements1.setScore(score1);
       achievements1.setTotalcount(total1);
       achievements1.setWeight(weight);
       achievements1.setAchievementsId(k);
        achievements2.setScore(score2);
        achievements2.setTotalcount(total2);
        achievements2.setWeight(weight1);
        achievements2.setAchievementsId(l);
        achievements3.setTotalcount(total0);
        achievements3.setWeight(weight0);
        achieveService.insertinfo(achievements1);
        achieveService.insertinfo(achievements2);

        if (achieveService.insertinfo(achievements3) > 0) {
            return R.ok();
        } else {
            return R.error(1, "更新失败");
        }
    }


}
