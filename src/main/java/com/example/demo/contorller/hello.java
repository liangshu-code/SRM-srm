package com.example.demo.contorller;
import com.example.demo.entity.ResultMsg;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/xgs")
public class hello {
    @Resource
    public UserService userService;

    @RequestMapping(value="/hello,method = RequestMethod.POST")
    @ResponseBody
    public Map<String, Object> showhelloworld(){
        Map<String,Object> map = new HashMap<>();
        map.put("msg","helloxgs");
        return  map;


    }
    @RequestMapping(value="/find",method = RequestMethod.POST)
    @ResponseBody
        public ResultMsg GetUser(){
            ResultMsg rs =userService.find();
            return  rs;

    }
    @RequestMapping(value="/checklogin",method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg checklogin(String username,String password){
        ResultMsg rs =userService.checklogin(username,password);
        return  rs;

    }

}
