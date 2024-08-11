/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;



import com.vtl.pojo.Comment;
import com.vtl.socialnetwork.HibernateUtils;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

/**
 *
 * @author Thuy Linh
 */
public class CommentRepositoryImpl {
     public List<Comment> getComment() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createQuery("From Comment");
            return q.getResultList();
        }
        
    }
}
