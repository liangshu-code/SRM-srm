package com.ilp3.system.service.impl;

import com.ilp3.system.dao.AchievementDetailMapper;
import com.ilp3.system.entity.AchievementsDetail;
import com.ilp3.system.service.AchieveDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchieveDetailImpl implements AchieveDetailService {
    @Autowired
    AchievementDetailMapper achievementDetailMapper;

    @Override
    public int update(AchievementsDetail achievementsdetail) {
        return achievementDetailMapper.updateByPrimaryKey(achievementsdetail);
    }
}
