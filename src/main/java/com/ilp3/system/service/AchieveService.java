package com.ilp3.system.service;

import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.AchievementsDetail;

import java.util.ArrayList;
import java.util.List;

public interface AchieveService {
    Achievements getAchieve(int id);

    List<Achievements> list();

    public void UpdateTotal(Achievements achievements);

    public int save(AchievementsDetail ad);

    public void insertac(Achievements achievements);
}
