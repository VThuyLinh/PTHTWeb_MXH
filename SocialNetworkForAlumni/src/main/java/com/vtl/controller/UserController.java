/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.component.JwtService;
import com.vtl.filter.JwtAuthenticationTokenFilter;
import com.vtl.pojo.User;
import com.vtl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Thuy Linh
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService us;
    @Autowired
    private JwtService js;
    
    @GetMapping("/login")
    public String login()
    {
        return"login";
    }
    
    
    @GetMapping("/Users")
    public String getUsers(Model model)
    {
        model.addAttribute("user", this.us.getInfoAllUser());
        return"users";
    }
    
    
    
    
    
    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user ,Model model) {
        if (this.us.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.js.generateTokenLogin(user.getUsername());
            
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
}
