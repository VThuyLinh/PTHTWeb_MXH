/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;



import com.vtl.pojo.Comment;
import com.vtl.repository.CommentRepository;


import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thuy Linh
 */
@Repository
public class CommentRepositoryImpl implements CommentRepository {
    
    private static final int PAGE_SIZE = 2;
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
     public List<Comment> getComment(Map<String, String> params) {
         Session s= this.factory.getObject().getCurrentSession();
            Query q = s.createQuery("From Comment");
            
            
            if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                q.setFirstResult(start);
                q.setMaxResults(PAGE_SIZE);
            }
        }

        return q.getResultList();
        
        
    }
}
