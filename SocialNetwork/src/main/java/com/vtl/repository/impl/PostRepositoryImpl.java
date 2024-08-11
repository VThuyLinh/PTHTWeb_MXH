/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Post;
import com.vtl.socialnetwork.HibernateUtils;
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
public class PostRepositoryImpl {
    private static final int PAGE_SIZE = 3;
    
    public List<Post> getPost(Map<String, String> params) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Post> q = b.createQuery(Post.class);
            Root root = q.from(Post.class);
            q.select(root);
            if (params != null) {
                List<Predicate> predicates = new ArrayList<>();
                String kw = params.get("q");
                if (kw != null && !kw.isEmpty()) {
                    Predicate p1 = b.like(root.get("content"), String.format("%%%s%%", kw));
                    predicates.add(p1);
                }

                String fromDate = params.get("fromDate");
                if (fromDate != null && !fromDate.isEmpty()) {
                    Predicate p2 = b.greaterThanOrEqualTo(root.get("created_date"), Double.parseDouble(fromDate));
                    predicates.add(p2);
                }

                String toDate = params.get("toDate");
                if (toDate != null && !toDate.isEmpty()) {
                    Predicate p3 = b.lessThanOrEqualTo(root.get("created_date"), Double.parseDouble(toDate));
                    predicates.add(p3);
                }

                String major = params.get("major");
                if (major != null && !major.isEmpty()) {
                    Predicate p4 = b.like(root.get("major_id"), String.format("%%%s%%", major));
                    predicates.add(p4);
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
    
    public void addOrUpdatePost(Post p) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            if (p.getId() != null)
                s.update(s);
            else
                s.save(s);
        }
    }
    
    
    
    
    public Post getPostByTopic(int majorId) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            return s.get(Post.class, majorId);
        }
    }
    
    
    
    
}
