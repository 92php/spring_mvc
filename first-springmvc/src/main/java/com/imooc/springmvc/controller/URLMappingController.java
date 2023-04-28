package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/um")
public class URLMappingController {

    @GetMapping("/g")
    @ResponseBody
    public String getMapping(@RequestParam("manager_name") String managerName){
        System.out.println("manager_name:" + managerName);
        return "this is get method";
    }

    @PostMapping("/p")
    @ResponseBody
    public String postMapping(String username,String password){
        System.out.println(username + ":" + password);
        return "this id post method";
    }

    @PostMapping("/p1")
    @ResponseBody
    public String postMapping1(User user){
        System.out.println(user.getUsername() + ":" + user.getPassword());
        return "这是 post 方法1";
    }


    @RequestMapping("/gg")  //作用在方法上，不在区分get/post请求
    @ResponseBody
    public String testMapping(){
        return "this id test method";
    }

    @RequestMapping(value = "/gg1",method = RequestMethod.GET)
    @ResponseBody
    public String testGetMapping(){
        return "this id test get method";
    }

    @GetMapping("/view")
    public ModelAndView showView(Integer userId){
        ModelAndView mav = new ModelAndView("/view.jsp");
        User user = new User();
        if(userId == 1){
            user.setUsername("lily");
        }else if(userId == 2){
            user.setUsername("smith");
        }
        mav.addObject("u",user);
        return mav;
    }

    //String与ModelMap
    //Controller方法返回String的情况
    //1.方法被@ResponseBody描述,SpringMVC直接响应String字符串本身
    //2.方法不被@ResponseBody描述,则SpringMVC处理String指代的是视图（页面）
    @GetMapping("/xxxx")
    //@ResponseBody
    public String showView1(Integer userId, ModelMap modelMap){
        String view = "/view,jsp";
        User user = new User();
        if(userId == 1){
            user.setUsername("lily");
        }else if(userId == 2){
            user.setUsername("smith");
        }
        modelMap.addAttribute("u",user);
        return view;
    }
}
