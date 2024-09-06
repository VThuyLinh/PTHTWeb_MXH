/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.User;
import com.vtl.repository.UserRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thuy Linh
 */



@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

     private static final int PAGE_SIZE = 3;
    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);

        return (User) q.getSingleResult();

    }
    
    
    @Override
    public List<User> getUserWithRoleStudent()
    {
        Session s = this.factory.getObject().getCurrentSession();
        
         CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<User> q = b.createQuery(User.class);

            Root rU = q.from(User.class);

            q.where(b.equal(rU.get("role"),"ROLE_STUDENT"));

            q.multiselect(rU.get("id"), rU.get("username"));
            Query query = s.createQuery(q);
            return query.getResultList();
        
    }
    
    @Override
    public List<User> getUserWithRoleLecturer()
    {
        Session s = this.factory.getObject().getCurrentSession();
        
         CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<User> q = b.createQuery(User.class);

            Root rU = q.from(User.class);

            q.where(b.equal(rU.get("role"),"ROLE_LECTURER"));

            q.multiselect(rU.get("id"), rU.get("username"));
            Query query = s.createQuery(q);
            return  query.getResultList();
        
    }
    
    
    @Override
    public User getUserByUsernames(String username)
    {
        Session s = this.factory.getObject().getCurrentSession();
        
         CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<User> q = b.createQuery(User.class);

            Root rU = q.from(User.class);

            q.where(b.equal(rU.get("username"),username));

            q.multiselect(rU.get("id"), rU.get("username"));
            Query query = s.createQuery(q);
            return (User) query.getSingleResult();
        
    }
    
    
    @Override
    public boolean authUser(String username, String password) {
        User  u = this.getUserByUsername(username);
        
        return this.passEncoder.matches(password, u.getPassword());
    }
    
    @Override
    public User addUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(u);
        
        return u;
    }
    
     @Override
    public List<User> getAllUser()
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("User.findAll");
           
            return q.getResultList();
        
    }
    
    
    @Override
    public List<User> getInfoAllUser( Map<String, String> params )
    {
        Session s= this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root<User> root = q.from(User.class);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("lastname"), String.format("%%%s%%", kw));
                predicates.add(p1);
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
    public User getInfoUserById(int id)
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("User.findById");
            q.setParameter("id", id);
            return (User) q.getSingleResult();
    }
    
    @Override
    public void deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        User u = this.getInfoUserById(id);
        s.delete(u);
    }
    
    
    @Override
    public void updateUser(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        if (u.getId() != null) 
            s.update(u);
    }
}
