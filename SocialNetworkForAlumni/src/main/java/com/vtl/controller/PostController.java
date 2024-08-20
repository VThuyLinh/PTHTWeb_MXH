/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Post;
import com.vtl.service.ImageService;
import com.vtl.service.MajorService;
import com.vtl.service.PostService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author Thuy Linh
 */
@Controller
public class PostController {


    
    @Autowired
    private PostService ps;
    @Autowired
    private MajorService ms;
    @Autowired
    private ImageService is;
    
    @GetMapping("/Post")
    public String createView(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("major", this.ms.getMajor());
        return "post";
    }
    
//    @RequestMapping(value = "/Post", method = RequestMethod.POST)
    @PostMapping("/Post")
    public String createView(Model model, @ModelAttribute(value = "post") @Valid Post p,BindingResult rs )
        {
        model.addAttribute("major", this.ms.getMajor());
        if (rs.hasErrors())
            
            return "post";
        
        try {
            this.ps.addOrUpdatePost(p);
            
            
            return "post";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "post";
    }
    
    @GetMapping("/Post/{postId}")
    public String detailsView(Model model, @PathVariable(value = "postId") int id) {
        model.addAttribute("post", this.ps.getPostById(id));
        model.addAttribute("major", this.ms.getMajor());
        model.addAttribute("image", this.is.getImageByPostId(id));
        return "post";
    }
}
