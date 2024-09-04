/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Post;
import com.vtl.service.CommentService;
import com.vtl.service.LikeHahaService;
import com.vtl.service.MajorService;
import com.vtl.service.PostService;
import com.vtl.service.TopicService;
import com.vtl.service.UserService;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
    private LikeHahaService ls;
    @Autowired
    private CommentService cs;
    @Autowired
    private UserService us;
    @Autowired
    private TopicService ts;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/Post/{postId}")
    public String detailsView(Model model, @PathVariable(value = "postId") int id) {
        model.addAttribute("post", this.ps.getPostById(id));
        model.addAttribute("major", this.ms.getMajor());
        model.addAttribute("cmt", this.cs.getListCommentByPostId(id));
        model.addAttribute("like", this.ls.getCountLikeonPost(id));
        model.addAttribute("user", this.us.getInfoAllUser());
        model.addAttribute("topic", this.ts.getAllTopic());
        return "post";
    }

    @PostMapping("/Post")
    public String UpPost(Model model, @ModelAttribute(value = "post") @Valid Post p, BindingResult rs) {
        if (rs.hasErrors()) {
            rs.getFieldErrors().stream().forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));
            return "post";
        }
        try {

            this.ps.addOrUpdatePost(p);
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "post";
    }

    @GetMapping("/AddPost")
    public String addPostView(Model model) {
        Post p = new Post();
        model.addAttribute("addPost", p);
        model.addAttribute("topic", this.ts.getAllTopic());
        model.addAttribute("major", this.ms.getMajor());
        model.addAttribute("user", this.us.getInfoAllUser());

        return "addPost";
    }

    @PostMapping("/AddPost")
    @CrossOrigin
    public String addPost(Model model, @ModelAttribute(value = "addPost") @Valid Post p, BindingResult rs) {
        if (rs.hasErrors()) {
            rs.getFieldErrors().stream().forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));
            return "addPost";
        }
        try {
            
            this.ps.addOrUpdatePost(p);

            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addPost";
    }

}
