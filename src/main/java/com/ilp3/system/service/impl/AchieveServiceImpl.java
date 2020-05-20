package com.ilp3.system.service.impl;

import com.ilp3.system.dao.AchieveMapper;
import com.ilp3.system.entity.Achievements;
import com.ilp3.system.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AchieveServiceImpl implements AchieveService {
@Autowired
    AchieveMapper achieveMapper;
public Achievements getAchieve(int id){
    return achieveMapper.getAchieve(id);
}
    public Achievements list(){
        return achieveMapper.list();
    }
}
