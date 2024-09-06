/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Post;
import com.vtl.repository.PostRepository;
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
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    private static final int PAGE_SIZE = 6;

    @Override
    public List<Post> getPost(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root<Post> root = q.from(Post.class);
        q.where(b.equal(root.get("active"), true));

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("content"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            String topic = params.get("topic");
            if (topic != null && !topic.isEmpty()) {
                Predicate p2 = b.equal(root.get("topicidforPost"), Integer.parseInt(topic));
                predicates.add(p2);
            }

            String fromDate = params.get("fromDate");
            if (fromDate != null && !fromDate.isEmpty()) {
                Predicate p3 = b.greaterThanOrEqualTo(root.get("createdDate"), Date.valueOf(fromDate));
                predicates.add(p3);
            }

            String toDate = params.get("toDate");
            if (toDate != null && !toDate.isEmpty()) {
                Predicate p4 = b.lessThanOrEqualTo(root.get("createdDate"), Date.valueOf(toDate));
                predicates.add(p4);
            }

            String major = params.get("major");
            if (major != null && !major.isEmpty()) {
                Predicate p5 = b.equal(root.get("majoridforPost"), Integer.parseInt(major));
                predicates.add(p5);
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

    @Override
    public void addOrUpdatePost(Post p) {
        Session s = this.factory.getObject().getCurrentSession();
        if (p.getId() != null) {
            s.update(p);
        } else {
            s.save(p);
        }

    }

    @Override
    public Post getPostById(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        return s.get(Post.class, id);

    }

    @Override
    public void deletePost(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Post p = this.getPostById(id);
        s.delete(p);
    }

    @Override
    public List<Post> getPostActive() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root<Post> rP = q.from(Post.class);
        q.where(b.equal(rP.get("active"), true));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Post> getPostByUserId(int userId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root<Post> rP = q.from(Post.class);
        q.where(b.equal(rP.get("useridforPost"), userId));
        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Post addPost(Post post) {
        Session s = this.factory.getObject().getCurrentSession();
        
        s.save(post);

        return post;
    }
}
