/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Image;
import com.vtl.socialnetwork.HibernateUtils;
import java.util.ArrayList;

import java.util.List;

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
public class ImageRepositoryImpl {

    public List<Image> getImage(int postId) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
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

//    public  getImageByPostId(int postId) {
//
//        try ( Session s = HibernateUtils.getFactory().openSession()) {
//
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<Image> q = b.createQuery(Image.class);
//
//            Root rI = q.from(Image.class);
////
////            q.where(b.equal(b.function("YEAR", Integer.class, rP.get("createdDate")), year));
//            q.where(b.equal(rI.get("id"), postId));
//
//            q.multiselect(rI.get("path"), rI.get("id"));
//
//            Query query = s.createQuery(q);
//            return query.getResultList();
//        }
}
//    public Image getPostByTopic(int postId) {
//        try (Session s = HibernateUtils.getFactory().openSession()) {
//            return s.get(Image.class, postId);
//        }
//    }
}
