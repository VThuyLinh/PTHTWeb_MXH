/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.formatter;

import com.vtl.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Thuy Linh
 */
public class UserFormatter implements Formatter<User> {
    
    //Java do ra
    @Override
    public String print(User u, Locale locale) {
        return String.valueOf(u.getId());
    }

    @Override
    public User parse(String userId, Locale locale) throws ParseException {
        User u = new User();
        u.setId(Integer.parseInt(userId));
        
        return u;
    }
}
