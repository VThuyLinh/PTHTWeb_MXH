/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.repository;

import com.vtl.pojo.Post;
import com.vtl.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thuy Linh
 */
//public interface UserRepository {
//    public User getInfoUserByUsername(String username);
//    public User getInfoUserById(int id);
//    public List<User> getInfoAllUser();
//    public void addUser(User u) ;
//    public boolean authUser(String username, String password);
//}
public interface UserRepository {

    User getUserByUsername(String username);

    boolean authUser(String username, String password);

    User addUser(User user);

    public List<User> getInfoAllUser(Map<String, String> params);
     public List<User> getAllUser();

    public User getInfoUserById(int id);

    public void deleteUser(int id);

    public void updateUser(User u);

    public User getUserByUsernames(String username);

    public List<User> getUserWithRoleStudent();

    public List<User> getUserWithRoleLecturer();
}
