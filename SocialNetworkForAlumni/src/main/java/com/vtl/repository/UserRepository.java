/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.repository;

import com.vtl.pojo.User;

/**
 *
 * @author Thuy Linh
 */
public interface UserRepository {
    public User getInfoUserByUsername(String username);
     public User getInfoUserById(int id);
}
