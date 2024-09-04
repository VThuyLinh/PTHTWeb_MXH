/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.Major;
import com.vtl.repository.MajorRepository;
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
public class MajorRepositoryImpl implements MajorRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Major> getMajor()
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("Major.findAll");
           
             return q.getResultList();
        
    }
     @Override
    public Major getMajorById(int id)
    {
        Session s = this.factory.getObject().getCurrentSession();
        
         CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Major> q = b.createQuery(Major.class);

            Root rM = q.from(Major.class);

            q.where(b.equal(rM.get("id"),id));

            q.multiselect(rM.get("id"), rM.get("name"));
            Query query = s.createQuery(q);
            return (Major) query.getSingleResult();
        
    }
    
    @Override
    public Major getMajorByName(String name)
    {
        Session s = this.factory.getObject().getCurrentSession();
        
        return s.get(Major.class, name);
        
    }

}
