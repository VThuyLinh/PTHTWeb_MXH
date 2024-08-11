/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.repository.impl;

import com.vtl.pojo.User;
import com.vtl.socialnetwork.HibernateUtils;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author Thuy Linh
 */
public class UserRepositoryImpl {
    public User getInfoUserByUsername(String username)
    {
        try(Session s= HibernateUtils.getFactory().openSession())
        {
            Query q= s.createNamedQuery("User.findByUsername");
            q.setParameter("username", username);
            return (User) q.getSingleResult();
        }
    }
}
