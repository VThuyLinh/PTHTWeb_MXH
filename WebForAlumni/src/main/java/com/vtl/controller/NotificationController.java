/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Notification;
import com.vtl.service.TeamNotificationService;
//import com.vtl.service.TeampService;
import com.vtl.service.MajorService;
import com.vtl.service.NotificationService;
import com.vtl.service.TeamService;
import com.vtl.service.TeamUserService;
import com.vtl.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thuy Linh
 */
@Controller
public class NotificationController {

    @Autowired
    private NotificationService noService;
    @Autowired
    private UserService us;

    @Autowired
    private MajorService ms;
    @Autowired
    private TeamNotificationService tns;
    
    @Autowired
    private TeamUserService tus;
    
    @Autowired
    private TeamService ts;
//    @Autowired
//    private TeampService gs;
    
    @RequestMapping("/Notification")
    public String getNo(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("notification", this.noService.getNotification(params));
         model.addAttribute("major", this.ms.getMajor());
        return "notification";
    }
    
    @GetMapping("/Notification/{noId}")
    public String detailsView(Model model, @PathVariable(value = "noId") int id) {
          model.addAttribute("noDetail", this.noService.getNoById(id));
          model.addAttribute("team", this.ts.getTeam());
          model.addAttribute("teamNoti", this.tns.getTeam());
          model.addAttribute("teamUser", this.tus.getTeamUser());
//        model.addAttribute("cmt", this.cs.getListCommentById(id));
          model.addAttribute("user", this.us.getInfoAllUser());
//           model.addAttribute("group", this.gs.getTeam());
          
        return "noDetail";
    }
    
    @PostMapping("/Notification/{noId}")
    public String createNo(Model model, @ModelAttribute(value = "noDetail") @Valid Notification n,BindingResult rs )
        {
        
        if (rs.hasErrors())
            return "noDetail";
        
        try {
            this.noService.addOrUpdateNo(n);
            return "redirect:/Notification";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "noDetail";
    }
    
    
    
    @GetMapping("/AddNotification")
    public String addNotificationView(Model model) {
        Notification n = new Notification();
        model.addAttribute("addNotification", n);
//        model.addAttribute("topic", this.ts.getAllTopic());
//        model.addAttribute("major", this.ms.getMajor());
//        model.addAttribute("user", this.us.getInfoAllUser());

        return "addNotification";
    }

    @PostMapping("/AddNotification")
    public String addNotification(Model model, @ModelAttribute(value = "addNotification") @Valid Notification n, BindingResult rs) {
        if (rs.hasErrors()) {
            rs.getFieldErrors().stream().forEach(f -> System.out.println(f.getField() + ": " + f.getDefaultMessage()));
            return "addNotification";
        }
        try {

            this.noService.addOrUpdateNo(n);
            
            return "redirect:/Notification";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addNotification";
    }

}
