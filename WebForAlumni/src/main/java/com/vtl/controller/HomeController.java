package com.vtl.controller;


import com.vtl.service.MajorService;

import com.vtl.service.PostService;
import com.vtl.service.TopicService;
import com.vtl.service.UserService;
import java.security.Principal;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thuy Linh
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private PostService ps;
     @Autowired
    private TopicService ts;

    @Autowired
    private MajorService ms;
    @Autowired
    private UserService us;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("post", this.ps.getPost(params));
        model.addAttribute("major", this.ms.getMajor());
        model.addAttribute("user", this.us.getInfoAllUser());
        model.addAttribute("topic", this.ts.getAllTopic());
        return "home";
    }
    
    
}



