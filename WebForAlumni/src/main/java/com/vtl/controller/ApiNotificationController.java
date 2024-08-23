/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.controller;

import com.vtl.pojo.Notification;
import com.vtl.service.NotificationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thuy Linh
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiNotificationController {
    @Autowired
    private NotificationService ns;
    @DeleteMapping("/Notification/{noId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value="noId") int id)
    {
        this.ns.deleteNotification(id);
    }
    
    
    @GetMapping("/Notification")
    public ResponseEntity<List<Notification>> list(@RequestParam Map<String, String> params) {
        List<Notification> noti = this.ns.getNotification(params);
        
        return new ResponseEntity<>(noti, HttpStatus.OK);
    }
    
    
    
}