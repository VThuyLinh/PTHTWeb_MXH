/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;



import com.vtl.pojo.LikeHaha;
import com.vtl.repository.LikeHahaRepository;
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
public class LikeHahaRepositoryImpl implements LikeHahaRepository {
    
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
     public Long getCountLikeonPost(int post)  {

        Session s= this.factory.getObject().getCurrentSession();

            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Long> q= b.createQuery(Long.class);
            Root <LikeHaha> rL= q.from(LikeHaha.class);
            q.multiselect(b.count(rL.get("id")));
            q.where(b.equal(rL.get("postId"), post));
            q.groupBy(rL.get("postId"));
            Query query= s.createQuery(q);
            return (Long) query.getSingleResult();
        }
    
    @Override
    public LikeHaha addLike (LikeHaha like) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(like);
        
        return like;
    }
    
    @Override
    public List<LikeHaha> getAllLikeByPostId(int postId) 
    {
           Session s= this.factory.getObject().getCurrentSession();
           CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<LikeHaha> q= b.createQuery(LikeHaha.class);
            Root <LikeHaha> rP= q.from(LikeHaha.class);
            q.where(b.equal(rP.get("postId"), postId));
            Query query= s.createQuery(q);
            return query.getResultList();
        }
    
    @Override
    public void addOrUpdateLike(LikeHaha l) {
        Session s = this.factory.getObject().getCurrentSession();
        if (l.getId() != null) {
            s.update(l);
        } else {
            s.save(l);
        }

    }
    
}
