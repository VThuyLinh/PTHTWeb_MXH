/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.formatter;

import com.vtl.pojo.Major;
import com.vtl.pojo.Post;
import com.vtl.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Thuy Linh
 */
public class MajorFormatter implements Formatter<Major> {
    
    //Java do ra
    @Override
    public String print(Major m, Locale locale) {
        return String.valueOf(m.getId());
    }

    @Override
    public Major parse(String majorId, Locale locale) throws ParseException {
        Major p = new Major();
        p.setId(Integer.parseInt(majorId));
        
        return p;
    }
}
