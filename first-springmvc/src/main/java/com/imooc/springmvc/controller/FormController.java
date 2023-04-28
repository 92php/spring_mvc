package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.Form;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class FormController {

    @PostMapping("/apply1")
    @ResponseBody
    public String apply1(@RequestParam(value = "n",defaultValue = "ANON") String name, String course, Integer[] purpose){
        System.out.println(name);
        System.out.println(course);
        for (Integer p:purpose){
            System.out.println(p);
        }
        return "success";
    }

    @PostMapping("/apply2")
    @ResponseBody
    public String apply2(String name, String course,@RequestParam List<Integer> purpose){
        System.out.println(name);
        System.out.println(course);
        for (Integer p:purpose){
            System.out.println(p);
        }
        return "success";
    }

    @PostMapping("/apply3")
    @ResponseBody
    public String apply3(Form form){
        return "success";
    }

    //map接受复合数据有缺陷
    @PostMapping("/apply4")
    @ResponseBody
    public String apply4(@RequestParam Map map){
        System.out.println(map);
        return "success";
    }

    @PostMapping("/apply")
    @ResponseBody
    public String applyDelivery(Form form){
        System.out.println(form.getDelivery().getName());
        return "success";
    }
}
