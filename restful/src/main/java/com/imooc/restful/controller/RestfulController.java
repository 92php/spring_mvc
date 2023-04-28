package com.imooc.restful.controller;

import com.imooc.restful.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/restful")
@CrossOrigin(origins = {"http://localhost:8888"})
//@CrossOrigin(origins = "*")
public class RestfulController {

    @GetMapping("/request")
    //@ResponseBody
    public String doGetRequest(){
        return "{\"message\":\"返回查询结果\"}";
    }

    // POST /restful/request/100
    @PostMapping ("/request/{rid}")
    //@ResponseBody
    public String doPostRequest(@PathVariable("rid") Integer requestId){
        return "{\"message\":\"数据新建成功\",\"id\":"+requestId+"}";
    }


    @PostMapping ("/request1/{rid}")
    public String doPostRequest1(@PathVariable("rid") Integer requestId,Person person){
        System.out.println(person.getName()+":"+person.getAge());
        return "{\"message\":\"数据新建成功\",\"id\":"+requestId+"}";
    }

    @PutMapping("/request")
    //@ResponseBody
    public String doPutRequest(){
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    //@ResponseBody
    public String doDeleteRequest(){
        return "{\"message\":\"数据删除成功\"}";
    }

    @GetMapping("/person")
    public Person findByPersonId(Integer id){
        Person p = new Person();
        if(id == 1){
            p.setName("lily");
            p.setAge(18);
        }else if(id == 2){
            p.setName("andy");
            p.setAge(20);
        }
        return p;
    }


    @GetMapping("/persons")
    public List<Person> findPersons(){
        List list = new ArrayList();
        Person p1 = new Person();
        p1.setName("lily");
        p1.setAge(18);

        Person p2 = new Person();
        p2.setAge(20);
        p2.setName("andy");

        list.add(p1);
        list.add(p2);
        //System.out.println("RestfulController.findPersons return list");
        return list;
    }
}
