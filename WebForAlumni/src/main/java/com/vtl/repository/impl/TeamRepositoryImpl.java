/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Team;
import com.vtl.repository.TeamRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thuy Linh
 */

@Transactional
@Repository
public class TeamRepositoryImpl implements  TeamRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Team> getTeam()
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("Team.findAll");
           
             return q.getResultList();
        
    }
}
