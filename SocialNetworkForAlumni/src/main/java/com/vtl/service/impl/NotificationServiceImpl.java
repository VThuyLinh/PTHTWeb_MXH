/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Notification;
import com.vtl.repository.NotificationRepository;
import com.vtl.service.NotificationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository nr;

    
    

    @Override
    public List<Notification> getNotification(Map<String, String> params) {
       return nr.getNotification(params);
    }
    
    
   
}
