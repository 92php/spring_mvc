package com.imooc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/t")     //localhost/t
    @ResponseBody        //直接响应输出字符串数据,不跳转页面
    public String test(){
        return "Hello Spring MVC";
    }
}
