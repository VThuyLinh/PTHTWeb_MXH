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

    @Override
    public void deleteNotification(int id) {
        this.nr.deleteNotification(id);
    }

    @Override
    public Notification getNoById(int id) {
        return this.nr.getNoById(id);
    }

    @Override
    public List<Notification> getListNoById(int id) {
       return this.nr.getListNoById(id);
    }

    @Override
    public void addOrUpdateNo(Notification n) {
      this.nr.addOrUpdateNo(n);
        
    }
    
}
