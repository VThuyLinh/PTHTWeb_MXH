/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Image;
import com.vtl.pojo.User;

import com.vtl.repository.ImageRepository;
import java.util.ArrayList;

import java.util.List;

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
public class ImageRepositoryImpl implements ImageRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

//    private static final int PAGE_SIZE = 2;
    @Override
    public List<Object> getImageByPostId(int postId) {

        Session s= this.factory.getObject().getCurrentSession();

            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Image> q = b.createQuery(Image.class);
            Root root = q.from(Image.class);
            q.select(root);
            List<Predicate> predicates = new ArrayList<>();

            Predicate p1 = b.equal(root.get("postId"), postId);
            predicates.add(p1);

            q.where(predicates.toArray(Predicate[]::new));
        

        Query query = s.createQuery(q);

        return query.getResultList();
        }
    
    
}
    
    
