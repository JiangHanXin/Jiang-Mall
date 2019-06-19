package com.xiaojiang.manager.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人:小江
 * @创建时间:2019/6/17 0017
 * @描述:登录
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/loginName")
    public Map loginName(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("username",name);
        map2.put("sex","男");
        map2.put("role",1);

        map.put("code",0);
        map.put("msg","");
        map.put("data",map2);
        return map;
    }
}
