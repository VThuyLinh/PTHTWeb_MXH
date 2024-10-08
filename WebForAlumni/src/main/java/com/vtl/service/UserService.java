/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtl.service;

import com.vtl.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thuy Linh
 */
public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);

    boolean authUser(String username, String password);

    User addUser(Map<String, String> params, MultipartFile avatar, MultipartFile cover);

    public List<User> getInfoAllUser(Map<String, String> params);
    public List<User> getAllUser();

    public User getInfoUserById(int id);

    public void deleteUser(int id);

    public void updateUser(User u);

    public User getUserByUsernames(String username);

    public List<User> getUserWithRoleStudent();

    public List<User> getUserWithRoleLecturer();

}
