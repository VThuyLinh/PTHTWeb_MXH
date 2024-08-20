/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.service.MajorService;
import com.vtl.service.NotificationService;
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
public class NotificationController {

    @Autowired
    private NotificationService noService;

    @Autowired
    private MajorService ms;
    
    @RequestMapping("/Notification")
    public String getNo(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("notification", this.noService.getNotification(params));
         model.addAttribute("major", this.ms.getMajor());
        return "notification";
    }
}
