/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Major;
import com.vtl.pojo.Topic;
import com.vtl.service.MajorService;
import com.vtl.service.TopicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Thuy Linh
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiMajorController {
    @Autowired
    private MajorService ms;
    
    @GetMapping("/Major")
    public ResponseEntity<List<Major>> list() {
        return new ResponseEntity<>(this.ms.getMajor(), HttpStatus.OK);
    }
}
