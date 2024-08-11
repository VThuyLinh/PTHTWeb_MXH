/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.service.impl;

import com.vtl.pojo.User;
import com.vtl.repository.UserRepository;
import com.vtl.service.UserService;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thuy Linh
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository us ;
    @Override
    public User getInfoUserByUsername(String username) {
       return us.getInfoUserByUsername(username);
    }
    
    
    @Override
    public User getInfoUserById(int id)
    {
            return us.getInfoUserById(id);
        
    }
    
}
