/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.formatter;

import com.vtl.pojo.Department;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Thuy Linh
 */
public class DepartmentFormatter implements Formatter<Department>{
    
    
    @Override
    public String print(Department d, Locale locale) {
        return String.valueOf(d.getId());
    }

    @Override
    public Department parse(String departmentId, Locale locale) throws ParseException {
        Department d = new Department();
        d.setId(Integer.parseInt(departmentId));
        
        return d;
    }
}
