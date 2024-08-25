/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.TeamNotification;

import com.vtl.repository.TeamNotificationRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thuy Linh
 */
@Repository
@Transactional
public class TeamNotificationRepositoryImpl implements  TeamNotificationRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<TeamNotification> getTeam()
    {
         Session s= this.factory.getObject().getCurrentSession();
           Query q= s.createNamedQuery("TeamNotification.findAll");
//           CriteriaBuilder b= s.getCriteriaBuilder();
//            CriteriaQuery<TeamNotification> q= b.createQuery(TeamNotification.class);
//            Root <TeamNotification> rG= q.from(TeamNotification.class);
//            q.multiselect(rG.get("id"),rG.get("teamId"),rG.get("noId"),rG.get("createdDate"));
////            q.where(b.equal(rG.get("noId"), 3));
//            Query query= s.createQuery(q);
            return q.getResultList();
        }
        
    }
    
//    @Override
//    public TeamNotification getTeampById(int id)
//    {
//        Session s= this.factory.getObject().getCurrentSession();
//        
//           Query q= s.createNamedQuery("TeamNotification.findById");
//            q.setParameter("id", id);
//            return (TeamNotification) q.getSingleResult();
//        
//    }


