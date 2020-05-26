package com.ilp3.system.util;

import com.ilp3.system.entity.Achievements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class chievementinit {

    public List<Achievements> listAc(){

        Achievements a1=new Achievements();
        Achievements a2=new Achievements();
        Achievements a3=new Achievements();
        Achievements a4=new Achievements();
        Achievements a5=new Achievements();
        Achievements a6=new Achievements();
        Achievements a7=new Achievements();
        Achievements a8=new Achievements();
        Achievements a9=new Achievements();
        Achievements a10=new Achievements();
        Achievements a11=new Achievements();
        Achievements a12=new Achievements();
        Achievements a13=new Achievements();
        Achievements a14=new Achievements();
        Achievements a15=new Achievements();
        Achievements a16=new Achievements();
        Achievements a17=new Achievements();

        a1.setAchievementsName("质量绩效评价");
        a1.setWeight(0.4);
        a2.setAchievementsName("交货期绩效评价");
        a2.setWeight(0.2);
        a3.setAchievementsName("价格及付款方式绩效评价");
        a3.setWeight(0.2);
        a4.setAchievementsName("投诉处理绩效评价");
        a4.setWeight(0.1);
        a5.setAchievementsName("服务绩效评价");
        a5.setWeight(0.1);
        a6.setAchievementsName("批次合格率评价");
        a6.setWeight(0.3);
        a7.setAchievementsName("原材料品质问题评价");
        a7.setWeight(0.1);
        a8.setAchievementsName("按时交货率评价");
        a8.setWeight(0.1);
        a9.setAchievementsName("供应商文件提交时间和情况评价");
        a9.setWeight(0.05);
        a10.setAchievementsName("订单及时回复评价");
        a10.setWeight(0.05);
        a11.setAchievementsName("产品价格定位评价");
        a11.setWeight(0.1);
        a12.setAchievementsName("结款方式评价");
        a12.setWeight(0.05);
        a13.setAchievementsName("行为及态度评价评价");
        a13.setWeight(0.05);
        a14.setAchievementsName("反馈逾期评价");
        a14.setWeight(0.05);

        a15.setAchievementsName("品质异常处理速度评价");
        a15.setWeight(0.05);
        a16.setAchievementsName("拖延或拒绝退货评价");
        a16.setWeight(0.1);
        a17.setAchievementsName("绩效总评");
        a17.setWeight(1.0);
        List<Achievements> achievements=new ArrayList<Achievements>();
        achievements.add(a1);
        achievements.add(a6);
        achievements.add(a7);
        achievements.add(a2);
        achievements.add(a8);
        achievements.add(a9);
        achievements.add(a10);
        achievements.add(a3);
        achievements.add(a11);
        achievements.add(a12);
        achievements.add(a13);

        achievements.add(a4);
        achievements.add(a14);
        achievements.add(a15);
        achievements.add(a5);
        achievements.add(a16);
        achievements.add(a17);
        return achievements;
    }
}
