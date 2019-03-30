package com.coffee.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.entity.RedisUser;
import com.coffee.service.RedisUserService;
@Controller
public class RedisController {
	@Autowired
    RedisUserService redisUserService;
    //查找redis中数据
	@ResponseBody
    @RequestMapping("/findRedisUser")
    public RedisUser finduser() {
        RedisUser user = redisUserService.findUser("lisi1");
        Date date = new Date();
        Date userDate = user.getDate();
        long time = 60*1000;
        System.out.println(new Date(date .getTime() + time));
        System.out.println(userDate);
        System.out.println("大，小："+date.compareTo(userDate));
        System.out.println("小，大："+userDate.compareTo(date));
        System.out.println("大，小:"+ date.after(userDate));
        System.out.println("小，大："+userDate.after(date));
        return user;
        }
	//增加及修改redis数据
    @RequestMapping("/addRedisUser")
	@ResponseBody
    public RedisUser adduser() {
        RedisUser redisUser = new RedisUser();
        Date date = new Date();
        System.out.println(date);
        redisUser.setName("lisi1");
        redisUser.setCode("2222111");
        redisUser.setDate(date);
        return redisUserService.saveUser(redisUser);
    }
    //删除redis数据
    @RequestMapping("/deleteRedisUser")
	@ResponseBody
    public void removeUser() {
        redisUserService.removeUser("lisi1");
    }

}
