/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.User;
import com.vtl.repository.UserRepository;
import java.util.List;

import javax.persistence.Query;
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
//@Repository
//@Transactional
//public class UserRepositoryImpl implements UserRepository{
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    
//    @Autowired
//    private BCryptPasswordEncoder passEncoder;
//     
//    @Override
//    public User getInfoUserByUsername(String username)
//    {
//        Session s= this.factory.getObject().getCurrentSession();
//        
//            Query q= s.createNamedQuery("User.findByUsername");
//            q.setParameter("username", username);
//            return (User) q.getSingleResult();
//        
//    }
//    
//    @Override
//    public User getInfoUserById(int id)
//    {
//        Session s= this.factory.getObject().getCurrentSession();
//        
//            Query q= s.createNamedQuery("User.findById");
//            q.setParameter("id", id);
//            return (User) q.getSingleResult();
//        
//    }
//    
//    @Override
//    public List<User> getInfoAllUser()
//    {
//        Session s= this.factory.getObject().getCurrentSession();
//        
//            Query q= s.createNamedQuery("User.findAll");
//           
//            return q.getResultList();
//        
//    }
//    
//    @Override
//    public void addUser(User u) {
//        Session s = this.factory.getObject().getCurrentSession();
//        if (u.getId() != null) {
//            s.update(u);
//        } else {
//            s.save(u);
//        }
//    }
//    
//    
//    @Override
//    public boolean authUser(String username, String password) {
//        User  u = this.getInfoUserByUsername(username);
//        
//        return this.passEncoder.matches(password, u.getPassword());
//    }
//    
//}


@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);

        return (User) q.getSingleResult();

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
    public List<User> getInfoAllUser()
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("User.findAll");
           
            return q.getResultList();
        
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
