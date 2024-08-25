/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.Team;
import com.vtl.pojo.TeamUser;
import com.vtl.repository.TeamRepository;
import com.vtl.repository.TeamUserRepository;
import com.vtl.service.TeamService;
import com.vtl.service.TeamUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class TeamUserServiceImpl implements  TeamUserService{
    
    @Autowired
    private TeamUserRepository tur;

    @Override
    public List<TeamUser> getTeamUser() {
      return this.tur.getTeamUser();
    }
    
}
