/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Thuy Linh
 */
@Controller


public class LogoutController {
    @ModelAttribute("user")
    public User user(){
        return new User();
    }
    @GetMapping("/Logout")
    public String Logout(@ModelAttribute("user") User u, WebRequest request, SessionStatus status){

        status.setComplete();
        request.removeAttribute("user",WebRequest.SCOPE_SESSION);
        return "redirect:/Loginn";
    }
}
