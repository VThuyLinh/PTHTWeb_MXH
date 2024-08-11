/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.service.MajorService;
import com.vtl.service.PostService;
import com.vtl.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thuy Linh
 */
@Controller
public class HomeController {
    @Autowired
    private PostService ps;
    
    @Autowired
    private MajorService ms;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map <String,String> params) {
      
        
        model.addAttribute("post",this.ps.getPost(params));
        model.addAttribute("major", this.ms.getMajor());
//        model.addAttribute("user",us.getInfoUserById(1));
        return "homeAdmin";
    }

}


