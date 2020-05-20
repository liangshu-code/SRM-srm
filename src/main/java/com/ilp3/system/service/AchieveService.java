package com.ilp3.system.service;

import com.ilp3.system.entity.Achievements;

public interface AchieveService {
    Achievements getAchieve(int id);
    Achievements list();
}
