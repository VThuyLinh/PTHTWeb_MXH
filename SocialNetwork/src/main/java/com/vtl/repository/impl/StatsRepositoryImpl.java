/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;


import com.vtl.pojo.Post;
import com.vtl.pojo.User;

import com.vtl.socialnetwork.HibernateUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 *
 * @author Thuy Linh
 */
public class StatsRepositoryImpl {

    public Long countUser() throws ParseException, SQLException {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Long> q= b.createQuery(Long.class);
            Root <User> rU= q.from(User.class);
            q.multiselect(b.count(rU.get("id")));
            Query query= s.createQuery(q);
            return (Long) query.getSingleResult();
        }
    }
    
    
    public List<Object[]> countPostByUserId() throws ParseException, SQLException {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q= b.createQuery(Object[].class);
            Root <User> rU= q.from(User.class);
            Root <Post> rP= q.from(Post.class);
            q.where(b.equal(rU.get("id"), rP.get("userPostId")));
            q.multiselect(b.count(rU.get("id")),rU.get("username"));
            q.groupBy(rU.get("username"));
            Query query= s.createQuery(q);
            return query.getResultList();
        }
    }
    
    

    public List<Object[]> statsRevenuePostByYear(int year) throws ParseException {
        try ( Session s = HibernateUtils.getFactory().openSession()) {

            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rP = q.from(Post.class);

            q.where(b.equal(b.function("YEAR", Integer.class, rP.get("createdDate")), year));

            q.multiselect(rP.get("id"), rP.get("topic"), rP.get("likeHahaHeart"), rP.get("createdDate"));
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }

    public List<Object[]> statsRevenuePostByMonth(int month) throws ParseException {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            if (month < 0 || month > 12) {
                System.out.println("Nh?p dúng tháng b?n nhé");
            }
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rP = q.from(Post.class);

            q.where(b.equal(b.function("MONTH", Integer.class, rP.get("createdDate")), month));

            q.multiselect(rP.get("id"), rP.get("topic"), rP.get("likeHahaHeart"), rP.get("createdDate"));

            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }

    public List<Object[]> statsCreatedDateByPeriod(int year, String period) throws ParseException {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rP = q.from(Post.class);

            q.where(b.equal(b.function("YEAR", Integer.class, rP.get("createdDate")), year));

            q.multiselect(b.function(period, Integer.class, rP.get("createdDate")), rP.get("content"));
//           

            Query query = s.createQuery(q);

            return query.getResultList();
        }

    }
}
