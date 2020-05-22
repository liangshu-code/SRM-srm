package com.ilp3.system.service.impl;

import com.ilp3.system.dao.AchieveMapper;
import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.AchievementsDetail;
import com.ilp3.system.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AchieveServiceImpl implements AchieveService {
@Autowired
    AchieveMapper achieveMapper;
public Achievements getAchieve(int id){
    return achieveMapper.getAchieve(id);
}
    public List<Achievements> list(){
        return  achieveMapper.list();
    }

    @Override
    public void UpdateTotal(Achievements achievements) {
        achieveMapper.UpdateTotal(achievements);
    }

    @Override
    public int save(AchievementsDetail ad) {
        return achieveMapper.save(ad);


    }

    @Override
    public void insertac(Achievements achievements) {
        achieveMapper.insertac(achievements);
    }
}
