/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import com.vtl.pojo.Notification;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thuy Linh
 */
public interface NotificationService {
  
    public List<Notification> getNotification( Map<String, String> params);
    public void deleteNotification(int id);
    public Notification getNoById(int id);
    public List<Notification> getListNoById(int id);
    public void addOrUpdateNo(Notification n);
}
