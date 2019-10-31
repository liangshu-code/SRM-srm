package com.example.demo.serviceimpl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.ResultMsg;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
@Resource
public UserDao userDao;

    @Override
    public ResultMsg find() {
        ResultMsg rm = new ResultMsg();
        User user = userDao.find();
        rm.setData(user);
        rm.setMsg("打印成功");

        return  rm;
    }

    @Override
    public ResultMsg checklogin(String username,String password) {
        ResultMsg rm = new ResultMsg();
        User user =userDao.checklogin(username,password);
        System.out.println(username+password);
        if(user!=null){
            rm.setStatus("0");
            rm.setMsg("登陆成功");

        }else {
            rm.setStatus("1");
            rm.setMsg("登陆失败");
        }
        return rm;

    }
}
