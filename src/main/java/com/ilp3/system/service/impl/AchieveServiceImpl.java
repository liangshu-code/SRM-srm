package com.ilp3.system.service.impl;

import com.ilp3.system.dao.AchievementsMapper;
import com.ilp3.system.entity.Achievements;
import com.ilp3.system.entity.AchievementsDetail;
import com.ilp3.system.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AchieveServiceImpl implements AchieveService {

@Autowired
AchievementsMapper achievementsMapper;

//public Achievements getAchieve(int id){
//    return achieveMapper.getAchieve(id);
//}
//    public List<Achievements> list(){
//        return  achieveMapper.list();
//    }
//
//    @Override
//    public void UpdateTotal(Achievements achievements) {
//        achieveMapper.UpdateTotal(achievements);
//    }

    @Override
    public int insertinit(Achievements achievement) {
        System.out.println(achievement);
     return  achievementsMapper.insert(achievement);

    }

    @Override
    public List<Achievements> list(int supplierid) {
        return achievementsMapper.selectBySupplierid(supplierid);

    }

    @Override
    public  int count(int supplierId) {
        return achievementsMapper.countById(supplierId);
    }

    @Override
    public int insertinfo(Achievements achievements) {
        return achievementsMapper.updateByPrimaryKey(achievements);
    }

    @Override
    public Achievements selectweight(int aid) {
        return achievementsMapper.selectByPrimaryKey(aid);
    }


}
