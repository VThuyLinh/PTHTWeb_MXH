/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.User;
import com.vtl.repository.UserRepository;

import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thuy Linh
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
     
    @Override
    public User getInfoUserByUsername(String username)
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("User.findByUsername");
            q.setParameter("username", username);
            return (User) q.getSingleResult();
        
    }
    
    @Override
    public User getInfoUserById(int id)
    {
        Session s= this.factory.getObject().getCurrentSession();
        
            Query q= s.createNamedQuery("User.findById");
            q.setParameter("id", id);
            return (User) q.getSingleResult();
        
    }
}
