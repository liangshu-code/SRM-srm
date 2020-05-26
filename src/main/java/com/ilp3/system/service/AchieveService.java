package com.ilp3.system.service;

import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.AchievementsDetail;

import java.util.List;

public interface AchieveService {
//    Achievements getAchieve(int id);
//    List<Achievements> list();
//
//    public void UpdateTotal(Achievements achievements);

    int insertinit(Achievements achievement);

    List<Achievements> list(int supplierid);

    int count(int supplierId);

    int insertinfo(Achievements achievements);


    Achievements selectweight(int aid);
}
