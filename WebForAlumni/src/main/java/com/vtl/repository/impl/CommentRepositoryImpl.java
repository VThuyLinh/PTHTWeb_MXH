/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;



import com.vtl.pojo.Comment;
import com.vtl.repository.CommentRepository;
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
public class CommentRepositoryImpl implements CommentRepository {
    
    private static final int PAGE_SIZE = 2;
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
     public List<Comment> getComment(Map<String, String> params) {
         Session s= this.factory.getObject().getCurrentSession();
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Comment> q= b.createQuery(Comment.class);
            Root <Comment> rC= q.from(Comment.class);
            q.where(b.equal(rC.get("active"), true));
            Query query= s.createQuery(q);
            
            
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
     
    @Override
    public void deleteComment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Comment c = this.getCommentById(id);
        s.delete(c);
    }
    
    @Override
    public Comment getCommentById(int id)
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("Comment.findById");
            q.setParameter("id", id);
            return (Comment) q.getSingleResult();
        
    }
    
  
    
    
    @Override
    public List<Comment> getListCommentByPostId(int postId) {

        Session s= this.factory.getObject().getCurrentSession();

            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Comment> q = b.createQuery(Comment.class);
            Root root = q.from(Comment.class);
            q.select(root);
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("postId"), postId);
            predicates.add(p1);

            q.where(predicates.toArray(Predicate[]::new));
        

        Query query = s.createQuery(q);

        return query.getResultList();
        }
    
    @Override
    public Comment addComment (Comment cmt) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(cmt);
        
        return cmt;
    }
    
}
