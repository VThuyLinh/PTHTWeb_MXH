/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Team;
import com.vtl.repository.TeamRepository;
import com.vtl.service.TeamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class TeamServiceImpl implements  TeamService{
    
    @Autowired
    private TeamRepository tr;

    @Override
    public List<Team> getTeam() {
      return this.tr.getTeam();
    }
    
}
