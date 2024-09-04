/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;


import com.vtl.pojo.Post;
import com.vtl.pojo.User;
import com.vtl.repository.StatsRepository;




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
public class StatsRepositoryImpl implements StatsRepository {

    
    @Autowired
    private LocalSessionFactoryBean factory;

   
    @Override
    public Long countUser() {
         Session s= this.factory.getObject().getCurrentSession();
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Long> q= b.createQuery(Long.class);
            Root <User> rU= q.from(User.class);
            q.multiselect(b.count(rU.get("id")));
            Query query= s.createQuery(q);
            return (Long) query.getSingleResult();
        }
    
    
    
    @Override
    public List<Object[]> countPostByUserId(){
        Session s= this.factory.getObject().getCurrentSession();
            CriteriaBuilder b= s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q= b.createQuery(Object[].class);
            Root <User> rU= q.from(User.class);
            Root <Post> rP= q.from(Post.class);
            q.where(b.equal(rU.get("id"), rP.get("useridforPost")));
            q.multiselect(b.count(rU.get("id")),rU.get("username"));
            q.groupBy(rU.get("username"));
            Query query= s.createQuery(q);
            return query.getResultList();
        }
    
    
    

    @Override
    public List<Object[]> statsRevenuePostByYear(int year){
        Session s= this.factory.getObject().getCurrentSession();

            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rP = q.from(Post.class);

            q.where(b.equal(b.function("YEAR", Integer.class, rP.get("createdDate")), year));

            q.multiselect(b.count(rP.get("id")), rP.get("createdDate"));
            q.groupBy(rP.get("createdDate"));
            Query query = s.createQuery(q);
            return query.getResultList();
        
    }

    @Override
    public List<Object[]> statsRevenuePostByMonth(int month) {
        Session s= this.factory.getObject().getCurrentSession();
            
            if (month < 0 || month > 12) {
                System.out.println("Nh?p dúng tháng b?n nhé");
            }
            
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rP = q.from(Post.class);

            q.where(b.equal(b.function("MONTH", Integer.class, rP.get("createdDate")), month));
                
            
            q.multiselect(b.count(rP.get("id")), rP.get("createdDate"));
            q.groupBy(rP.get("createdDate"));
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    

    @Override
    public List<Object[]> statsCreatedDateByPeriod(int year, String period){
         
         Session s= this.factory.getObject().getCurrentSession();
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
