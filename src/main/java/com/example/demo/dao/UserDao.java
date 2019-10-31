package com.example.demo.dao;

import com.example.demo.entity.User;

public interface UserDao {
    public  User  find();

    public  User checklogin(String username,String password);


}
