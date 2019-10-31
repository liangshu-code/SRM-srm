package com.example.demo.service;

import com.example.demo.entity.ResultMsg;


public interface UserService {

    public ResultMsg  find();

    public ResultMsg checklogin(String username,String password);
}
