/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Notification;
import com.vtl.pojo.Post;
import com.vtl.socialnetwork.HibernateUtils;

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

/**
 *
 * @author Thuy Linh
 */
public class NotificationRepositoryImpl {

    private static final int PAGE_SIZE = 3;
    
    public List<Notification> getNotification(Map<String, String> params) {
         try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Notification> q = b.createQuery(Notification.class);
            Root root = q.from(Notification.class);
            q.select(root);
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("q");
                if (kw != null && !kw.isEmpty()) {
                    Predicate p1 = b.like(root.get("content"), String.format("%%%s%%", kw));
                    predicates.add(p1);
                }

                

                q.where(predicates.toArray(Predicate[]::new));
            }

            Query query = s.createQuery(q);

            if (params != null) {
                String page = params.get("page");
                if (page != null && !page.isEmpty()) {
                    int p = Integer.parseInt(page);
                    int start = (p - 1) * PAGE_SIZE;
                    
                    query.setFirstResult(start);
                    query.setMaxResults(PAGE_SIZE);
                }
            }
            
            return query.getResultList();
        }
}
}
