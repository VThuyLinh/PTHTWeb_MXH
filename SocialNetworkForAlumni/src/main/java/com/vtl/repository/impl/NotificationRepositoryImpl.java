/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Notification;
import com.vtl.repository.NotificationRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class NotificationRepositoryImpl implements NotificationRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    
    
    
    
    
    @Override
    public List<Notification> getNotification( Map<String, String> params){
        Session s= this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Notification> q = b.createQuery(Notification.class);
        Root root = q.from(Notification.class);
        
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String time = params.get("time");
            if (time != null && !time.isEmpty()) {
                Predicate p1 = b.equal(root.get("time"), Date.valueOf(time));
                predicates.add(p1);
            }

            String cdate = params.get("cdate");
            if (cdate != null && !cdate.isEmpty()) {
                Predicate p2 = b.equal(root.get("createdDate"), Date.valueOf(cdate));
                predicates.add(p2);
            }

            String ct = params.get("content");
            if (ct != null && !ct.isEmpty()) {
                Predicate p4 = b.like(root.get("content"), String.format("%%%s%%", ct));
                predicates.add(p4);
            }
            
            q.where(predicates.toArray(Predicate[]::new));
        }
       
            Query query = s.createQuery(q);
            return query.getResultList();
    }
}
