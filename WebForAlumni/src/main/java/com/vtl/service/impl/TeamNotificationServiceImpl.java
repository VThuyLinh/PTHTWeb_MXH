/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.TeamNotification;
import com.vtl.repository.TeamNotificationRepository;
import com.vtl.service.TeamNotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class TeamNotificationServiceImpl implements TeamNotificationService{
    @Autowired
    private TeamNotificationRepository tnr;

    

//    @Override
//    public TeamNotification getTeampById(int id) {
//        return this.gr.getTeampById(id);
//    }

    @Override
    public List<TeamNotification> getTeam() {
       return this.tnr.getTeam();
    }
}
